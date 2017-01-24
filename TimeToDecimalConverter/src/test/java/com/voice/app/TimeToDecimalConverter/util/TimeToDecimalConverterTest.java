package com.voice.app.TimeToDecimalConverter.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;

public class TimeToDecimalConverterTest {
	//files to be used
	private static final File origFile = new File(System.getProperty("user.dir")
			+ "\\testfiles\\TestOriginal.csv");
	private static final File ansFile = new File(System.getProperty("user.dir")
			+ "\\testfiles\\TestAnswer.csv");
	private static final File testFile = new File(System.getProperty("user.dir")
			+ "\\testfiles\\Test.csv");
	
	private static TimeToDecimalConverter converter;
	private static String original, answer;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		original = TimeToDecimalConverter.stringFromFile(origFile);
		answer = TimeToDecimalConverter.stringFromFile(ansFile);
	}
	
	@Before
	public void setUp() throws Exception{
		//replace the test-altered data with the original data
		TimeToDecimalConverter.clearFile(testFile);
		TimeToDecimalConverter.replaceFile(original, testFile);
	}
	
	@Test
	public void testClearFile() throws IOException{
		TimeToDecimalConverter.clearFile(testFile);
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
				origContents, TimeToDecimalConverter.stringFromFile(origFile));
	}
	
	@Test
	public void testReplaceFile(){
		String ansContents = "GROUP,NAME,HOURS,BREAK,FOLLOWUP,MEETING,CAMPAIGN,DEPARTMENT\n"+
				",John,7.9625,0.262777778,1.201111111,0.721388889,Sales,Outbound\n"+
				",Jim,4.614166667,0.043333333,0.239722222,0.001111111,Sales,Outbound\n";
		TimeToDecimalConverter.replaceFile(ansContents, testFile);
		assertEquals("The input contents and the extracted file contents do not match.",
				ansContents, TimeToDecimalConverter.stringFromFile(testFile));
	}
	
	@Test
	public void testProcessFile(){
		converter = new TimeToDecimalConverter(testFile);
		converter.processFile();
		assertEquals("The results and the correct result did not match.", 
				answer, TimeToDecimalConverter.stringFromFile(testFile));
	}
}
