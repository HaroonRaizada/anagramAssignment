package utility;

public class AnagramCheck {

	public static boolean checkAnalgram(String wordone, String wordtwo) {
		if(wordone.equalsIgnoreCase(wordtwo)) {
			//if there are duplicates , no need to club them in a group
			return false;
		}
		char[] first = wordone.toLowerCase().toCharArray();
		char[] second = wordtwo.toLowerCase().toCharArray();
		// if length of strings is not same
		if (first.length != second.length)
			return false;
		int[] counts = new int[26];
		for (int i = 0; i < first.length; i++) {
			
			counts[first[i] - 97]++;
			counts[second[i] - 97]--;
		}
		for (int i = 0; i < 26; i++)
			if (counts[i] != 0)
				return false;
		return true;

	}
}
