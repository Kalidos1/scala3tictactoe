package model

class FourDGridsStateStrategy(var verticalColumn: Array[Array[Int]], var diagOfAllGrids: List[Array[Array[Int]]])
  extends WinStateStrategyTemplate:

  def this () = {
    this(Array.tabulate(4, 4)((row, col) => 0), List.fill(4)(Array.tabulate(4, 4) { (row, col) => 0}))
  }

  override def checkRow(row: Int, grid: Int): Boolean = {
    var rowLength = 0
    var reverseRowLength = 0
    for
      i <- this.diagOfAllGrids.indices
    do
      rowLength += diagOfAllGrids(i)(row)(i)
      reverseRowLength+= diagOfAllGrids(i)(row)(3 - i)

    rowLength == numberToWin || reverseRowLength == numberToWin
  }

  override def checkColumn(row: Int, column: Int, grid: Int): Boolean = {
    var columnLength = 0
    var reverseColumnLength = 0
    for
      i <- this.diagOfAllGrids.indices
    do
      columnLength += diagOfAllGrids(i)(i)(column)
      reverseColumnLength += diagOfAllGrids(i)(3 - i)(column)

    this.verticalColumn(row)(column) += 1
    this.verticalColumn(row)(column) == numberToWin || columnLength == numberToWin || reverseColumnLength == numberToWin
  }

  def checkDiagOfAllGridsTogetherColumnEqualRow: Boolean = {
    var rowLength = 0
    var reverseRowLength = 0
    for
      i <- this.diagOfAllGrids.indices
    do
      rowLength += diagOfAllGrids(i)(i)(i)
      reverseRowLength+= diagOfAllGrids(i)(3 - i)(3 - i)
    rowLength == numberToWin || reverseRowLength == numberToWin
  }

  def checkDiagOfAllGridsTogetherInOtherSideOfDiagOneGrid: Boolean = {
    var rowLength = 0
    var reverseRowLength = 0
    for
      i <- this.diagOfAllGrids.indices
    do
      rowLength += diagOfAllGrids(i)(3 - i)(i)
      reverseRowLength+= diagOfAllGrids(i)(i)(3 - i)
    rowLength == numberToWin || reverseRowLength == numberToWin
  }

  override def checkDiagonal(row: Int, column: Int, grid: Int): Boolean = {
    this.diagOfAllGrids(grid)(row)(column) += 1
    if row == column then
      return checkDiagOfAllGridsTogetherColumnEqualRow
    else if row + column == 3 then
      return checkDiagOfAllGridsTogetherInOtherSideOfDiagOneGrid
    false
  }
