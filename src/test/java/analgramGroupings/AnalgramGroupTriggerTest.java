package analgramGroupings;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.logging.Logger;

import org.junit.Test;

import anagramGroupings.AnagramGroupTrigger;

public class AnalgramGroupTriggerTest {

	public static Logger logger = Logger.getLogger("AnalgramGroupTriggerTest");

	// Test case to test example 1 text file. It should be successful
	@Test
	public void executeTestForAnalgramTest2() throws Exception {
		String filePath = "example1.txt";
		boolean isFlag = false;
		try {
			isFlag = AnagramGroupTrigger.groupAnagrams(filePath);
		} catch (IOException e) {
			logger.info("An error occurred while checking the file path" + e);

		}
		assertEquals(true, isFlag);
	}

	// Test will throw invalid value error if no file found
	@Test
	public void executeTestForAnalgramTestNoFileFound() throws Exception {
		String filePath = "noFileExists.txt";
		boolean isFlag = false;
		try {
			isFlag = AnagramGroupTrigger.groupAnagrams(filePath);
		} catch (IOException e) {
			logger.info("An error occurred while checking the file path" + e);

		}
		assertEquals(false, isFlag);
	}

	// Test will not throw error if junk data is passed in file.
	@Test
	public void executeTestForAnalgramTestJunkData() throws Exception {
		String filePath = "junkData.txt";
		boolean isFlag = false;
		try {
			isFlag = AnagramGroupTrigger.groupAnagrams(filePath);
		} catch (Exception e) {
			logger.info("An error occurred while checking the file path" + e);

		}
		assertEquals(true, isFlag);
	}

	// Test will not throw error if empty file data is passed in file.It will not
	// print anything
	@Test
	public void executeTestForAnalgramTestEmptyFile() throws Exception {
		String filePath = "emptyFile.txt";
		boolean isFlag = false;
		try {
			isFlag = AnagramGroupTrigger.groupAnagrams(filePath);
		} catch (Exception e) {
			logger.info("An error occurred while checking the file path" + e);

		}
		assertEquals(false, isFlag);
	}

}