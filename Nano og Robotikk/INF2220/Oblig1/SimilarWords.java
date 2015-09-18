import java.util.ArrayList;

public class SimilarWords{

    public static ArrayList<String> generateSimilarWords(String s){
	ArrayList<String> finalWords = new ArrayList<>();
	ArrayList<String> first = new ArrayList<>();
	ArrayList<String> second = new ArrayList<>();
	ArrayList<String> third = new ArrayList<>();	
	
	finalWords = generateSwitchedLetterWords(s);

	first = generateLetterMissingWords(s);
	mergeArrayLists(finalWords, first);

	second = generateLetterAddedWords(s);
	mergeArrayLists(finalWords, second);

	third = generateLetterReplacedWords(s);
	mergeArrayLists(finalWords, third);

	return finalWords;
	
    }

    public static ArrayList<String> mergeArrayLists(ArrayList<String> first, ArrayList<String> second){
	for(String h : second){
	    first.add(h);
	}
	return first;
    }
    
    public static ArrayList<String> generateSwitchedLetterWords(String s){
	ArrayList<String> words = new ArrayList<>();
	for(int i=0; i<s.length()-2; i++){
	    words.add(swap(i, i+1, s));
	}
	return words;
    }
    
    public static String swap(int i, int j, String word){
	char[] wordArray = word.toCharArray();
	char tmp = wordArray[i];
	wordArray[i] = wordArray[j];
	wordArray[j] = tmp;

	return new String(word);
    }


    public static ArrayList<String> generateLetterReplacedWords(String s){

	char[] original = s.toCharArray();
	char[] tmp;
	ArrayList<String> words = new ArrayList<String>();
	char traversingChar = 'a';

	for(int i=0; i<original.length; i++){
	    tmp = original.clone();
	    traversingChar = 'a';
	    for(int j=0; j<26; j++){
		tmp[i] = traversingChar;
		words.add(new String(tmp));
		traversingChar++;
	    }
	}
	return words;
    }

    public static ArrayList<String> generateLetterMissingWords(String s){

	ArrayList<char[]> wordsChar = generateWordsWithHoles(s);
	ArrayList<String> wordsString = putInMissingLetter(wordsChar);

	return wordsString;

    }

    public static ArrayList<String> putInMissingLetter(ArrayList<char[]> words){
	ArrayList<String> finalWords = new ArrayList<>();
	int nullPointer=0;
	//does two forloops for each of the words
	for(char[] charArray: words){
	    char traversingChar = 'a';
	    //finds the hole in each word and sets a nullPointer int
	    for(int i=0; i<charArray.length; i++){
		if(charArray[i]==' '){
		    nullPointer=i;
		}
	    }
	    //Changes the nullpointer to the traversing char and adds it to  final list of words
	    for(int i=0; i<26; i++){
		charArray[nullPointer] = traversingChar;
		finalWords.add(new String(charArray));
		traversingChar++;
	    }
	}
	return finalWords;
    }

    public static ArrayList<char[]> generateWordsWithHoles(String s){
	char[] original = s.toCharArray();
	int lengthOfChar = s.length()+1;

	char[] emptyChar = new char[lengthOfChar];
	char[] tmp = new char[lengthOfChar];
	ArrayList<char[]> wordsWithHoles = new ArrayList<char[]>();
	int indeksForWord = 0;
	
	for(int i=0; i<s.length()+1; i++){
	    tmp = emptyChar.clone();
	    indeksForWord=0;
	    for(int j=0; j<lengthOfChar; j++){
		if(j!=i){
		    tmp[j] = original[indeksForWord];
		    indeksForWord++;
		}else{
		    tmp[j] = ' ';
		}
	    }
	    wordsWithHoles.add(tmp);
	}

	return wordsWithHoles;
    }

    public static ArrayList<String> generateLetterAddedWords(String s){
	ArrayList<String> finalWords = new ArrayList<>();
	String word;

	
	for(int i=0; i<s.length(); i++){
	    if(i==0){
		word = s.substring(i+1);
		finalWords.add(word);
	    }else{
	        word = s.substring(0, i) + s.substring(i+1);
		finalWords.add(word);
	    }	    	    
	}

	return finalWords;
    }
}
