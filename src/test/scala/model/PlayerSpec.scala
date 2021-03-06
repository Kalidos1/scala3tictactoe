package model

import model.{Game, Player}
import org.scalatest._
import matchers.should._
import wordspec._

class PlayerSpec extends AnyWordSpec with Matchers {
  "A Player" when { "new" should {
    val player = Player("Your Name", "X")
    "have a name"  in {
      player.name should be("Your Name")
    }
    "have a symbol"  in {
      player.symbol should be("X")
    }
    "have a nice String representation" in {
      player.toString should be("name: Your Name symbol: X")
    }
  }}

}