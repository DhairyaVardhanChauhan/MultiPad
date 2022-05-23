package com.notepad;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;  // It is the event used to handle all actions
import java.awt.print.PrinterException;
import java.io.*;



public class NotepadApp extends JFrame implements ActionListener {
    JMenuBar menuBar = new JMenuBar();  // it creates a menu bar

    JMenu file = new JMenu("File");  // Menu bar content. It creates a menu with the specified string name.
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    JMenu todo = new JMenu("Todo");

    // File area
    JMenuItem newFile = new JMenuItem("NewFile");  // all the suboptions in the menu
    JMenuItem openFile = new JMenuItem("OpenFile");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");
    JMenuItem paint = new JMenuItem("Paint");

        // edit area
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem setSize = new JMenuItem("SetSize");
    JMenuItem selectall = new JMenuItem("SelectAll");

        // about area
    JMenuItem about = new JMenuItem("About");

    // todo area
    JMenuItem MyList = new JMenuItem("MyList");

    // Writing area/line frame.
    JTextArea textArea = new JTextArea(); // this is the frame used so that we can write in out note pad.


    NotepadApp() {
        setTitle("MultiPad");
        setBounds(400, 100, 800, 600); // setting padx,pady, width and height
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // used to specify the various options for the close button.
        ImageIcon icon = new ImageIcon("C:\\Users\\dhair\\IdeaProjects\\java_project1\\src\\img.png");
        setIconImage(icon.getImage());


        // Adding items to the menu bar
        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        menuBar.add(todo);


//        making the file menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(print);
        file.add(exit);
        file.add(paint);


//        making the edit menu
        edit.add(cut);
        edit.add(setSize);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);

        help.add(about);
        help.add(MyList);

        todo.add(MyList);


        // All writing area for the user
        JScrollPane scrollPane = new JScrollPane(textArea); // adding a scroll pane to text area means we can scroll if text exceeds the limit
        textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        // font family, font, size
        add(scrollPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  // never is used so that we never get the horizontal scroll bar
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Vertical scroll bar is set here.
        textArea.setLineWrap(true);  // if it exceeds the frame limit then the content will go to the next line.
        textArea.setWrapStyleWord(true);


        // event sheet actions

        newFile.addActionListener(this);  // where this is the text passed to it.
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        print.addActionListener(this);
        paint.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        setSize.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        about.addActionListener(this);
        MyList.addActionListener(this);



        // Making shortcut keys

        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_DOWN_MASK));
        paint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
        MyList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_DOWN_MASK));

    }

    @Override   // all the actions such as opening a new window when clicked is done here.
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("NewFile")){
            int z = JOptionPane.showConfirmDialog(null,"Would you like to open a new file without saving?");
            // the value of z if yes is clicked is 0,if no then 1,if cancel then 2, if X is pressed then -1.
            if (z == 0){
            textArea.setText(null);
            }
        }
        else if(e.getActionCommand().equalsIgnoreCase("OpenFile")){
            JFileChooser fileChooser = new JFileChooser(); // open the system file chooser menu
            FileNameExtensionFilter testFileter = new FileNameExtensionFilter("Only file name(.txt)","txt");
            // used to add file type in filechooser extension

            fileChooser.setAcceptAllFileFilterUsed(false);  // coz we can only accept txt files hence we disabled rest.
            fileChooser.addChoosableFileFilter(testFileter);
            int action = fileChooser.showOpenDialog(null);
            if(action!= JFileChooser.APPROVE_OPTION){
                return;
            }
            else{
                try {                         // 2) read by buff                  // 1) file chosen
                    BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile())); // Basically it is used to read data from a file to another
                    // new FileReader(fileChooser.getSelectedFile()) is used to create/choose files only.
//                    then it is written by buffer
                    // FileReader is meant for reading streams of characters.
                    // buffer can be used to read data from any character stream or file.
                    //File chooser Empty constructor that points to user’s default director
                    // y

                        // printed in textarea
                    textArea.read(reader,null);
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }

        else if(e.getActionCommand().equalsIgnoreCase("Save")){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter testFileter = new FileNameExtensionFilter("Only file name(.txt)","txt");
            // Creates a FileNameExtensionFilter with the specified description and file name extensions
            fileChooser.setAcceptAllFileFilterUsed(false);   // only txt needed hence we used false
            fileChooser.addChoosableFileFilter(testFileter);  // setting only txt
            int action = fileChooser.showSaveDialog(null);
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }
            else{
                String Filename = fileChooser.getSelectedFile().getAbsolutePath().toString();   // checking if the filename has .txt
                if(!Filename.contains(".txt")){
                    Filename += ".txt";
                }
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(Filename));  // just used to read contents of file
                    textArea.write(writer);
//                    FileWriter writes directly into Files and should be used only when the number of writes is less.
//                    BufferedWriter: BufferedWriter is almost similar to FileWriter but it
//                    uses internal buffer to write data into File. So if the number of write operations is more,
//                    the actual IO operations are less and performance is better.BufferWriter cannot create files

                }catch (IOException ex){
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"File Saved");

            }
        }
        else if(e.getActionCommand().equalsIgnoreCase("Print")){
            try {
                boolean z = textArea.print();
                if(z == true){
                JOptionPane.showMessageDialog(null,"PDF Saved");}
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getActionCommand().equalsIgnoreCase("Exit")){
            System.exit(0);
        }
        else if(e.getActionCommand().equalsIgnoreCase("Cut")){
            textArea.cut();
        }else if(e.getActionCommand().equalsIgnoreCase("Copy")){
            textArea.copy();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Paste")){
            textArea.paste();
        }
        else if(e.getActionCommand().equalsIgnoreCase("SelectAll")){
            textArea.selectAll();

        }else if(e.getActionCommand().equalsIgnoreCase("About")){
                new about().setVisible(true);   // this just runs the about file
        }
        else if(e.getActionCommand().equalsIgnoreCase("setSize")){
            String font = JOptionPane.showInputDialog("Enter the font size:");
            int fontsize = Integer.parseInt(font);
            textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontsize));
        }
        else if(e.getActionCommand().equalsIgnoreCase("paint")){
            new SwingPaint().show();
            setState(JFrame.ICONIFIED);    // minimizes the window

        }

        else if(e.getActionCommand().equalsIgnoreCase("MyList")) {
            new AppFrame().setVisible(true);
            setState(JFrame.ICONIFIED);
        }
        }

    public static void main(String[] args) {
        NotepadApp obj = new NotepadApp();
        obj.setVisible(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  // to give gui a cool modern look
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}

