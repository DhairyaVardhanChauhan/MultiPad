package com.notepad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// this code extends the previous drawArea file

public class SwingPaint{

    JButton clearAllbtn, blkbtn, bluebtn, greenbtn, redBtn, magentaBtn, yellowBtn,customBtn;   // all the buttons are assembled here
    drawArea Area_drawing;



    ActionListener actionListener = new ActionListener() {  // implementing the event sheet


        // JMenu items

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == clearAllbtn) {
                Area_drawing.clear();
            } else if (e.getSource() == blkbtn) {
                Area_drawing.black();
            } else if (e.getSource() == bluebtn) {
                Area_drawing.blue();
            } else if (e.getSource() == greenbtn) {
                Area_drawing.green();
            } else if (e.getSource() == redBtn) {
                Area_drawing.red();
            } else if (e.getSource() == magentaBtn) {
                Area_drawing.magenta();
            }
            else if (e.getSource() == yellowBtn){
                Area_drawing.yellow();
            }
            else if (e.getSource() == customBtn){
                Area_drawing.custom();
            }
        }
    };



    public void show() {


        // create main frame
        JFrame Mainframe = new JFrame("Multipad(paint)");

        Image image_icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\dhair\\IdeaProjects\\java_project1\\src\\img.png");
        Mainframe.setIconImage(image_icon);
        Mainframe.setLayout(null);
        Mainframe.setSize(400,400);
        Mainframe.setVisible(true);
        Mainframe. setResizable(false);

        Container content = Mainframe.getContentPane();
        // set layout on content pane
        content.setLayout(new BorderLayout());
        // create draw area
        Area_drawing = new drawArea();

        // add to content pane
        content.add(Area_drawing, BorderLayout.CENTER);

        // create controls to apply colors and call clear feature
        JPanel MainCtrls = new JPanel();

        clearAllbtn = new JButton("Clear");
        clearAllbtn.addActionListener(actionListener);
        blkbtn = new JButton("Black");
        blkbtn.addActionListener(actionListener);
        bluebtn = new JButton("Blue");
        bluebtn.addActionListener(actionListener);
        greenbtn = new JButton("Green");
        greenbtn.addActionListener(actionListener);
        redBtn = new JButton("Red");
        redBtn.addActionListener(actionListener);
        magentaBtn = new JButton("Magenta");
        magentaBtn.addActionListener(actionListener);
        yellowBtn = new JButton("Yellow");
        yellowBtn.addActionListener(actionListener);
        customBtn = new JButton("Custom");
        customBtn.addActionListener(actionListener);



        // add to panel
        MainCtrls.add(greenbtn);
        MainCtrls.add(bluebtn);
        MainCtrls.add(blkbtn);
        MainCtrls.add(redBtn);
        MainCtrls.add(magentaBtn);
        MainCtrls.add(yellowBtn);
        MainCtrls.add(customBtn);
        MainCtrls.add(clearAllbtn);



        // add to content pane
        content.add(MainCtrls, BorderLayout.NORTH);

        Mainframe.setSize(600, 600);


        // can close frame
        Mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // show the swing paint result
        Mainframe.setVisible(true);

    }

    public static void main(String[] args) {
        new SwingPaint().show();

    }

}