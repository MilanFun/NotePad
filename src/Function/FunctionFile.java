package Function;

import Gui.GUI;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
  Class of Function in File
 */
public class FunctionFile {
  private final GUI gui;

  //File name
  private String fileName;

  //File name path
  private String filePath;

  public FunctionFile(GUI gui) {
    this.gui = gui;
  }

  //Creating new File
  public void newFile() {
    //Set empty text area
    this.gui.textArea.setText("");

    //Set title of window
    this.gui.window.setTitle("New note");

    //First init of note information
    this.fileName = null;
    this.filePath = null;
  }

  //Open new note file
  public void open() {
    FileDialog fileDialog = new FileDialog(this.gui.window, "Open", FileDialog.LOAD);
    fileDialog.setVisible(true);

    if (fileDialog.getFile() != null) {
      this.fileName = fileDialog.getFile();
      this.filePath = fileDialog.getDirectory();
      this.gui.window.setTitle(this.fileName);
    }

    System.out.println("File address and file name: " + this.filePath + this.fileName);

    //Reading from file to note
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath + this.fileName))) {
      this.gui.textArea.setText("");

      String line = null;

      while((line = bufferedReader.readLine()) != null) {
        this.gui.textArea.append(line + "\n");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  //Save note
  public void save() {
    if(this.fileName == null) {
      this.saveAs();
    } else {
      try(FileWriter fileWriter = new FileWriter(this.filePath + this.fileName)) {
        fileWriter.write(this.gui.textArea.getText());
        this.gui.window.setTitle(this.fileName);
      }catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Error in class FunctionFile.java: save() method");
      }
    }
  }

  //SaveAs note
  public void saveAs() {
    FileDialog fileDialog = new FileDialog(this.gui.window, "Save", FileDialog.SAVE);
    fileDialog.setVisible(true);

    if(fileDialog.getFile() != null) {
      this.fileName = fileDialog.getFile();
      this.filePath = fileDialog.getDirectory();
      this.gui.window.setTitle(fileName);
    }

    try(FileWriter fileWriter = new FileWriter(this.filePath + this.fileName)){
      fileWriter.write(this.gui.textArea.getText());
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("Error in class FunctionFile.java: saveAs() method");
    }
  }

  //Exit
  public void exit() {
    System.exit(0);
  }
}
