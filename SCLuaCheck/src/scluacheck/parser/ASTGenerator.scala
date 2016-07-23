package scluacheck.parser

import java.io.{FileReader, File}

import scala.collection.mutable.ArrayBuffer

import org.antlr.v4.runtime._
import scluacheck.ast.FileNode

/**
  * Generate an AST from a file, and stores any error information that results.
  * The purpose of this class is to abstract any ANTLR related code from the rest of the program.
  */
class ASTGenerator {
  // Captures errors and adds them to a provided buffer.
  class ErrorCaptureListener(val lexerErrors : ArrayBuffer[(Int, Int, String)]) extends BaseErrorListener {
    override def syntaxError(recognizer : Recognizer[_,_], offendingSymbol : Object, line : Int,
                             charPositionInLine : Int, msg : String, e : RecognitionException) : Unit = {
      lexerErrors += ((line, charPositionInLine, msg))
    }
  }

  private val _lexerErrors = new ArrayBuffer[(Int, Int, String)]
  def lexerErrors = _lexerErrors

  private val _parserErrors = new ArrayBuffer[(Int, Int, String)]
  def parserErrors = _parserErrors

  // Generate an AST from a file. Returns null if it fails due to a lexing or parsing error.
  def parseFile(f : File) : FileNode = {
    val input = new ANTLRInputStream(new FileReader(f))
    parseStream(input)
  }

  // Generate an AST from a string. Returns null if it fails due to a lexing or parsing error.
  def parseString(s : String) : FileNode = {
    val input = new ANTLRInputStream(s)
    parseStream(input)
  }

  // Generate an AST from an ANTLR input stream. Returns null if it fails due to a lexing or parsing error.
  private def parseStream(input : ANTLRInputStream) : FileNode = {
    // Set up the lexer with the custom error listener.
    val lexer = new SCLuaLexer(input)
    lexer.removeErrorListeners()
    lexer.addErrorListener(new ErrorCaptureListener(_lexerErrors))

    // Set up the parser with the custom error listener.
    val tokens = new CommonTokenStream(lexer)
    val parser = new SCLuaParser(tokens)
    parser.removeErrorListeners()
    parser.addErrorListener(new ErrorCaptureListener(_parserErrors))

    // Attempt to lex and parse the file.
    val parseTree = parser.start()

    // If there were any lexer or parser errors, return null. Otherwise, transform the parse tree into an AST.
    if (_lexerErrors.nonEmpty || _parserErrors.nonEmpty)
      return null

    ASTFromPTVisitor.visit(parseTree) match {
      case n : FileNode => n
      case _ =>
        _parserErrors += ((-1, -1, "Parsing did not create a valid parse tree."))
        null
    }
  }

  // Print any errors to the console.
  def printErrors() : Unit = {
    if (_lexerErrors.nonEmpty) {
      println("Lexer errors:")
      for (e <- _lexerErrors) {
        println("  " + e._1 + ":" + e._2 + " - " + e._3)
      }
    }
    if (_parserErrors.nonEmpty) {
      println("Parser errors:")
      for (e <- _parserErrors) {
        println("  " + e._1 + ":" + e._2 + " - " + e._3)
      }
    }
  }
}
