package com.fhdw.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.*;
import org.springframework.boot.SpringApplication;
import com.fhdw.StudentxApplication;

public class ServerGui extends JFrame implements ActionListener {
	
	JToggleButton startServerButton;
	JToggleButton stopServerButton;
	
	JPanel serverGuiPanelStatus;
	JPanel serverGuiPanel;
	
	public ServerGui(){
		this.setTitle("StudentX Server GUI");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(ServerGui.EXIT_ON_CLOSE);
	
		serverGuiPanelStatus = new JPanel();
		serverGuiPanelStatus.add(new ServerOutputStream());
		
		serverGuiPanel = new JPanel();
		serverGuiPanel.setLayout(new BorderLayout());
		
		startServerButton = new JToggleButton("Start StudentX");
		startServerButton.setPreferredSize(new Dimension(200,100));
		startServerButton.addActionListener(this);
		
		stopServerButton = new JToggleButton("Stop StudentX");
		stopServerButton.setPreferredSize(new Dimension (200,100));
		stopServerButton.addActionListener(this);
		
		serverGuiPanel.add(startServerButton, BorderLayout.NORTH);
		serverGuiPanel.add(stopServerButton, BorderLayout.SOUTH);
	
		JSplitPane splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
		splitPaneH.setLeftComponent(serverGuiPanel);
		splitPaneH.setRightComponent(serverGuiPanelStatus);
		
		this.add(splitPaneH);
	}
	
	
	public void actionPerformed (ActionEvent a){
		
		if(a.getSource() == this.startServerButton){
			if(stopServerButton.isSelected()){
				stopServerButton.setSelected(false);
			}
			System.out.println("Server wurde gestartet");
			SpringApplication.run(StudentxApplication.class);
        }
        else if(a.getSource() == this.stopServerButton){
        	if(startServerButton.isSelected()){
        		startServerButton.setSelected(false);
        	}
        	System.out.println("Server wurde gestoppt");
        	System.exit(0);
        }
		
	}
}
