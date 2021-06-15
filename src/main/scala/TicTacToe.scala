import controller.Controller
import model.Game
import view.Tui

import scala.io.StdIn.readLine

object TicTacToe {
  var controller = new Controller(new Game())

  val tui = new Tui(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    var input: String = if (args == null || args.isEmpty) "" else args(0)
    if (!input.isEmpty) tui.processInputLine(input)
    else while ({ {
      input = readLine()
      tui.processInputLine(input)
    } ; (input != "q")}) ()
  }
}
