package com.notepad;
import javax.swing.*;

public class about extends JFrame {

    about(){
        setBounds(400,100,800,600);
        setTitle("Multipad(About)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //just closes the window while the program still runs
        ImageIcon icon = new ImageIcon("C:\\Users\\dhair\\IdeaProjects\\java_project1\\src\\img.png");
        setIconImage(icon.getImage());
        setLayout(null); // the components can be put at specific x,y coordinates.

        JLabel iconLabel = new JLabel( new ImageIcon("C:\\Users\\dhair\\IdeaProjects\\java_project1\\src\\img.png")); // adding image address
//        JLabel is a class of java Swing . JLabel is used to display a short string or an image icon.
        iconLabel.setBounds(10,50,240,300); // coordinates of the image.
        add(iconLabel); // embedding the image

        JLabel textlabel = new JLabel("<html><h1><i>Welcome to Multipad</i></h1><br><p style =\"font-family:'Brush Script MT', cursive;font-size:18px\">Multipad is a fast and simple text editor on Windows you can View, edit, and search through plain text documents and source code files instantly.The plus point that comes with it is that the user can draw and make a todolist along it.</p></br></html>"); // using html as we cant add new line using \n in jlabel
        textlabel.setBounds(300,-40,400,500);
        add(textlabel);

        JLabel textlabel2 = new JLabel("<html><div style=\"color:red;font-size: 20px;\">NOTE:</div><div style=\"color:red;font-size: 13px\">It can edit text files (bearing the \".txt\" filename extension) and compatible formats</div></html>");
        textlabel2.setBounds(300, 150, 400, 500);
        add(textlabel2);

    }

    public static void main(String[] args) {
        new about().setVisible(true);  // it is used to display the frame.
    }
}
