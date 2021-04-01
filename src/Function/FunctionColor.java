package Function;

import Gui.GUI;

import java.awt.*;

public class FunctionColor {
  private final GUI gui;

  public FunctionColor(GUI gui) {
    this.gui = gui;
  }

  //Changing background colors
  public void changeColor(String color) {
    switch (color) {
      case "White":
        this.gui.window.getContentPane().setBackground(Color.WHITE);
        this.gui.textArea.setBackground(Color.WHITE);
        this.gui.textArea.setForeground(Color.BLACK);
        break;
      case "Black":
        this.gui.window.getContentPane().setBackground(Color.BLACK);
        this.gui.textArea.setBackground(Color.BLACK);
        this.gui.textArea.setForeground(Color.WHITE);
        break;
      case "Blue":
        this.gui.window.getContentPane().setBackground(Color.BLUE);
        this.gui.textArea.setBackground(Color.BLUE);
        this.gui.textArea.setForeground(Color.WHITE);
        break;
      case "Extra RGB":
        this.gui.window.getContentPane().setBackground(new Color(102, 123, 130));
        this.gui.textArea.setBackground(new Color(102, 123, 130));
        this.gui.textArea.setForeground(Color.WHITE);
        break;
    }
  }
}
