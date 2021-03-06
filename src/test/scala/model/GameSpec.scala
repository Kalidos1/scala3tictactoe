package model

import org.scalatest._
import matchers.should._
import wordspec._

class GameSpec extends AnyWordSpec with Matchers {

  "A Game" when {
    "not set to any value " should {
      val emptyGame = new Game()
      "have empty player1 name and symbol" in {
        emptyGame.players(0).name should be("")
        emptyGame.players(0).symbol should be("")
      }
      "have empty player2 name and symbol" in {
        emptyGame.players(1).name should be("")
        emptyGame.players(1).symbol should be("")
      }
    }
    "set with values" should {
      val game = new Game("player1", "player2", "X", "O")
      "have player1 name and symbol" in {
        game.players(0).name should be("player1")
        game.players(0).symbol should be("X")
      }
      "have player2 name and symbol" in {
        game.players(1).name should be("player2")
        game.players(1).symbol should be("O")
      }
      "player toString should not be empty" in {
        game.playersToString should be("name: player1 symbol: X\nname: player2 symbol: O")
      }
      "toString should not be empty" in {
        game.customToString should not equal ""
      }
      "set a cell" in {
        val newGame = game.set(1, 1, 1, 1)
        newGame.grids(1).cell(1, 1) should be(Cell("O"))
        game.grids(1).cell(1, 1) should be(Cell(""))
      }
      "sell is set" in {
        val newGame = game.set(1, 1, 1, 1)
        newGame.cellIsSet(1, 1, 1) should be(true)
        game.cellIsSet(1, 1, 1) should be(false)
      }
    }
  }

}