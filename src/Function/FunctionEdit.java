package Function;

import Gui.GUI;

public class FunctionEdit {
  private final GUI gui;

  public FunctionEdit(GUI gui) {
    this.gui = gui;
  }

  public void undo() {
    this.gui.undoManager.undo();
  }

  public void redo() {
    this.gui.undoManager.redo();
  }
}
