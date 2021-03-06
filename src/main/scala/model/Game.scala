package model

case class Game(grids: Vector[Grid], players: Vector[Player]):
  def this(player1: Player, player2: Player) = {
    this(Vector.tabulate(4){ ? => new Grid()}, Vector(player1, player2))
  }
  def this(player1: String, player2: String, symbol1: String, symbol2: String) = {
    this(Player(player1, symbol1), Player(player2, symbol2))
  }
  def this () = {
    this("", "", "", "")
  }

  def playersToString: String = players.map(p => p.toString).mkString("\n")

  def set (row:Int, col:Int, grid: Int, playerIndex: Int): Game = copy(grids.updated(grid, grids(grid).set(row, col, players(playerIndex).symbol)))

  def resetCell (row:Int, col:Int, grid: Int): Game = copy(grids.updated(grid, grids(grid).set(row, col, "")))

  def cellIsSet (row: Int, column: Int, grid: Int): Boolean =  grids(grid).cellIsSet(row, column)

  def customToString: String = {
    var res = ""
    for
      i <- grids.indices
    do
      res += grids(i).customToString(i)
    res
  }
