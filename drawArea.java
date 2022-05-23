package com.notepad;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class drawArea extends JComponent{

    // Image in which we're going to draw
    private Image image;
    // Graphics2D object ==> used to draw on
    private Graphics2D graph2;
    // Mouse coordinates
    private int currentX, currentY, oldX, oldY;



    public drawArea() {

        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {  // initializing anonymous new MouseAdapter(){...} creates a new class
            // that extends MouseAdapter with a single object of it and that class overrides mousePressed,
            // called those as they don't have a name

//            Moseadapter -->(creates) anonymous class extends MouseAdapter() --> it overrides the mousepressed method
            public void mousePressed(MouseEvent e) {

                // save coord x,y when mouse is pressed
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        // addMouse... obj = new addMouse...(){overridden method}
                    // obj creation done { class started}


        addMouseMotionListener(new MouseMotionAdapter() {   // basically we are overriding MouseMotion ... interface instead of making another class and implementing it
            public void mouseDragged(MouseEvent e) {
                // coord x,y when drag mouse
                currentX = e.getX();
                currentY = e.getY();

                if (graph2 != null) {
                    // draw line if g2 context not null
                    graph2.drawLine(oldX, oldY, currentX, currentY);
                    // refresh draw area to repaint
                    repaint();
                    // store current coords x,y as olds x,y
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {   // the graphics object is responsible for making curves, shapes, etc.
        if (image == null) {
            // image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            graph2 = (Graphics2D) image.getGraphics();
            // enable antialiasing
            graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   // due to graphs 2D we are able to use antialiasing
            // clear draw area  // now we are using antialiasing. What it does is, it blends the disturbed corners according to the respective background.So that they are smooth
            clear();
        }

        g.drawImage(image, 0, 0, null);
    }

    // now we create exposed methods
    public void clear() {
        graph2.setPaint(Color.white);
        // draw white on entire draw area to clear
        graph2.fillRect(0, 0, getSize().width, getSize().height);    // we are creating a rectangle of white colour and size of the full window thus creating a clear effect
        graph2.setPaint(Color.black);
        repaint();
    }

    public void red() {
        // apply red color on g2 context
        graph2.setPaint(Color.red);
    }

    public void black() {
        graph2.setPaint(Color.black);
    }

    public void magenta() {
        graph2.setPaint(Color.magenta);
    }

    public void green() {
        graph2.setPaint(Color.green);
    }

    public void blue() {
        graph2.setPaint(Color.blue);
    }

    public  void yellow(){graph2.setPaint(Color.yellow);}

    public  void custom(){

        JTextField rField = new JTextField(5);
        JTextField gField = new JTextField(5);
        JTextField bField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("r:"));
        myPanel.add(rField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("g:"));
        myPanel.add(gField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("b:"));
        myPanel.add(bField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter r,g and b combination Values", JOptionPane.OK_CANCEL_OPTION);

        String r = rField.getText();
        int rVal = Integer.parseInt(r);
        String g = gField.getText();
        int gVal = Integer.parseInt(g);
        String b = bField.getText();
        int bVal = Integer.parseInt(b);

        try{
            if (rVal <= 255 && rVal >= 0 && gVal <= 255 && gVal >= 0 && bVal <= 255 && bVal >= 0) {
                graph2.setPaint(new Color(rVal, gVal, bVal));
            }

        else{
            JOptionPane.showMessageDialog(null,"Enter a number btw 0-255","ERROR",JOptionPane.ERROR_MESSAGE);

        }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}