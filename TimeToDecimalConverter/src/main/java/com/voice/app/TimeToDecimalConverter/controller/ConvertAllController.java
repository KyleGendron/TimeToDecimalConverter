package com.voice.app.TimeToDecimalConverter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.voice.app.TimeToDecimalConverter.view.MasterView;

public class ConvertAllController implements ActionListener{

	MasterView masterView; //kept for use removing convert all submenu
	
	public ConvertAllController(MasterView masterView){
		this.masterView = masterView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
