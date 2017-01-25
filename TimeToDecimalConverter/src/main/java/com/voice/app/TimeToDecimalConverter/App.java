package com.voice.app.TimeToDecimalConverter;

import java.awt.EventQueue;

import com.voice.app.TimeToDecimalConverter.controller.MasterController;

/**
 *
 *Top level application class that coordinates the calls to view and Controller
 *@version 1.1
 *@author Kyle Gendron
 *
 *
 */
public class App 
{
	/**
	   * Entry point for application : calls {@link MasterController}
	   *
	   * @param args main program arguments, currently not used
	   */
    public static void main( String[] args )
    {
        MasterController controller = new MasterController();
        EventQueue.invokeLater(controller::displayGUI);
    }
}
