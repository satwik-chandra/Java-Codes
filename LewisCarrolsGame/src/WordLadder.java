/* SELF ASSESSMENT 
1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: yes
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: yes

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: yes

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: yes
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: yes
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment:yes 

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: my method instead uses scanner to easily convert the whole text file into an array list
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: Since i use scanner it does'nt return anything

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: yes, i also have a difference counter that counts how many characters are different in the second word and if it is any different
than one it returns false

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: yes, it instead returns a boolean

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: yes
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: yes

 Total Mark out of 100 (Add all the previous marks):100
*/






import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner; 


public class WordLadder{

	public static void main(String[] args) throws FileNotFoundException{
		
		while(true) {
		
		ArrayList<String> wordChainInput = readWordList();
			
		if(wordChainInput.contains(null))
		{
		System.out.println("Thank You for using the application!");	
		System.exit(0);
		}
		
		else {
			
			if(isWordChain(wordChainInput))
			{
				System.out.println("Valid chain of words from Lewis Carroll's word-links game");
			}
			else
			{
				System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
			}
			
		}
		
		}
		

	}

	public static ArrayList<String> readDictionary() throws FileNotFoundException {
		
		File file = new File("D:\\eclipse Java\\LewisCarrolsGame\\src\\words.txt"); 
	    Scanner sc = new Scanner(file); 
	    ArrayList<String> words = new ArrayList<String>();
	    sc.useDelimiter("\\n"); 
	    while(sc.hasNext()==true) {
	    
	    	words.add(sc.next());
	    } 
	    return words;
	}
	
	public static ArrayList<String> readWordList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a comma separated list of words (or an empty list to quit):   ");
		
		String input = sc.next();
		if(input.equals(null)) {
			ArrayList<String> wordsArray = new ArrayList<String>();
			wordsArray.add(null);
			return wordsArray;
		}
		
		else {
			String[] words = input.split(",");
			ArrayList<String> wordsArray = new ArrayList<String>();
			for(int i = 0; i< words.length ; i++) 
			{
				wordsArray.add(words[i]);
			}
			 return wordsArray;
		}
		
		}
	
		
	public static boolean isUniqueList(ArrayList<String> word) {
		HashSet<String> hs = new HashSet<>(word);
	    if(hs.size()==word.size()) return true;
	    else return false;
		} 

	public static boolean isEnglishWord(String word) throws FileNotFoundException {
		ArrayList<String> dictionary = readDictionary();
		if(dictionary.contains(word)) return true;
		else return false;
	}
	
	public static boolean isDiffByOne (String word1, String word2) {
		int counter = word1.length();
		int differenceCounter = 0;
		 char [] word1Array = word1.toCharArray();
		 char [] word2Array = word2.toCharArray();
		 
		 for(int i = 0; i < counter; i++) {
			 if(word1Array[i] != word2Array[i]) differenceCounter++;
			 
		 }
		 
		 if(differenceCounter != 1) return false;
		 else return true;
		
	}

	
	public static boolean isWordChain (ArrayList<String> wordChain) throws FileNotFoundException {
		boolean isChain = false;
		
		for(int i=0;i< wordChain.size(); i++) {
			String word = wordChain.get(i);
			if(isEnglishWord(word)) {isChain = true;}
			else {isChain = false;
			return isChain;}
		}
		
		
		
		for(int i=0; (i+1)< wordChain.size(); i++) {
			String word1 = wordChain.get(i);
			String word2 = wordChain.get(i+1);
			if(word1.length() == word2.length()) {isChain = true;}
			else {isChain = false;
			return isChain;}
			}
		
		for(int i=0; (i+1)< wordChain.size(); i++) {
			String word1 = wordChain.get(i);
			String word2 = wordChain.get(i+1);
			if(isDiffByOne(word1,word2)) {isChain=true;}
			else 
			{isChain = false;
			return isChain;}
			}
		return isChain;
	}
	

}






 