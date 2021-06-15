package view.gui

import model.Cell
import javafx.scene.shape.Rectangle
import javafx.scene.paint.Color
import javafx.scene.transform.Rotate


class CellPanel(cell: Cell,row: Int, column: Int, d: Double,grid: Int,e: Double, f: Double,  color:Color) extends Rectangle:

  setWidth(d)
  setHeight(d)
  setFill(color)
  setTranslateX(e)
  setTranslateY(-2.05 * d / 4)
  setTranslateZ(f)
  setRotationAxis(Rotate.X_AXIS)
  setRotate(90)
  setId("%d %d %d".format(row, column, grid))
  setValue(cell)

  def setValue(cell: Cell): Unit = {
    if "X" == cell.value then this.setFill(Color.RED)
    else if "O" == cell.value then this.setFill(Color.BLUE)
  }


  def isSet: Boolean = cell.isSet

  def resetCell(color: Color): Unit = {
    this.setFill(color)
  }