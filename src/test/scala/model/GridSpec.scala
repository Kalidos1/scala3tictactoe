package model

import org.scalatest._
import matchers.should._
import wordspec._

class GridSpec extends AnyWordSpec with Matchers {
  "A Grid is the playingfield of TicTacToe. A Grid" when {
    "to be constructed" should {
      "be created with the length of its edges as size 4" in {
        val grid = new Grid()
      }
    }
    "created properly but empty" should {
      val grid = new Grid()
      "give access to its Cells" in {
        grid.cell(0, 0) should be(Cell(""))
        grid.cell(0, 1) should be(Cell(""))
        grid.cell(1, 0) should be(Cell(""))
        grid.cell(1, 1) should be(Cell(""))
      }
    }
  }

}
