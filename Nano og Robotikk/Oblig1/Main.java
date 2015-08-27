import java.util.ArrayList;

public class Main{







    private ArrayList<String> generateSwitchedWords(String s){
	ArrayList<String> allWords = new ArrayList<>();
	for(int i=0; i<s.length()-2; i++){
	    allWords.add(swap(i, i+1, s));
	}
	return null;
    }
    
    private String swap(int i, int j, String word){
	char[] wordArray = word.toCharArray();
	char tmp = wordArray[i];
	wordArray[i] = wordArray[j];
	wordArray[j] = tmp;
        
	return new String(word);
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
