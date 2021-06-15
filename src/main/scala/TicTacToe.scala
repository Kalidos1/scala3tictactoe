package ticTacToe

import controller.Controller
import model.Game
import view.Tui
import view.gui.TicTacToeGUI

import scala.io.StdIn.readLine

object TicTacToe:
  var controller = Controller(new Game())

  val tui = Tui(controller)
  val gui = TicTacToeGUI(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    var input: String = if (args == null || args.isEmpty) "" else args(0)
    if !input.isEmpty then tui.processInputLine(input)
    else 
      while 
        input != "q" 
      do 
        input = readLine()
        tui.processInputLine(input)
  }
