package scluacheck

import java.io.{File, FileWriter}

import scluacheck.ast._
import scluacheck.parser._
import scluacheck.verify._

object SCLuaCheck extends App {
  val ignoreFiles = Array(
    "C:\\Users\\John\\Desktop\\scfa-lua\\mohodata-lua\\lazyvar.lua", // expression '&1&4' at line 108.
    "C:\\Users\\John\\Desktop\\scfa-lua\\mohodata-lua\\system\\MultiEvent.lua", // expression '&1&1 n' at line 9.
    "C:\\Users\\John\\Desktop\\scfa-lua\\mohodata-lua\\tests\\DumpQAVChecklist.lua" // Invalid backslash in string on line 112.
  )

  val inputDir = "C:\\Users\\John\\Desktop\\scfa-lua\\lua-lua\\sim\\"
  val outputDir = "C:\\Users\\John\\Desktop\\sclua-out\\lua-lua\\sim\\"

  def test(f : File) : Unit = {
    if (f.isDirectory) {
      for (e <- f.listFiles())
        test(e)
    } else if (!ignoreFiles.contains(f.getAbsolutePath) && (f.getName.endsWith(".lua") || f.getName.endsWith(".bp"))) {
      // Parse the file.
      println(f.getAbsolutePath)
      val astGenerator = new ASTGenerator
      val abstractSyntaxTree = astGenerator.parseFile(f)
      if (abstractSyntaxTree == null) {
        // If the generator could not make an AST, report the problems.
        astGenerator.printErrors()
      } else {
        // If the AST was successfully created, run verifications on it.
        // Run the function ID verification.
        val badFnIDs = VerifyFunctionIDsVisitor.visit(abstractSyntaxTree)
        if (badFnIDs.nonEmpty) {
          println("Bad function IDs:")
          for (badFnID <- badFnIDs) {
            println(badFnID.line + ":" + badFnID.column + " -> " + badFnID.getClass.getName)
          }
        }

        // Run the type checker.
        BuildSymbolTableVisitor.visit(abstractSyntaxTree)

        InferBasicFunctionTypesVisitor.globalTable = BuildSymbolTableVisitor.globalTable
        InferBasicFunctionTypesVisitor.localTable = BuildSymbolTableVisitor.localTable
        try {
          InferBasicFunctionTypesVisitor.visit(abstractSyntaxTree)
          if (InferBasicFunctionTypesVisitor.warnings.nonEmpty) {
            println("Type checker warnings:")
            for (w <- InferBasicFunctionTypesVisitor.warnings) {
              println("  " + w)
            }
          }
          if (InferBasicFunctionTypesVisitor.errors.nonEmpty) {
            println("Type checker errors:")
            for (e <- InferBasicFunctionTypesVisitor.errors) {
              println("  " + e)
            }
          } else {
            TypedPrettyPrintVisitor.globalTable = InferBasicFunctionTypesVisitor.globalTable
            TypedPrettyPrintVisitor.localTable = InferBasicFunctionTypesVisitor.localTable
            //println(TypedPrettyPrintVisitor.visit(abstractSyntaxTree))
          }
        } catch {
          case e : Error => println("TYPE CHECKING FATAL ERROR in " + f.getAbsolutePath)
        }

        // Re-print the file.
        val relativePath = f.getAbsolutePath.substring(inputDir.length)
        val outputFile = new File(outputDir + relativePath)

        outputFile.getParentFile.mkdirs()
        if (outputFile.exists) {
          outputFile.delete()
        }
        if (!outputFile.createNewFile())
          println("ERROR: Failed to create file.")

        val writer = new FileWriter(outputFile)
        val prettyPrinted = ASTPrettyPrintVisitor.visit(abstractSyntaxTree)
        writer.append(prettyPrinted)
        writer.close()

        // Re-read the file and verify the AST is the same.
        val astCheck = {
          val checkGenerator = new ASTGenerator
          checkGenerator.parseString(prettyPrinted)
        }
        FirstDifferenceVisitor.baseAST = abstractSyntaxTree
        val firstDiff = FirstDifferenceVisitor.visit(astCheck)
        if (firstDiff != null)
          println("AST parse/print error at " + firstDiff.line + ":" + firstDiff.column)
      }
    }
  }

  val testDir = new File(inputDir)
  test(testDir)

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
