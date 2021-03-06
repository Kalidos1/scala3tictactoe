package view.gui

import java.awt.{BorderLayout, Dimension, GridLayout}

import controller.{Controller, Messages}
import javafx.application.Application
import javax.swing._

class TicTacToeGUI(controller: Controller) extends JFrame:
  setTitle(Messages.TITLE)
  setLocationRelativeTo(null)

  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  setMinimumSize(new Dimension(600, 600))

  def constructTicTacToePane(controller: Controller) = {
    getContentPane.add(getLoginPanel(controller), BorderLayout.CENTER)
    setVisible(true)
  }

  def getLoginPanel(controller: Controller): JPanel = {
    val start = new JButton("Start")
    val player1 = new JTextField
    val user1 = new JLabel("First Player")
    val user2 = new JLabel("Second Player")
    val player2 = new JTextField
    start.addActionListener((e: _root_.java.awt.event.ActionEvent) => {
      val source: Object = e.getSource
      if source == start then
        if "" != player1.getText().trim() && "" != player2.getText().trim() then
          controller.setPlayers(player1.getText(), player2.getText())
          this.dispose()
          Application.launch(classOf[GameGui])
        else
          JOptionPane.showMessageDialog(null, Messages.USER_ERROR)
    })
    val info = new JLabel("<html><div WIDTH=285>" + controller.statusMessage + "</div></html>")
    val panel = new JPanel
    panel.setLayout(new GridLayout(3, 2))
    panel.add(user1)
    panel.add(player1)
    panel.add(user2)
    panel.add(player2)
    panel.add(start)
    val mainPanel = new JPanel
    mainPanel.setLayout(new GridLayout(2, 1))
    mainPanel.add(info)
    mainPanel.add(panel)
    mainPanel
  }

  constructTicTacToePane(controller)
