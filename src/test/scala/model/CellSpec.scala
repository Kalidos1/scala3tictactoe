package model

import org.scalatest._
import matchers.should._
import wordspec._

class CellSpec extends AnyWordSpec with Matchers {

  "A Cell" when {
    "not set to any value " should {
      val emptyCell = Cell("")
      "have empty value " in {
        emptyCell.value should be("")
      }
      "have value space " in {
        emptyCell.toString should be(" ")
      }
      "not be set" in {
        emptyCell.isSet should be(false)
      }
    }
    "has a value " should {
      val emptyCell = Cell("X")
      "have X value " in {
        emptyCell.value should be("X")
      }
      "have value X " in {
        emptyCell.toString should be("X")
      }
      "not be set" in {
        emptyCell.isSet should be(true)
      }
    }
  }

}