import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

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
    //sets all needed variables
    ArrayList<Integer> matchedIndexes = new ArrayList<>();
    int offset = 0, scanIndex = 0;
    int maxOffset = haystack.length - needle.length;
    int lastIndexNeedle = needle.length - 1;
    int[] badCharShift = makeBadCharShift(needle, lastIndexNeedle); //generates the badCharShift array
    // this is the part that actually checks the needle.
    while(offset<=maxOffset){
      //checks wether the needleIndex is equal to the corresponding haystack index. Using offset as the variable that decides where I compare
      //the needle to the haystack. If it is equal OR it is a underscore the scanIndex gets lowered and you compare the next letter
      //scanIndex == 0 it means we have checked every single char and they all match. We then add the starting index for that aligment of characters
      //if we are not at the end of the haystack (offset!=maxOffset) I siply add one to offset, and in other words jump to next position.
      //I also reset scanIndex. I basically reset the for loop, and start comparing at the new offset. If we are at the end of the
      //haystack (offset==maxOffset) I simply break the for loop without adding anything to offset.
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
    //there are no matches, and I return null
    if(matchedIndexes.isEmpty()){
      return null;
    }
    return matchedIndexes;
  }

	public char[] makeCharArray(String file) throws Exception{
		Scanner in = new Scanner(new File(file));
    StringBuilder read = new StringBuilder("");
    if(!in.hasNextLine()){
      System.out.println(" The file is empty. Exiting program");
      System.exit(0);
      return null;
    }
    while(in.hasNextLine()){
      read.append(in.nextLine());
		}
    char[] array = read.toString().toCharArray();
    return array;
	}

  public int[] makeBadCharShift(char[] needle, int lastIndexNeedle){
    int[] badCharShift = new int[256];
    int lastUnderscore = findLastUnderscore(needle);

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
      if((lastIndexNeedle-i)>(lastIndexNeedle-lastUnderscore)){
        badCharShift[(int) needle[i]] = lastIndexNeedle - i;
      }else{
        badCharShift[(int) needle[i]] = lastIndexNeedle-lastUnderscore;
      }
    }
    return badCharShift;
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
