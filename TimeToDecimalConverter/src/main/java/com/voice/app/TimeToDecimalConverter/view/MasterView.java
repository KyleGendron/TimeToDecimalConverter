package com.voice.app.TimeToDecimalConverter.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.voice.app.TimeToDecimalConverter.controller.MasterController;

/**
 * Main View class, a JFrame containing a simple, split GUI.
 * @author Kyle Gendron
 */
@SuppressWarnings("serial")
public class MasterView extends JFrame{
	MasterController controller;
	JButton convertAllButton;
	
	/**
	 * Default constructor
	 * @param controller the controller to which this View refers.
	 */
	public MasterView(MasterController controller){
		this.controller = controller;
	}
	
	/**
	 * Helper method that contains all of the modifications to the 
	 * main GUI, including its components, frame, and layout.
	 */
	public void initializeGUI(){
		//set grid layout
		GridLayout layout = new GridLayout(0,2);
		this.setLayout(layout);
		
		//create welcome label
		JTextArea welcome = new JTextArea("Please select a task to perform.");
		welcome.setLineWrap(true);
		welcome.setAlignmentX(CENTER_ALIGNMENT);
		welcome.setAlignmentY(TOP_ALIGNMENT);
		welcome.setEditable(false);
		
		//create button panel
		JPanel buttonPanel = new JPanel();
		GridLayout buttonColumns = new GridLayout(4,1);
		buttonPanel.setLayout(buttonColumns);
		
		//create convert all button and set up listener
		convertAllButton = new JButton("Convert All");
		convertAllButton.setVerticalTextPosition(JButton.CENTER);
		convertAllButton.setHorizontalTextPosition(JButton.CENTER);
		convertAllButton.addActionListener(controller);
		
		//create exit button
		JButton exitButton = new JButton("Exit");
		exitButton.setVerticalTextPosition(JButton.CENTER);
		exitButton.setHorizontalTextPosition(JButton.CENTER);
		exitButton.addActionListener(controller);
		
		//add button to button panel
		buttonPanel.add(convertAllButton);
		buttonPanel.add(exitButton);
		
		//add text and button panel to main frame
		add(welcome);
		add(buttonPanel);
		
		//adjust final window settings
		setTitle("TimeToDecimalConverter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(370, 150));
		setMinimumSize(getPreferredSize());
		pack();
		setVisible(true);
	}
	
	/**
	 * Helper method that returns convert all
	 * button to help controller when an originating
	 * Component is required by the FilePicker.
	 * 
	 * @return JButton the button associated with
	 * the convert all use case.
	 */
	public JButton getConvertAllButton(){
		return convertAllButton;
	}
}
