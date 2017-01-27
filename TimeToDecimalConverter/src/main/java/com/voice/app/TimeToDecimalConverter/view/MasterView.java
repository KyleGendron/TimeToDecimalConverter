package com.voice.app.TimeToDecimalConverter.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.voice.app.TimeToDecimalConverter.controller.ConvertAllController;
import com.voice.app.TimeToDecimalConverter.controller.MasterController;

/**
 * Main View class, a JFrame containing a simple, split GUI.
 * @author Kyle Gendron
 */
@SuppressWarnings("serial")
public class MasterView extends JFrame{
	MasterController controller;
	ConvertAllView subView;
	JButton convertOneButton, convertAllButton;
	JPanel bottomPanel;

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
		//declare main frame layout
		setLayout(new GridBagLayout());

		//declare top/bottom panel
		JPanel topPanel = new JPanel();

		//set top panel grid layout
		GridLayout layout = new GridLayout(0,2);
		topPanel.setLayout(layout);

		//create welcome label
		JTextArea welcome = new JTextArea("Please select a task to perform:\n"
				+ "-Convert One: Convert one file.\n"
				+ "-Convert All: Convert multiple files.\n"
				+ "-Exit: Close the program.");
		welcome.setLineWrap(true);
		welcome.setAlignmentX(CENTER_ALIGNMENT);
		welcome.setAlignmentY(TOP_ALIGNMENT);
		welcome.setEditable(false);

		//create button panel
		JPanel buttonPanel = new JPanel();
		GridLayout buttonColumns = new GridLayout(3,1);
		buttonPanel.setLayout(buttonColumns);

		//create convert one button and set up listener
		convertOneButton = new JButton("Convert One");
		convertOneButton.setVerticalTextPosition(JButton.CENTER);
		convertOneButton.setHorizontalTextPosition(JButton.CENTER);
		convertOneButton.addActionListener(controller);

		//create convert all button
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
		buttonPanel.add(convertOneButton);
		buttonPanel.add(convertAllButton);
		buttonPanel.add(exitButton);

		//add text and button panel to main frame
		topPanel.add(welcome);
		topPanel.add(buttonPanel);

		//specify top panel constraints and add
		GridBagConstraints topConstraints = new GridBagConstraints();
		topConstraints.gridx = 0;
		topConstraints.gridy = 0;
		topConstraints.weightx = 1;
		topConstraints.weighty = 1;
		topConstraints.fill = GridBagConstraints.HORIZONTAL;
		topConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(topPanel, topConstraints);


		//adjust final window settings
		setTitle("TimeToDecimalConverter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(390, 300));
		setMinimumSize(getPreferredSize());
		pack();
		setVisible(true);
	}

	/**
	 * Helper method that returns convert one
	 * button to help controller when an originating
	 * Component is required by the FilePicker.
	 * 
	 * @return JButton the button associated with
	 * the convert all use case.
	 */
	public JButton getConvertOneButton(){
		return convertOneButton;
	}

	/**
	 * Helper method for creating and displaying the
	 * convert all submenu below the main menu.
	 * @param subController the convert all controller the
	 * subscribes to the convert all view.
	 */
	public void addConvertAllMenu(ConvertAllController subController){
		bottomPanel = new JPanel();
		
		//maintain a lazy form of initialization using a dynamic singleton model
		if(subView != null)
			bottomPanel.add(subView);
		else{
			subView = new ConvertAllView(subController);
			bottomPanel.add(subView);
		}	
		
		//specify bottom panel constraints and add
		GridBagConstraints bottomConstraints = new GridBagConstraints();
		bottomConstraints.gridx = 0;
		bottomConstraints.gridy = 1;
		bottomConstraints.weightx = 1;
		bottomConstraints.weighty = 1;
		bottomConstraints.fill = GridBagConstraints.BOTH;
		bottomConstraints.anchor = GridBagConstraints.LAST_LINE_START;
		add(bottomPanel, bottomConstraints);
		
		pack();
		repaint();
	}
	
	/**
	 * Helper method for removing the convert all
	 * submenu and repacking/repainting the main frame.
	 */
	public void removeConvertAllMenu(){
		remove(bottomPanel);
		revalidate();
		pack();
		repaint();
	}
	
	/**
	 * Returns the ConvertAllView associated with this MasterView
	 * @return subView the ConvertAllView from this MasterView
	 */
	public ConvertAllView getConvertAllView(){
		return subView;
	}
	
	/**
	 * Helper method disables main menu
	 * buttons, minus the exit button
	 */
	public void disableButtons(){
		convertOneButton.setEnabled(false);
		convertAllButton.setEnabled(false);
	}
	
	/**
	 * Helper method enables main menu
	 * buttons, minus the exit button
	 */
	public void enableButtons(){
		convertOneButton.setEnabled(true);
		convertAllButton.setEnabled(true);
	}
}
