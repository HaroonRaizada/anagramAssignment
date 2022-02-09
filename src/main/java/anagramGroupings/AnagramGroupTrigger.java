package anagramGroupings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import utility.AnagramCheck;

public class AnagramGroupTrigger {
	public static Logger logger = Logger.getLogger("AnagramGroupTrigger");
	public AnagramCheck anagramCheck=new AnagramCheck();
	public static void main(String[] args) throws Exception {

		if (args != null && args.length > 0) {
			// get file path from the command line arguments
			String filePath =args[0];

			groupAnagrams(filePath);
		} else {
			throw new Exception("invalid input passed");
		}
	}

	public static boolean groupAnagrams(String filePath) throws IOException {

		FileInputStream inputStream = null;
		Scanner sc = null;
		boolean isEmpty=true;
		HashMap<String, List<String>> mapOfAnagrams = new HashMap<>();
		try {
			inputStream = new FileInputStream(filePath);
			sc = new Scanner(inputStream, "UTF-8");
			//here instead of loading file complete data, we are iterating through each line. This will avoid loading huge file in memory
			while (sc.hasNextLine()) {
				isEmpty=false;
				List<String> newArray = new ArrayList<>();
				String origString = sc.nextLine();
				char[] word = origString.toLowerCase().toCharArray();
				Arrays.sort(word);
				String sortedString= String.valueOf(word);
				if (mapOfAnagrams.containsKey( sortedString)) {
					// here we are considering only first element of list, as checking analgram with
					// one word of group is enough
					
					//one note: Here analgram can be checked by hashmap directly comparing the key,
					//but since it was mentioned in assignment, that no function or library should be used
					if (AnagramCheck.checkAnalgram(mapOfAnagrams.get( sortedString).get(0), origString)) {
						newArray = mapOfAnagrams.get(sortedString);
					}
				}
				newArray.add(origString);
				mapOfAnagrams.put(sortedString, newArray);
			}
			mapOfAnagrams.entrySet().forEach(entry -> {
				System.out.println(entry.getValue());
			});
			// note that Scanner suppresses exceptions so we need to manually handle this.
			if (sc.ioException() != null) {
				logger.info("An Io exception has occured with error"+sc.ioException());
				return false;
			}
		} catch (FileNotFoundException e) {

			logger.info("File is not found at path"+filePath);
			return false;
		}catch (Exception e) {

			logger.info("Exception occurred with error"+e);
			return false;
		}  
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
		}
		if(isEmpty) {
			logger.info("File is empty");
			return !isEmpty;
		}
		return true;
	}



}
