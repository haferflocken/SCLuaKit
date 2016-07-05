package scluacheck.verify

import scluacheck.ast.ASTNode

import scala.collection.mutable
import mutable.ArrayBuffer

/**
  * The symbol table with types. Is automatically initialized with its parent's symbols
  * when using the single argument constructor.
  */
class SymbolTable(val parentTable : SymbolTable,
                  private val _symbols : ArrayBuffer[TypedSymbol],
                  val subTables : mutable.Map[ASTNode, SymbolTable]) {

  def this(parentTable : SymbolTable) {
    this(parentTable,
      new ArrayBuffer[TypedSymbol]() ++= (if (parentTable != null) parentTable.symbols else Seq()),
      mutable.Map())
  }

  // The symbols are mutable internally, but immutable externally.
  def symbols : Seq[TypedSymbol] = _symbols

  def lookup(s : String) : TypedSymbol = {
    val findFn = (e : TypedSymbol) => e.symbol.equals(s)
    val mine = _symbols.find(findFn)
    if (mine.isDefined)
      return mine.get
    null
  }

  def addSymbol(s : TypedSymbol) : Unit = { _symbols += s }
  def addSubTable(k : ASTNode, v : SymbolTable) : Unit = { subTables.update(k, v) }

  override def toString : String = toIndentedString("")

  private def toIndentedString(prefix : String) : String = {
    var out = prefix + _symbols.mkString("{", ", ", "}")
    for ((_, s) <- subTables) {
      out += "\n" + s.toIndentedString(prefix + "  ")
    }
    out
  }
}

/**
  * A symbol and its type in the symbol table.
  */
class TypedSymbol(val symbol : String, var t : Type) {
  override def toString = symbol + " is " + t
}

/**
  * The type of a symbol in the symbol table or a node in the AST.
  */
abstract class Type
object NilType extends Type {
  override def toString : String = "Nil"
}
object BooleanType extends Type {
  override def toString : String = "Boolean"
}
object NumberType extends Type {
  override def toString : String = "Number"
}
object StringType extends Type {
  override def toString : String = "String"
}
case class FunctionType(returnTypes : Seq[Type], argTypes : Seq[Type]) extends Type {
  override def toString : String = argTypes.mkString("Func(", ", ", ") => ") + returnTypes.mkString("(", ", ", ")")
}
object UserdataType extends Type {
  override def toString : String = "Userdata"
}
object ThreadType extends Type {
  override def toString : String = "Thread"
}
object TableType extends Type {
  override def toString : String = "Table"
}
// Globals are initially assumed to be potentially any type.
object OmniType extends Type {
  override def toString : String = "Omni"
}
case class OrType(possibleTypes : Set[Type]) extends Type {
  override def toString : String = possibleTypes.mkString("Or(", ", ", ")")
}

object Type {
  def or(l : Type, r : Type) : Type = {
    if (l == null)
      return r
    if (r == null || l.equals(r))
      return l

    l match {
      case OrType(lSet) =>
        r match {
          case OrType(rSet) => OrType(lSet ++ rSet)
          case _ => OrType(lSet + r)
        }
      case _ =>
        r match {
          case OrType(rSet) => OrType(rSet + l)
          case _ => OrType(Set(l, r))
        }
    }
  }

  def intersects(l : Type, r : Type) : Boolean = {
    if (l == OmniType || r == OmniType)
      return true

    l match {
      case OrType(lSet) =>
        r match {
          case OrType(rSet) => lSet.intersect(rSet).nonEmpty
          case _ => lSet.contains(r)
        }
      case _ =>
        r match {
          case OrType(rSet) => rSet.contains(l)
          case _ => l.equals(r)
        }
    }
  }
}


