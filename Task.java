package com.notepad;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Task extends JPanel{
	
	JLabel index;
	JTextField taskName;
	JButton done;
	
	private boolean checked;
	
	Task()
	{
		this.setPreferredSize(new Dimension(400,20));
		this.setBackground(new Color(0x82DBD8));
		
		this.setLayout(new BorderLayout());
		
		checked = false;
		
		index = new JLabel("");
		index.setPreferredSize(new Dimension(20,20));
		index.setHorizontalAlignment(JLabel.CENTER);
		this.add(index,BorderLayout.WEST);
	
		taskName = new JTextField("");
		taskName.setBorder(BorderFactory.createBevelBorder(1));
		taskName.setBackground(new Color(0xFFE3A9));

		
		this.add(taskName,BorderLayout.CENTER);
		
		done = new JButton("Done");
        done.setForeground(new Color(0,0,0));
        done.setBackground(new Color(0x1572A1));
		done.setPreferredSize(new Dimension(40,20));
		done.setBorder(BorderFactory.createLoweredBevelBorder());
		done.setFocusPainted(false);
		
		this.add(done,BorderLayout.EAST);
		
	}
	
	public void changeIndex(int num)
	{
		this.index.setText(num+"");
		this.revalidate();
	}
	
	
	public JButton getDone()
	{
		return done;
	}
	
	public boolean getState()
	{
		return checked;
	}
	
	public void changeState()
	{
		this.setBackground(new Color(0x00FFAB));
		taskName.setBackground(new Color(0x00FFAB));
		checked = true;
		revalidate();
	}
}
