package com.voice.app.TimeToDecimalConverter.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Utility class that handles the converting of files.
 * @author Kyle Gendron
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
	 * @see stringFromFile, replaceFile
	 */
	public boolean processFile(){
		if(file.getAbsolutePath().endsWith(".csv")){
			String theFile = stringFromFile(file);
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
				return replaceFile(String.join("\n", lines), file);
			}else
				return false;
		}else
			return false;
	}

	/**
	 * Helper method that reads a file into a string and returns it.
	 * @param file the file to be read into a string
	 * @return string the string resulting from reading in
	 * the whole file
	 */
	public static String stringFromFile(File file){
		try {
			Scanner scan = new Scanner(file);
			StringBuilder string = new StringBuilder();
			while(scan.hasNextLine())
				string.append(scan.nextLine() + "\n");
			scan.close();
			return string.toString();
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	/**
	 * Helper method that replaces a file's contents
	 * with the given string input
	 * @param input the desired new contents of the file
	 * @return boolean whether the method succeeded or not
	 * @throws IOException 
	 */
	public static boolean replaceFile(String input, File file){
		FileWriter writer;
		try {
			clearFile(file);
			writer = new FileWriter(file, false);
			writer.write(input);
			writer.close();
			return true;
		} catch (IOException e) {
			return false;
		}

	}
	
	/**
	 * Helper method meant to clear a file before writing.
	 * @param file the file to be cleared
	 */
	public static void clearFile(File file){
		try {
			PrintWriter writer = new PrintWriter(file);
			writer.close();
		} catch (FileNotFoundException e) {
			return;
		}
	}
}
