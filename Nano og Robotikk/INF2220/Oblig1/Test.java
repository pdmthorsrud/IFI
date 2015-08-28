import java.util.ArrayList;

public class Test{
    public static void main(String[] args) {
	String s = "hei";
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

	for(String h: words){
	    System.out.println(h);
	}
    }


}
