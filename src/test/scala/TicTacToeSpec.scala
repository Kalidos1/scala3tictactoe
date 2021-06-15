import org.scalatest._
import matchers.should._
import wordspec._

class TicTacToeSpec extends AnyWordSpec with Matchers {
  "The TicTacToe main class" should {
    "accept text input as argument without readline loop, to test it from command line " in {
      TicTacToe.main(Array[String]("s"))
    }
  }
}