package com.fhdw.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.fhdw.StudentxApplication;

public class ServerGui extends JFrame implements ActionListener {
	
	JToggleButton startButton;
	JToggleButton stopButton;
	
	JPanel serverGuiStatusPanel;
	JPanel serverGuiButtonPanel;
	JPanel serverGuiButtonPanelTop;
	JPanel serverGuiButtonPanelBottom;
	
	public ServerGui(){
		this.setTitle("StudentX Server v1.0");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(ServerGui.EXIT_ON_CLOSE);
	
		serverGuiStatusPanel = new JPanel();
		serverGuiStatusPanel.add(new ServerOutputStream());
		serverGuiStatusPanel.setLayout(new GridLayout());
		
		startButton = new JToggleButton("Start StudentX");
		startButton.setPreferredSize(new Dimension(150,75));
		startButton.addActionListener(this);
		
		stopButton = new JToggleButton("Stop StudentX");
		stopButton.setPreferredSize(new Dimension (150,75));
		stopButton.addActionListener(this);
		
		serverGuiButtonPanel = new JPanel(new GridLayout());
		serverGuiButtonPanelTop = new JPanel();
		serverGuiButtonPanelBottom = new JPanel ();
		
		serverGuiButtonPanelTop.add(startButton);
		serverGuiButtonPanelBottom.add(stopButton);
		
		
		JSplitPane splitPaneV = new JSplitPane (JSplitPane.VERTICAL_SPLIT);
		splitPaneV.setTopComponent(serverGuiButtonPanelTop);
		splitPaneV.setBottomComponent(serverGuiButtonPanelBottom);
		splitPaneV.setResizeWeight(0.5);
		splitPaneV.setDividerSize(0);
		serverGuiButtonPanel.add(splitPaneV);
	
		JSplitPane splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
		splitPaneH.setLeftComponent(serverGuiButtonPanel);
		splitPaneH.setRightComponent(serverGuiStatusPanel);
		splitPaneH.setDividerSize(0);
		splitPaneH.setDividerLocation(300);
		
		this.add(splitPaneH);
	}
	
	public void actionPerformed (ActionEvent a){
		
		if(a.getSource() == this.startButton){
			Thread t = new Thread(){
				public void run(){
					StudentxApplication.start();
				}
			};
			t.start();
			if(stopButton.isSelected()){
				stopButton.setSelected(false);
			}
        }
        else if(a.getSource() == this.stopButton){
        	int reply=warningMessage();
        	if (reply==0){
        		if(startButton.isSelected()){
            		startButton.setSelected(false);
            	}
        		Thread t = new Thread(){
    				public void run(){
    					StudentxApplication.stop();
    				}
    			};
    			t.start();
        	}
        	stopButton.setSelected(false);
        }
	}
	int warningMessage(){
		int reply = JOptionPane.showConfirmDialog(null,"Soll die Anwendung wirklich geschlossen werden?","Warnung", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		return reply;		
	}
}
