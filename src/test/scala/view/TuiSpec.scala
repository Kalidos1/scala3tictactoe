package view

import view.Tui
import controller.Controller
import model.Game
import org.scalatest._
import matchers.should._
import wordspec._

class TuiSpec extends AnyWordSpec with Matchers {

  "A TicTacToe Tui" should {
    val controller = new Controller(new Game())
    val tui = new Tui(controller)
    "do nothing on input 'q'" in {
      tui.processInputLine("q")
    }
    "create new players 'player1-player2'" in {
      tui.processInputLine("player1-player2-player3")
      tui.processInputLine("player1-player2")
      controller.game.players(0).name should be("player1")
      controller.game.players(1).name should be("player2")
    }
    "set a cell on input '303'" in {
      tui.processInputLine("303")
      controller.game.cellIsSet(3, 0, 3) should be(true)
      controller.game.grids(3).cell(3, 0).value should not equal ""
    }
    "reset the game on input 'r'" in {
      tui.processInputLine("r")
      controller.game.cellIsSet(3, 0, 3) should be(false)
      controller.game.grids(3).cell(3, 0).value should be("")
    }
  }

}

