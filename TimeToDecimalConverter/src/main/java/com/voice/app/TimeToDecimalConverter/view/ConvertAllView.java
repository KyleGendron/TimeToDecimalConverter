package com.voice.app.TimeToDecimalConverter.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.voice.app.TimeToDecimalConverter.controller.ConvertAllController;

public class ConvertAllView extends JPanel implements ListSelectionListener {
	ConvertAllController controller;
	JButton removeButton;

	/**
	 * Default Constructor
	 * @param controller the controller subscribing to
	 * this class' button commands.
	 */
	public ConvertAllView(ConvertAllController controller){
		this.controller = controller;
		initialize();
	}
	
	/**
	 * Helper method containing
	 * all the logic necessary
	 * to initialize this portion
	 * of the view.
	 */
	public void initialize(){
		setLayout(new GridBagLayout());
		
		//create, constrain, and add description label
		JLabel description = new JLabel("Files to convert: ");
		GridBagConstraints descConstraints = new GridBagConstraints();
		descConstraints.gridx = 0;
		descConstraints.gridy = 0;
		descConstraints.fill = GridBagConstraints.HORIZONTAL;
		descConstraints.weightx = 1;
		add(description, descConstraints);
		
		//create, constrain, and add the List
		JList fileList = new JList(new DefaultListModel());
		GridBagConstraints listConstraints = new GridBagConstraints();
		
		//create, constrain, and add the add button
		
		//create, constrain, and add the remove button
		
		//create, constrain, and add the cancel button
		
		//create, constrain, and add the process button
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
