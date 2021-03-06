package model


case class Cell(value: String):
  def this() = this("")

  def isSet: Boolean = "" != value

  override def toString: String = {
    if !isSet then return " "
    value
  }