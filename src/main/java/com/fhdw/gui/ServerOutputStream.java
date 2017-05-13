package com.fhdw.gui;

import java.awt.BorderLayout;
import java.io.PrintStream;

import javax.swing.*;

public class ServerOutputStream extends JPanel {
	
	private JTextArea textArea = new JTextArea();
	private TextAreaOutputStream taOutputStream = new TextAreaOutputStream(textArea, "StudentX");
	
	public ServerOutputStream() {
	      setLayout(new BorderLayout());
	      add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
	      System.setOut(new PrintStream(taOutputStream));
	   }

}
