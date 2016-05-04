package scluacheck.verify

import scluacheck.ast.ASTNode

import scala.collection.mutable

/**
  * The symbol table with types.
  */
class SymbolTable(val parentTable : SymbolTable, val symbols : Seq[TypedSymbol], var subTables : mutable.Map[ASTNode, SymbolTable]) {
  def lookup(s : String) : TypedSymbol = {
    val findFn = (e : TypedSymbol) => e.symbol.equals(s)
    val mine = symbols.find(findFn)
    if (mine.isDefined)
      return mine.get
    if (parentTable != null)
      return parentTable.lookup(s)
    null
  }

  def addSymbol(s : TypedSymbol) = new SymbolTable(parentTable, symbols :+ s, subTables)
  def addSubTable(k : ASTNode, v : SymbolTable) : Unit = { subTables.update(k, v) }

  def isAnywhere(n : ASTNode) : Boolean = {
    var top = this
    while (top.parentTable != null)
      top = top.parentTable
    top.isInSubs(n)
  }

  def isInSubs(n : ASTNode) : Boolean = {
    if (subTables.get(n).nonEmpty)
      return true
    for ((_, t) <- subTables) {
      if (t.isInSubs(n))
        return true
    }
    false
  }

  override def toString : String = toIndentedString("")

  private def toIndentedString(prefix : String) : String = {
    var out = prefix + symbols.mkString("{", ", ", "}")
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
object NilType extends Type
object BooleanType extends Type
object NumberType extends Type
object StringType extends Type
case class FunctionType(returnTypes : Seq[Type], argTypes : Seq[Type]) extends Type
object UserdataType extends Type
object ThreadType extends Type
object TableType extends Type
object OmniType extends Type // Globals are initially assumed to be potentially any type.
case class OrType(possibleTypes : Set[Type]) extends Type

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


