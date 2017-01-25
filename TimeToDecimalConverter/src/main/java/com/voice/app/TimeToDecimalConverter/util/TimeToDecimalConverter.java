package com.voice.app.TimeToDecimalConverter.util;

import java.io.File;

/**
 * Utility class that handles the converting of files.
 * Relies heavily on the static methods of the File Handler.
 * @author Kyle Gendron
 * @see FileHandler
 *
 */
public class TimeToDecimalConverter {
	File file;

	/**
	 * Standard constructor
	 * @param file the file to be processed
	 */
	public TimeToDecimalConverter(File file){
		this.file = file;
	}

	/**
	 * Helper method meant to process a file.
	 * All files must be of the form .csv.
	 * The bulk of this method is identifying
	 * Time formatting and replacing the entry,
	 * one entry at a time.  This method depends
	 * on others for reading the file into a string
	 * and replacing the original file with the
	 * contents converted.  
	 * @return boolean whether the method succeeded.
	 */
	public boolean processFile(){
		if(file.getAbsolutePath().endsWith(".csv")){
			String theFile = FileHandler.stringFromFile(file);
			if(theFile != null){
				String[] lines = theFile.split("(\r\n|\r|\n)");
				for(int h = 0; h < lines.length; h++){
					String[] elements = lines[h].split(",");
					for(int i = 0; i < elements.length; i++){
						if(elements[i].matches("[0-9]{2}:[0-9]{2}:[0-9]{2}")){
							//split the element into its numerical parts
							String[] numbers = elements[i].split(":");
							//add them together
							double dec = Double.parseDouble(numbers[0]) +
									(Double.parseDouble(numbers[1])/60) +
									(Double.parseDouble(numbers[2])/3600);
							//replace the original entry
							elements[i] = Double.toString(dec);
						}
					}
					//replace the original line
					String line = String.join(",", elements);
					lines[h] = line;
				}
				//join together the lines and replace the original file
				return FileHandler.replaceFile(String.join("\n", lines), file);
			}else
				return false;
		}else
			return false;
	}
}
