import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {

	BinaryTree bt = new BinaryTree();
	File file = new File("dictionary.txt");
	Scanner in = new Scanner(file);
	String read;
	while(in.hasNextLine()){
	    read = in.nextLine();
	    bt.insert(read);
	}
	removeReInsert(bt);

	bt.findNodesPerDepth(bt.root);

	menu(bt);


    }


    private static void removeReInsert(BinaryTree bt){

	System.out.println("Searching for 'busybody' || " + bt.search("busybody"));
	System.out.println("Searching for 'bladelike' || " + bt.search("bladelike"));
	System.out.println("Searching for 'akiapmin' || " + bt.search("akiapmin"));

	System.out.println("Removing 'busybody'");
	bt.remove("busybody", bt.root);
	System.out.println("Done removing 'busybody'");

	System.out.println("Searching for 'busybody' || " + bt.search("busybody"));
	System.out.println("Searching for 'busybodyism' || " + bt.search("busybodyism"));
	System.out.println("Searching for 'campeau' || " + bt.search("campeau"));
	System.out.println("Searching for 'calfish' || " + bt.search("calfish"));
	System.out.println("Inserting 'busybody' || " + bt.insert("busybody"));
	System.out.println("Searching for 'busybody' || " + bt.search("busybody"));

    }

    private static void menu(BinaryTree bt) throws Exception{
	Scanner user = new Scanner(System.in);
	String enteredText = "";

	while(!enteredText.toLowerCase().equals("q")){
	    System.out.println("\nPlease enter your searchword, then RET || 'q' to exit");
	    enteredText = user.nextLine();
	    System.out.println("Searching for '" + enteredText + "'");
	    String searchResult = bt.search(enteredText);


	    if(searchResult!=null){
		System.out.println("Found: " + searchResult);
	    }else{
		System.out.println("'" + enteredText + "' does not exist");
		bt.suggestSimilarWords(enteredText);
	    }
	}
    }

}
