import controller.Controller
import model.Game
import view.Tui

import scala.io.StdIn.readLine

object TicTacToe3D {
  var controller = new Controller(new Game())

  val tui = new Tui(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    var input: String = ""

    while ({ {
      input = readLine()
      tui.processInputLine(input)
    } ; (input != "q")}) ()
  }
}
