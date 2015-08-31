import java.util.ArrayList;

public class Main{


    public static void main(String[] args) {
	String hei = "lkhjueartwklhdsgfljkhsdfgkjh";
	generateWordsWithHoles(hei);
    }






    private static ArrayList<String> generateSwitchedWords(String s){
	ArrayList<String> words = new ArrayList<>();
	for(int i=0; i<s.length()-2; i++){
	    words.add(swap(i, i+1, s));
	}
	return words;
    }

    private static String swap(int i, int j, String word){
	char[] wordArray = word.toCharArray();
	char tmp = wordArray[i];
	wordArray[i] = wordArray[j];
	wordArray[j] = tmp;

	return new String(word);
    }


    private static ArrayList<String> generateLetterReplacedWords(String s){

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



    private static ArrayList<String> generateLetterMissingWords(String s){

	char[] original = new char[s.length()];
	for(int i=0; i<s.length(); i++){

	}
	char[] tmp;
	ArrayList<String> words = new ArrayList<String>();
	char traversingChar = 'a';
	/*
	  for(int i=0; i<original.length; i++){
	  tmp = original.clone();
	  traversingChar = 'a';
	  for(int j=0; j<26; j++){
	  tmp[i] = traversingChar;
	  words.add(new String(tmp));
	  traversingChar++;
	  }
	  }*/
	return words;
    }

    private static ArrayList<char[]> generateWordsWithHoles(String s){
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
		}
	    }
	    wordsWithHoles.add(tmp);
	}

	for(char[] kar: wordsWithHoles){
	    String ord = new String(kar);
	    System.out.println(ord);
	}
	return wordsWithHoles;
    }

    


    private class Node{
	String data;
	Node left;
	Node right;

	Node(String data){
	    this.data = data;
	    this.left = null;
	    this.right = null;
	}

	Node(String data, Node left, Node right){
	    this.data = data;
	    this.left = left;
	    this.right = right;
	}
    }
}
