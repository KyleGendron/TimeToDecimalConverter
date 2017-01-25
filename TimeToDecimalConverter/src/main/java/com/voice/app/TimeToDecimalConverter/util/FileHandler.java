package com.voice.app.TimeToDecimalConverter.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Mostly-static Utility class whose
 * methods are borrowed by the TimeToDecimalConverter
 * to read, overwrite, and clear files.
 * @author Kyle Gendron
 *
 */
public class FileHandler {

	/**
	 * Default Constructor
	 */
	public FileHandler(){}
	/**
	 * Static method that reads a file into a string and returns it.
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
	 * Static method that replaces a file's contents
	 * with the given string input
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
	 * Static method meant to clear a file before writing.
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
