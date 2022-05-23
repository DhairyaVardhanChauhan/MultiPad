package com.notepad;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class ButtonPanel extends JPanel{
	
	JButton addTask;
	JButton clear;
	
	
	Border emptyBorder = BorderFactory.createEmptyBorder();
	
	ButtonPanel()
	{
		this.setPreferredSize(new Dimension(400,75));
        this.setBackground(new Color(0x54BAB9));

		addTask = new JButton("Add Task");
		addTask.setBorder(BorderFactory.createLoweredBevelBorder());
		addTask.setFont(new Font("MS Sans Serif",Font.PLAIN, 25));
		addTask.setVerticalAlignment(JButton.BOTTOM);
		addTask.setBackground(new Color(0xFFFDDE));
        addTask.setForeground(new Color(0x333C83));
		this.add(addTask);
		
		
		this.add(Box.createHorizontalStrut(25));//Space between buttons
		clear = new JButton("Clear finished tasks");
		clear.setFont(new Font("MS Sans Serif",Font.PLAIN, 25));
		clear.setBorder(BorderFactory.createLoweredBevelBorder());
		clear.setBackground(new Color(0xEB5353));
        clear.setForeground(new Color(0xB22727));
		this.add(clear);
		
		
	}
	
	public JButton getNewTask(){
		return addTask;
	}
	
	public JButton getClear() {
		return clear;
	}
}
