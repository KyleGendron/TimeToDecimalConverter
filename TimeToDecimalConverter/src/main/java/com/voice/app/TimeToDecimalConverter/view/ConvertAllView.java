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
	JButton addButton;

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
		descConstraints.gridwidth = 4;
		add(description, descConstraints);
		
		//create, constrain, and add the List
		JList fileList = new JList(new DefaultListModel());
		GridBagConstraints listConstraints = new GridBagConstraints();
		listConstraints.gridx = 0;
		listConstraints.gridy = 1;
		listConstraints.fill = GridBagConstraints.HORIZONTAL;
		listConstraints.weightx = 1;
		listConstraints.ipady = 80;
		listConstraints.gridwidth = 4;
		add(fileList, listConstraints);
		
		//create, constrain, and add the add button
		addButton = new JButton("Add");
		GridBagConstraints addButtonConstraints = new GridBagConstraints();
		addButtonConstraints.gridx = 0;
		addButtonConstraints.gridy = 2;
		addButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
		addButtonConstraints.weightx = 0.5;
		add(addButton, addButtonConstraints);
		
		//create, constrain, and add the remove button
		JButton removeButton = new JButton("Remove");
		GridBagConstraints removeButtonConstraints = new GridBagConstraints();
		removeButtonConstraints.gridx = 1;
		removeButtonConstraints.gridy = 2;
		removeButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
		removeButtonConstraints.weightx = 0.5;
		add(removeButton, removeButtonConstraints);
		
		//create, constrain, and add the cancel button
		JButton cancelButton = new JButton("Cancel");
		GridBagConstraints cancelButtonConstraints = new GridBagConstraints();
		cancelButtonConstraints.gridx = 2;
		cancelButtonConstraints.gridy = 2;
		cancelButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
		cancelButtonConstraints.weightx = 0.5;
		add(cancelButton, cancelButtonConstraints);
		
		//create, constrain, and add the process button
		JButton processButton = new JButton("Process");
		GridBagConstraints processButtonConstraints = new GridBagConstraints();
		processButtonConstraints.gridx = 3;
		processButtonConstraints.gridy = 2;
		processButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
		processButtonConstraints.weightx = 0.5;
		add(processButton, processButtonConstraints);
		
		setVisible(true);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
