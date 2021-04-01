package Function;

import Gui.GUI;

import javax.swing.*;
import java.awt.*;

/*
  Class of Function in Format
*/
public class FunctionFormat {
  private final GUI gui;

  //Style of text
  private Font arial;
  private Font comicSansMS;
  private Font timesNewRoman;

  private String selectedFont;


  public FunctionFormat(GUI gui) {
    this.gui = gui;
  }

  //Set Word Wrap
  public void wordWrap() {
    if (!this.gui.isWordWrap()) {
      this.gui.setWordWrap(true);
      this.gui.textArea.setLineWrap(true);
      this.gui.textArea.setWrapStyleWord(true);
      this.gui.iWrap.setText("Word Wrap: On");
    } else if(this.gui.isWordWrap()){
      this.gui.setWordWrap(false);
      this.gui.textArea.setLineWrap(false);
      this.gui.textArea.setWrapStyleWord(false);
      this.gui.iWrap.setText("Word Wrap: Off");
    }
  }

  //Creating styles
  public void createFont(int fontsize) {
    this.arial = new Font("Arial", Font.PLAIN, fontsize);
    this.comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontsize);
    this.timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontsize);

    setFont(selectedFont);
  }

  //Setting style of text
  public void setFont(String font) {
    this.selectedFont = font;

    switch (this.selectedFont) {
      case "Arial" -> this.gui.textArea.setFont(arial);
      case "Comic Sans MS" -> this.gui.textArea.setFont(comicSansMS);
      case "Times New Roman" -> this.gui.textArea.setFont(timesNewRoman);
    }
  }

  public void setSelectedFont(String s) {
    this.selectedFont = s;
  }
}
