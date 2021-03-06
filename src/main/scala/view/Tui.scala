package view

import controller.Controller
import util.Observer


class Tui(controller: Controller) extends Observer:

  controller.add(this)

  val PlayersPattern = "(^[a-zA-Z0-9_-]*$)".r
  val MovePattern = "(^[0-3][0-3][0-3]$)".r

  def processInputLine(input: String): Boolean = {
    input match {
      case "q" =>
      case "r"=> controller.reset
      case "z" => controller.undo
      case "y" => controller.redo
      case MovePattern(input) => checkIfMove(input)
      case PlayersPattern(input) => checkIfPlayers(input)
    }
    true
  }
  def checkIfPlayers (input: String): Boolean = {
    if input.contains("-") then
      val names: Array[String] = input.split("-")
      if names.length == 2 then
        controller.setPlayers(names(0), names(1))
      else
        return false
    true
  }
  def checkIfMove (input: String): Boolean = {
    input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
      case row :: column :: grid :: Nil => controller.setValue(row, column, grid)
    }
    true
  }

  override def update: Boolean =  {
    println(controller.toString)
    println(controller.statusMessage)
    true
  }