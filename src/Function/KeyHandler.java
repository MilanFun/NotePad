package Function;

import Gui.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
    Class for fast saving
*/
public class KeyHandler implements KeyListener {

  private final GUI gui;

  public KeyHandler(GUI gui) {
    this.gui = gui;
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
      this.gui.functionFile.save();
    }

    if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
      this.gui.functionEdit.undo();
    }

    if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F) {
      this.gui.menuFile.doClick();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
