package com.voice.app.TimeToDecimalConverter.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileHandlerTest {
	//files to be used
	private static final File origFile = new File(System.getProperty("user.dir")
			+ "\\testfiles\\TestOriginal.csv");
	private static final File testFile = new File(System.getProperty("user.dir")
			+ "\\testfiles\\Test.csv");

	private static String original;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		original = FileHandler.stringFromFile(origFile);
	}
	
	@Before
	public void setUp() throws Exception{
		//replace the test-altered data with the original data
		FileHandler.clearFile(testFile);
		FileHandler.replaceFile(original, testFile);
	}
	
	@Test
	public void testClearFile() throws IOException{
		FileHandler.clearFile(testFile);
		FileReader fr = new FileReader(testFile);
		assertEquals("File is not empty.", -1, fr.read());
		fr.close();
	}

	@Test
	public void testStringFromFile(){
		String origContents = "GROUP,NAME,HOURS,BREAK,FOLLOWUP,MEETING,CAMPAIGN,DEPARTMENT\n"+
				",John,07:57:45,00:15:46,01:12:04,00:43:17,Sales,Outbound\n"+
				",Jim,04:36:51,00:02:36,00:14:23,00:00:04,Sales,Outbound\n";
		assertEquals("The original file contents and the extracted file contents were not equal", 
				origContents, FileHandler.stringFromFile(origFile));
	}

	@Test
	public void testReplaceFile(){
		String ansContents = "GROUP,NAME,HOURS,BREAK,FOLLOWUP,MEETING,CAMPAIGN,DEPARTMENT\n"+
				",John,7.9625,0.262777778,1.201111111,0.721388889,Sales,Outbound\n"+
				",Jim,4.614166667,0.043333333,0.239722222,0.001111111,Sales,Outbound\n";
		FileHandler.replaceFile(ansContents, testFile);
		assertEquals("The input contents and the extracted file contents do not match.",
				ansContents, FileHandler.stringFromFile(testFile));
	}
}
