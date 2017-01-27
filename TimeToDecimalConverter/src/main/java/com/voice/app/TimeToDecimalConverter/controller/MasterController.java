package com.voice.app.TimeToDecimalConverter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.voice.app.TimeToDecimalConverter.util.TimeToDecimalConverter;
import com.voice.app.TimeToDecimalConverter.view.ConvertAllView;
import com.voice.app.TimeToDecimalConverter.view.MasterView;

/**
 * 
 * @author Kyle Gendron
 *
 *Main controller class, a listener containing the MasterView.
 *Application's entry point.
 */
public class MasterController implements ActionListener{
	private MasterView view;
	private final JFileChooser fileChooser = new JFileChooser();
	
	/**
	 * Standard Constructor
	 */
	public MasterController(){
		this.view = new MasterView(this);
	}

	/**
	 * Simple helper method used to call the GUI
	 * initialization remotely through the controller
	 * to be executed in the EventQueue for thread safety.
	 */
	public void displayGUI(){
		view.initializeGUI();
	}
	
	/**
	 * Executes commands sent by components this class listens to.
	 * Thus far: the Exit and Convert All buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "Convert One":	int returnVal = fileChooser.showOpenDialog(view.getConvertOneButton());
								if(returnVal == JFileChooser.APPROVE_OPTION){
									File file = fileChooser.getSelectedFile();
									//TODO: process file using TimeToDecimalConverter
									TimeToDecimalConverter converter = new TimeToDecimalConverter(file);
									boolean result = converter.processFile();
									if(result)
										JOptionPane.showMessageDialog(view, "Successfully converted!");
									else
										JOptionPane.showMessageDialog(view, "Unable to convert!");
								}
								break;
			case "Convert All":	ConvertAllController subController = new ConvertAllController(view);
								view.addConvertAllMenu(subController);
								//process
								//once finished, remove these components and repack
								break;
			case "Exit":		System.exit(0);
						 		break;
		}
		
	}
}
