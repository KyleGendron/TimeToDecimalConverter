package com.voice.app.TimeToDecimalConverter.util;

import static org.junit.Assert.*;

import java.io.File;

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
		original = FileHandler.stringFromFile(origFile);
		answer = FileHandler.stringFromFile(ansFile);
	}
	
	@Before
	public void setUp() throws Exception{
		//replace the test-altered data with the original data
		FileHandler.clearFile(testFile);
		FileHandler.replaceFile(original, testFile);
	}
	
	@Test
	public void testProcessFile(){
		converter = new TimeToDecimalConverter(testFile);
		converter.processFile();
		assertEquals("The results and the correct result did not match.", 
				answer, FileHandler.stringFromFile(testFile));
	}
}
