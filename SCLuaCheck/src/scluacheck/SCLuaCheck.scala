package scluacheck

import java.io.{File, FileReader}

import scala.collection.mutable.ArrayBuffer
import org.antlr.v4.runtime._
import scluacheck.ast._
import scluacheck.parser._
import scluacheck.verify.{BuildSymbolTableVisitor, InferBasicFunctionTypesVisitor, TypedPrettyPrintVisitor, VerifyFunctionIDsVisitor}

object SCLuaCheck extends App {
  // Associates lexer errors with a file path.
  object MyErrorListener extends BaseErrorListener {
    var filePath = ""
    override def syntaxError(recognizer : Recognizer[_,_], offendingSymbol : Object, line : Int,
                             charPositionInLine : Int, msg : String, e : RecognitionException) : Unit = {
      println(filePath + " !!! " + line + ":" + charPositionInLine + " !!! " + msg)
    }
  }

  val ignoreFiles = Array(
    "C:\\Users\\John\\Desktop\\scfa-lua\\mohodata-lua\\lazyvar.lua", // expression '&1&4' at line 108.
    "C:\\Users\\John\\Desktop\\scfa-lua\\mohodata-lua\\system\\MultiEvent.lua", // expression '&1&1 n' at line 9.
    "C:\\Users\\John\\Desktop\\scfa-lua\\mohodata-lua\\tests\\DumpQAVChecklist.lua" // Invalid backslash in string on line 112.
  )
  val failedParsing = new ArrayBuffer[String]
  val failedVerification = new ArrayBuffer[String]
  val failedTypeChecking = new ArrayBuffer[String]

  def test(f : File) : Unit = {
    if (f.isDirectory) {
      for (e <- f.listFiles())
        test(e)
    } else if (!ignoreFiles.contains(f.getAbsolutePath) && (f.getName.endsWith(".lua") || f.getName.endsWith(".bp"))) {
      // Parse the file.
      val input = new ANTLRInputStream(new FileReader(f))
      val lexer = new SCLuaLexer(input)
      lexer.removeErrorListeners()
      MyErrorListener.filePath = f.getAbsolutePath
      lexer.addErrorListener(MyErrorListener)

      val tokens = new CommonTokenStream(lexer)
      val parser = new SCLuaParser(tokens)
      val parseTree = parser.start()

      // Verify the file parsed successfully.
      if (parser.getNumberOfSyntaxErrors > 0) {
        failedParsing += f.getAbsolutePath
      } else {
        // Make an abstract syntax tree to run verifications on.
        val abstractSyntaxTree = ASTFromPTVisitor.visit(parseTree) match {
          case n : FileNode => n
          case _ =>
            println("PARSE ERROR in " + f.getAbsolutePath + ": The parse tree was not parsed into a FileNode.")
            return
        }

        // Run the function ID verification.
        val badFnIDs = VerifyFunctionIDsVisitor.visit(abstractSyntaxTree)
        if (badFnIDs.nonEmpty) {
          val badFnPositions = badFnIDs.map((f : ASTNode) => f.line + ":" + f.column)
          failedVerification +=  "BAD FUNCTION ID in " + f.getAbsolutePath + " at " + badFnPositions.mkString(", ")
        }

        // Run the type checker.
        BuildSymbolTableVisitor.visit(abstractSyntaxTree)

        InferBasicFunctionTypesVisitor.globalTable = BuildSymbolTableVisitor.globalTable
        InferBasicFunctionTypesVisitor.localTable = BuildSymbolTableVisitor.localTable
        try {
          InferBasicFunctionTypesVisitor.visit(abstractSyntaxTree)
          if (InferBasicFunctionTypesVisitor.errors.nonEmpty || InferBasicFunctionTypesVisitor.warnings.nonEmpty) {
            failedTypeChecking ++= InferBasicFunctionTypesVisitor.warnings
            failedTypeChecking ++= InferBasicFunctionTypesVisitor.errors
          }
          if (InferBasicFunctionTypesVisitor.errors.isEmpty) {
            TypedPrettyPrintVisitor.globalTable = InferBasicFunctionTypesVisitor.globalTable
            TypedPrettyPrintVisitor.localTable = InferBasicFunctionTypesVisitor.localTable
            println(TypedPrettyPrintVisitor.visit(abstractSyntaxTree))
          }
        } catch {
          case e : Error => println("TYPE CHECKING FATAL ERROR in " + f.getAbsolutePath)
        }
      }
    }
  }

  val testDir = new File("C:\\Users\\John\\Desktop\\scfa-lua\\lua-lua\\aeonprojectiles.lua")
  test(testDir)
  if (failedParsing.nonEmpty)
    println("Parsing failures:\n  " + failedParsing.mkString("\n  "))
  if (failedVerification.nonEmpty)
    println("Verification failures:\n  " + failedVerification.mkString("\n  "))
  if (failedTypeChecking.nonEmpty)
    println("Type checking failures:\n  " + failedTypeChecking.mkString("\n  "))

  /*val testFile = new File("C:\\Users\\John\\Desktop\\scfa-lua\\mohodata-lua\\sim\\DefaultProjectiles.lua")
  val input = new ANTLRInputStream(new FileReader(testFile))
  val lexer = new SCLuaLexer(input)
  val tokens = new CommonTokenStream(lexer)
  val parser = new SCLuaParser(tokens)
  val parseTree = parser.start()
  val abstractSyntaxTree = ASTFromPTVisitor.visit(parseTree)
  //println(ASTPrettyPrintVisitor.visit(abstractSyntaxTree))
  println(VerifyFunctionIDsVisitor.visit(abstractSyntaxTree))*/

  // mohodata-lua/system contains a lot of the backend magic of Supreme Commander:
  // - Blueprints.lua makes blueprint magic happen and contains information on how mods work
  // - class.lua defines Supreme Commander's class semantics. It reveals that classes are not meant to be changed once defined.
  // - config.lua controls how Lua behaves.
  // - import.lua handles importing files.
  // - saveload.lua reveals C functions used by Lua.
  // - utils.lua defines a lot of very useful functions.

  // mohodata-lua/globalInit.lua reveals that moho is a table of classes exported from C.

  // TODO The type checking/inference system:
  // - Run verifications which allow for a simpler process:
  //   - All function names are known statically (closures allowed)
  //   - TODO anything else?
  // - Build symbol tables for every file.
  // - Infer the types of C functions and report any which could not be easily inferred, so that they can have their return and argument types specified manually.
  // - Infer the return and argument types of any basic function (that is, any function which does not call functions defined outside of its file)
  //   - TODO is mutual recursion OK?


  // TODO Make a pretty print visitor for the AST and verify it produces valid Lua.
  // TODO Determine what assumptions can be made safely in the existing codebase.
  // TODO Create similar language to Lua which is safer because it enforces those assumptions, but which can be represented with a stricter AST.
  // TODO Create visitors which can translate between the Lua AST and the strict AST.
  // TODO Make a pretty print visitor for the strict AST to translate Lua into the new language.
  // TODO Use the Lua pretty print visitor to generate Lua from the new language.
  // TODO Cool things from below.

  // So now the Lua can be (mostly) lexed and parsed. Things to do with this:
  // - Identify C functions which the Lua is using (any function not defined by the Lua)
  // - Identify Lua functions which the C might be using (any function which is not called in the Lua)
  // - (DONE) Verify that new functions are not added to anything with names specified at runtime
  //   - Use this to verify functions exist before they are called.
  //   - Derive interfaces from the way parameters are used in functions to say something about their type.
  //     - Use these interfaces to verify that function calls pass in compatible parameters.
}
