package com.notepad;

import java.awt.*;
import javax.swing.*;
public class TitleBar extends JPanel{

	TitleBar()
	{
		this.setPreferredSize(new Dimension(400,60));
		this.setBackground(new Color(0x54BAB9));


		
		JLabel titleText = new JLabel("To Do List");
		titleText.setPreferredSize(new Dimension(400,60));
		titleText.setForeground(new Color(0xFBF8F1));
		titleText.setFont(new Font("MS Sans Serif",Font.BOLD+Font.ITALIC, 50));
		titleText.setHorizontalAlignment(JLabel.CENTER);
		this.add(titleText);

	}
}
