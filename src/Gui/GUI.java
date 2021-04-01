package Gui;

import Function.*;
import lombok.Data;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class GUI implements ActionListener {
  //Page of window
  public JFrame window;

  //Text area
  public JTextArea textArea;

  //Scroll pane
  private JScrollPane scrollPane;

  //Menu Bar
  private JMenuBar menuBar;

  //Word Wrap
  private boolean wordWrap = false;

  //Menu
  public JMenu menuFile;
  private JMenu menuEdit;
  private JMenu menuFormat;
  private JMenu menuColor;

  //Menu staff
  private JMenuItem iNew;
  private JMenuItem iOpen;
  private JMenuItem iSave;
  private JMenuItem iSaveAs;
  private JMenuItem iExit;

  //File Format MENU
  public JMenuItem iWrap;
  private JMenuItem iFontArial;
  private JMenuItem iFontCSMS;
  private JMenuItem iFontTNR;
  private JMenuItem iFontSize8;
  private JMenuItem iFontSize12;
  private JMenuItem iFontSize16;
  private JMenuItem iFontSize20;
  private JMenuItem iFontSize24;
  private JMenuItem iFontSize28;
  private JMenu menuFont;
  private JMenu menuFontSize;

  //Menu Color
  private JMenuItem iColor1;
  private JMenuItem iColor2;
  private JMenuItem iColor3;
  private JMenuItem iColor4;

  //Edit Menu
  private JMenuItem iUndo;
  private JMenuItem iRedo;

  public FunctionFile functionFile = new FunctionFile(this);
  private FunctionFormat functionFormat = new FunctionFormat(this);
  private FunctionColor functionColor = new FunctionColor(this);
  public FunctionEdit functionEdit = new FunctionEdit(this);

  private KeyHandler keyHandler = new KeyHandler(this);

  //Manager
  public UndoManager undoManager = new UndoManager();

  //Constructor
  public GUI() {
    this.creatWindow();
    this.creatTextArea();
    this.creatMenuBar();
    this.creatMenuItem();
    this.creatFormatMenu();
    this.createColorMenu();
    this.creatEditMenu();
    this.functionFormat.setSelectedFont("Arial");
    this.functionFormat.createFont(16);
    this.functionFormat.wordWrap();
    this.functionColor.changeColor("White");
    this.window.setVisible(true);
  }

  //Creating of window
  private void creatWindow() {
    //Initialization: Name of page, size, default exit
    this.window = new JFrame("NotePad");
    this.window.setSize(800, 600);
    this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  //Creating text area
  private void creatTextArea() {
    //Initialization: text area, scroll pane, border (for visual), adding
    this.textArea = new JTextArea();

    this.textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
      @Override
      public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());
      }
    });

    this.textArea.addKeyListener(keyHandler);

    this.scrollPane = new JScrollPane(textArea,
                                      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    this.scrollPane.setBorder(BorderFactory.createEmptyBorder());
    this.window.add(scrollPane);
  }

  //Creating menu bar
  private void creatMenuBar() {
    //Initialization: menu bar, menu (File, Edit, Format, Color), adding
    this.menuBar = new JMenuBar();

    this.menuFile = new JMenu("File");
    this.menuEdit = new JMenu("Edit");
    this.menuFormat = new JMenu("Format");
    this.menuColor = new JMenu("Color");

    this.menuBar.add(this.menuFile);
    this.menuBar.add(this.menuEdit);
    this.menuBar.add(this.menuFormat);
    this.menuBar.add(this.menuColor);

    this.window.setJMenuBar(this.menuBar);
  }

  //Creating menu staff
  private void creatMenuItem() {
    //Initialization: Menu item, adding to menu file
    this.iNew = new JMenuItem("New");
    this.iOpen = new JMenuItem("Open");
    this.iSave = new JMenuItem("Save");
    this.iSaveAs = new JMenuItem("Save As");
    this.iExit = new JMenuItem("Exit");

    //Adding to menu
    this.menuFile.add(this.iNew);
    this.menuFile.add(this.iOpen);
    this.menuFile.add(this.iSave);
    this.menuFile.add(this.iSaveAs);
    this.menuFile.add(this.iExit);

    //Action listener and setter action command "New"
    this.iNew.addActionListener(this);
    this.iNew.setActionCommand("New");

    //Action listener and setter action command "Open"
    this.iOpen.addActionListener(this);
    this.iOpen.setActionCommand("Open");

    //Action listener and setter action command "SaveAs"
    this.iSaveAs.addActionListener(this);
    this.iSaveAs.setActionCommand("SaveAs");

    //Action listener and setter action command "Save"
    this.iSave.addActionListener(this);
    this.iSave.setActionCommand("Save");

    //Action listener and setter action command "Exit"
    this.iExit.addActionListener(this);
    this.iExit.setActionCommand("Exit");
  }

  //Creation format staff
  public void creatFormatMenu() {
    //Initialization: Format item, adding to menu format file
    this.menuFont = new JMenu("Font");
    this.menuFontSize = new JMenu("Font Size");
    this.iFontArial = new JMenuItem("Arial");
    this.iFontCSMS = new JMenuItem("Comic Sans MS");
    this.iWrap = new JMenuItem("Word Wrap: Off");
    this.iFontTNR = new JMenuItem("Times New Roman");
    this.iFontSize8 = new JMenuItem("8");
    this.iFontSize12 = new JMenuItem("12");
    this.iFontSize16 = new JMenuItem("16");
    this.iFontSize20 = new JMenuItem("20");
    this.iFontSize24 = new JMenuItem("24");
    this.iFontSize28 = new JMenuItem("28");

    //Adding to menu format
    this.menuFormat.add(this.iWrap);
    this.menuFormat.add(this.menuFont);
    this.menuFormat.add(this.menuFontSize);
    this.menuFont.add(this.iFontArial);
    this.menuFont.add(this.iFontCSMS);
    this.menuFont.add(this.iFontTNR);
    this.menuFontSize.add(this.iFontSize8);
    this.menuFontSize.add(this.iFontSize12);
    this.menuFontSize.add(this.iFontSize16);
    this.menuFontSize.add(this.iFontSize20);
    this.menuFontSize.add(this.iFontSize24);
    this.menuFontSize.add(this.iFontSize28);

    //Action listener and setter action command "Arial"
    this.iFontArial.addActionListener(this);
    this.iFontArial.setActionCommand("Arial");

    //Action listener and setter action command "Comic Sans MS"
    this.iFontCSMS.addActionListener(this);
    this.iFontCSMS.setActionCommand("Comic Sans MS");

    //Action listener and setter action command "Times New Roman"
    this.iFontTNR.addActionListener(this);
    this.iFontTNR.setActionCommand("Times New Roman");

    //Action listener and setter action command "Word Wrap"
    this.iWrap.addActionListener(this);
    this.iWrap.setActionCommand("Word Wrap");

    //Action listener and setter action command for Font Size "8"
    this.iFontSize8.addActionListener(this);
    this.iFontSize8.setActionCommand("size8");

    //Action listener and setter action command for Font Size "12"
    this.iFontSize12.addActionListener(this);
    this.iFontSize12.setActionCommand("size12");

    //Action listener and setter action command for Font Size "16"
    this.iFontSize16.addActionListener(this);
    this.iFontSize16.setActionCommand("size16");

    //Action listener and setter action command for Font Size "20"
    this.iFontSize20.addActionListener(this);
    this.iFontSize20.setActionCommand("size20");

    //Action listener and setter action command for Font Size "24"
    this.iFontSize24.addActionListener(this);
    this.iFontSize24.setActionCommand("size24");

    //Action listener and setter action command for Font Size "28"
    this.iFontSize28.addActionListener(this);
    this.iFontSize28.setActionCommand("size28");
  }

  //Creating color menu
  public void createColorMenu() {
    //Initialization: Format item, adding to menu format file
    this.iColor1 = new JMenuItem("White");
    this.iColor2 = new JMenuItem("Black");
    this.iColor3 = new JMenuItem("Blue");
    this.iColor4 = new JMenuItem("Extra RGB");

    //Adding colors in menu
    this.menuColor.add(this.iColor1);
    this.menuColor.add(this.iColor2);
    this.menuColor.add(this.iColor3);
    this.menuColor.add(this.iColor4);

    //Action listener and setter action command for color changing
    this.iColor1.addActionListener(this);
    this.iColor1.setActionCommand("White");
    this.iColor2.addActionListener(this);
    this.iColor2.setActionCommand("Black");
    this.iColor3.addActionListener(this);
    this.iColor3.setActionCommand("Blue");
    this.iColor4.addActionListener(this);
    this.iColor4.setActionCommand("Extra RGB");
  }

  public void creatEditMenu() {
    //Initialization: Format item, adding to menu format file
    this.iUndo = new JMenuItem("Undo");
    this.iRedo = new JMenuItem("Redo");

    //Adding colors in menu
    this.menuEdit.add(this.iUndo);
    this.menuEdit.add(this.iRedo);

    //Action listener and setter action command for color changing
    this.iUndo.addActionListener(this);
    this.iUndo.setActionCommand("Undo");
    this.iRedo.addActionListener(this);
    this.iRedo.setActionCommand("Redo");

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();

    switch (command) {
      case "New" -> functionFile.newFile();
      case "Open" -> functionFile.open();
      case "SaveAs" -> functionFile.saveAs();
      case "Save" -> functionFile.save();
      case "Exit" -> functionFile.exit();
      case "Word Wrap" -> functionFormat.wordWrap();
      case "size8" -> functionFormat.createFont(8);
      case "size12" -> functionFormat.createFont(12);
      case "size16" -> functionFormat.createFont(16);
      case "size20" -> functionFormat.createFont(20);
      case "size24" -> functionFormat.createFont(24);
      case "size28" -> functionFormat.createFont(28);
      case "Arial" -> functionFormat.setFont(command);
      case "Comic Sans MS" -> functionFormat.setFont(command);
      case "Times New Roman" -> functionFormat.setFont(command);
      case "White" -> functionColor.changeColor(command);
      case "Black" -> functionColor.changeColor(command);
      case "Blue" -> functionColor.changeColor(command);
      case "Extra RGB" -> functionColor.changeColor(command);
      case "Undo" -> functionEdit.undo();
      case "Redo" -> functionEdit.redo();
    }
  }
}
