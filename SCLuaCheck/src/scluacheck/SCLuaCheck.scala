package scluacheck

import java.io.{File, FileReader}

import scala.collection.mutable.ArrayBuffer

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._
import scluacheck.parser._

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
  val failedFiles = new ArrayBuffer[String]

  def test(f : File) : Boolean = {
    if (f.isDirectory) {
      for (e <- f.listFiles()) {
        if (!test(e))
          return false
      }
      return true
    } else if (ignoreFiles.contains(f.getAbsolutePath)) {
      return true // Skip files which are known to be bad.
    } else if (f.getName.endsWith(".lua") || f.getName.endsWith(".bp")) {
      val input = new ANTLRInputStream(new FileReader(f))
      val lexer = new SCLuaLexer(input)
      lexer.removeErrorListeners()
      MyErrorListener.filePath = f.getAbsolutePath
      lexer.addErrorListener(MyErrorListener)

      val tokens = new CommonTokenStream(lexer)
      val parser = new SCLuaParser(tokens)
      val tree : ParseTree = parser.start()

      if (parser.getNumberOfSyntaxErrors > 0) {
        //println(f.getAbsolutePath)
        failedFiles += f.getAbsolutePath
        return true
      }

      println(tree.toStringTree(parser))
      return true
    }
    return true
  }

  val testDir = new File("C:\\Users\\John\\Desktop\\scfa-lua\\mohodata-lua\\sim\\Entity.lua")
  test(testDir)
  println(failedFiles)

  // mohodata-lua/system contains a lot of the backend magic of Supreme Commander:
  // - Blueprints.lua makes blueprint magic happen and contains information on how mods work
  // - class.lua defines Supreme Commander's class semantics. It reveals that classes are not meant to be changed once defined.
  // - config.lua controls how Lua behaves.
  // - import.lua handles importing files.
  // - saveload.lua reveals C functions used by Lua.
  // - utils.lua defines a lot of very useful functions.

  // mohodata-lua/globalInit.lua reveals that moho is a table of classes exported from C.

  // So now the Lua can be (mostly) lexed and parsed. Things to do with this:
  // - Identify C functions which the Lua is using (any function not defined by the Lua)
  // - Identify Lua functions which the C might be using (any function which is not called in the Lua)
  // - Make assumption that new functions are not added to anything with names specified at runtime.
  //   - Use this to verify functions exist before they are called.
  //   - Derive interfaces from the way parameters are used in functions to say something about their type.
  //     - Use these interfaces to verify that function calls pass in compatible parameters.
}