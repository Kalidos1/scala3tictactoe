package model


case class Cell(value: String) {
  def this() = this("")
  def isSet: Boolean = !"".equals(value)

  override def toString: String = {
    if (!isSet) return " "
    value
  }
}