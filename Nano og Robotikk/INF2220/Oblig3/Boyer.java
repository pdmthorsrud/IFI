import java.util.*;
import java.io.*;

public class Boyer{

  public void startProgram(String needleFile, String haystackFile) throws Exception{
		char[] needle = makeCharArray(needleFile);
		char[] haystack = makeCharArray(haystackFile);

    ArrayList<Integer> indexes = searchForNeedle(needle, haystack);
    System.out.println(" The indexes at which '" + new String(needle) + "' occur are as follows: ");
    for(int e: indexes){
      System.out.println(" " + e + " || String: " + returnMatchedWord(e, needle.length, haystack));
    }
	}

  public ArrayList<Integer> searchForNeedle(char[] needle, char[] haystack){
    System.out.println(" Length of needle: " + needle.length);
    System.out.println(" Length of haystack: " + haystack.length);
    ArrayList<Integer> matchedIndexes = new ArrayList<>();
    int[] badCharShift = new int[256]; // 256 = MAX_CHAR
    int offset = 0, scanIndex = 0;
    int maxOffset = haystack.length - needle.length;
    int lastIndexNeedle = needle.length - 1;
    int lastUnderscore = findLastUnderscore(needle);

    System.out.println(" lastIndexNeedle: " + lastIndexNeedle);
    System.out.println(" maxOffset: " + maxOffset);

    //sets all values in badCharShift, taking into account any underscores
    if(lastUnderscore==-1){ //there are no underscores
      for(int i=0; i<badCharShift.length; i++){
        badCharShift[i] = needle.length;
      }
    }else{ //there is at least one underscore, and this makes sure it never passes that without checking it first
      for(int i=0; i<badCharShift.length; i++){
        if(lastIndexNeedle==lastUnderscore){
          badCharShift[i] = 1;
        }else{
          badCharShift[i] = lastIndexNeedle-lastUnderscore;
        }
      }
    }
    //sets badCharShifts for all letters present in needle
    for(int i=0; i<lastIndexNeedle; i++){
      if((lastIndexNeedle-i)>(lastIndexNeedle-lastUnderscore)){ //finds out wether the shortest shift is to next underscore or next corresponding letter
        badCharShift[(int) needle[i]] = lastIndexNeedle - i;
      }else{
        badCharShift[(int) needle[i]] = lastIndexNeedle-lastUnderscore;
      }
    }

    while(offset<=maxOffset){
      for(scanIndex=lastIndexNeedle; needle[scanIndex]==haystack[offset+scanIndex] || (int) needle[scanIndex]==95; scanIndex--){
        if(scanIndex==0){ //every char matches
          matchedIndexes.add(offset);
          if(offset==maxOffset){
            break;
          }
          offset++; //moves the comparison a step forward
          scanIndex=lastIndexNeedle; //'reseting' the for loop
        }
      }
      offset += badCharShift[haystack[offset+lastIndexNeedle]];
    }
    if(matchedIndexes.isEmpty()){
      return null;
    }
    return matchedIndexes;
  }

	public char[] makeCharArray(String file) throws Exception{
		Scanner in = new Scanner(new File(file));
		if(in.hasNextLine()){
        		String read = in.nextLine();
			char[] array = read.toCharArray();
			return array;
		}else{
			System.out.println("This file does not contain anything");
			return null;
		}
	}

  public int findLastUnderscore(char[] a){
    for(int i=a.length-1; i>=0; i--){
      if(a[i]==95){
        return i;
      }
    }
    return -1;
  }

  public String returnMatchedWord(int index, int length, char[] haystack){
    String returnString="";
    for(int i=0; i<length; i++){
      returnString+=haystack[index+i];
    }
    return returnString;
  }
}
