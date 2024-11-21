/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1=preProcess(str1);
		str2=preProcess(str2);
		boolean check = true;
		String str2temp = str2;
		for (int i=0;i<str1.length();i++){
			check = false;
			str2= str2temp; 
			for (int j=0;j<str2.length();j++) {
				str2temp = "";
				if (str1.charAt(i) == str2.charAt(j)) {
					check = true;
					for (int t=0;t<str2.length();t++){
						if (t!=j) {
							str2temp=str2temp + str2.charAt(t); 
						}
					}
					j=str2.length();
				}
			}
			if (check == false) {
				i = str1.length();
			}
		}
		return check;
		
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
		String newString = "";
		for (int i=0;i<str.length();i++) {
			for (int j=0;j<alphabet.length();j++) {
				if (str.charAt(i) == alphabet.charAt(j)) {
					newString= newString + str.charAt(i);
				}
			}
		}
		newString = newString.toLowerCase();
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randomString = "";
		String tempStr = str;
		int randomInt;
		int strlength = str.length();
		for (int i=0; i<strlength; i++) {
			randomInt = (int) (Math.random()*(strlength-i));
			randomString = randomString + tempStr.charAt(randomInt);
			tempStr = tempStr.substring (0,randomInt) + tempStr.substring(randomInt+1, tempStr.length());
		}
		
		return randomString;
	}
}
