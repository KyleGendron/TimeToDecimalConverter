package com.voice.app.TimeToDecimalConverter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.voice.app.TimeToDecimalConverter.util.TimeToDecimalConverter;
import com.voice.app.TimeToDecimalConverter.view.MasterView;

/**
 * 
 * @author Kyle Gendron
 *
 */
public class ConvertAllController implements ActionListener{
	private MasterView masterView; //kept for use removing convert all submenu
	private final JFileChooser fileChooser = new JFileChooser();
	private ArrayList<File> files;

	public ConvertAllController(MasterView masterView){
		this.masterView = masterView;
		files = new ArrayList<File>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "Add":			int returnVal = fileChooser.showOpenDialog(masterView.getConvertAllView().getAddButton());
								//if the file is valid,
								if(returnVal == JFileChooser.APPROVE_OPTION){
									File file = fileChooser.getSelectedFile();
									//if the file has no duplicate
									if(isUnique(file)){
										files.add(file);
										masterView.getConvertAllView().addFileToList(file.getName());
									}else
										JOptionPane.showMessageDialog(masterView, "File already selected!");	
								}
								break;
			case "Remove":		files.remove(masterView.getConvertAllView().getList().getSelectedIndex());
								masterView.getConvertAllView().removeSelectedFromList();
								break;
			case "Cancel":		masterView.getConvertAllView().clearList();
								files.clear();
								masterView.removeConvertAllMenu();
								masterView.enableButtons();
								break;
			case "Process":		if(!files.isEmpty()){
									for(File f: files){
										TimeToDecimalConverter converter = new TimeToDecimalConverter(f);
										boolean result = converter.processFile();
										if(!result)
											JOptionPane.showMessageDialog(masterView, "Unable to convert"
													+ f.getName() + "!  Only able to convert .csv files.");
									}
									JOptionPane.showMessageDialog(masterView, "File processing completed!");
									masterView.getConvertAllView().clearList();
									files.clear();
								}else{
									JOptionPane.showMessageDialog(masterView, "No Files Selected!");
								}
								masterView.removeConvertAllMenu();
								masterView.enableButtons();
								break;
		}

	}

	/**
	 * Scans through file ArrayList and determines, based on absolute path,
	 * whether or not the given file (file) has a duplicate in the ArrayList.
	 * @param file the file being examined
	 * @return boolean whether there is a duplicate of "file" in the ArrayList.
	 */
	public boolean isUnique(File file){
		for(File f: files){
			if(file.getAbsolutePath().equals(f.getAbsolutePath()))
				return false;
		}
		return true;
	}
}
