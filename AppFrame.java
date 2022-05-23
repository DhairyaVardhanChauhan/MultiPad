package com.notepad;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppFrame extends JFrame{
	
	private TitleBar title;
	private ButtonPanel footer;
	private List list;
	
	private JButton newTask;
	private JButton clear;

	
	AppFrame()
	{
		ImageIcon icon = new ImageIcon("C:\\Users\\dhair\\IdeaProjects\\java_project1\\src\\img.png");
		setIconImage(icon.getImage());
		this.setTitle("ToDoList");
		this.setSize(400,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
//		this.setResizable(false);
		title = new TitleBar();
		footer = new ButtonPanel();
		list = new List();
		
		this.add(title,BorderLayout.NORTH);
		this.add(footer,BorderLayout.SOUTH);
		this.add(list,BorderLayout.CENTER);
		
		newTask = footer.getNewTask();
		clear = footer.getClear();
		
		addListeners();
	}
	
	
	public void addListeners()
	{
		newTask.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				Task task = new Task();
				list.add(task);
				list.updateNumbers();
				
				
				task.getDone().addMouseListener(new MouseAdapter()
				{
					@Override
					public void mousePressed(MouseEvent e)
					{
						
						task.changeState();
						list.updateNumbers();
						revalidate();
						
					}
				});
			}
			
		});
		
		
		clear.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				list.removeCompletedTasks();
				repaint();
			}
		});
	}	
	
}
