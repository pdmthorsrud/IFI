import java.util.*;
import java.io.*;

public class BinaryTree{

    Node root = null;
    ArrayList<Integer> treeDepths = new ArrayList<Integer>();
    int maxDepth=0;
    int[] nodesPerDepth;
    double averageDepthOfNodes=0;
    String alphabeticallyFirst;
    String alphabeticallyLast;

    //insert method. Realised later that I could've written it recursively. Code worked, however, and I decided to keep it
    public boolean insert(String data){
	Node currentNode;
	Node currentNodeParent;
	boolean isLeft=true;

	//takes care of basecase where the tree is empty and sets the root
	if(root==null){
	    root = new Node(data);
	    return true;
	}else{
	    //if the tree is not empty I traverse down the tree until I find a leaf node. I also track the parent
	    // of currentNode with a curentNodeParent (For easier application of correct pointers. Did also implement a boolean
	    //isLeft to keep track of wether I was in left or right child of the parent (for easier placement of pointers)
	    currentNodeParent = root;
	    currentNode = root;
	    while(currentNode!=null){

		int compareInt = currentNode.getData().compareTo(data);
		//if compareInt is 0, it means the content is equal and there's no need to put in a new node
		if(compareInt==0){
		    System.out.println("Found an identical node");
		    return false;
		}else if(compareInt<0){
		    currentNodeParent = currentNode;
		    currentNode = currentNode.right;
		    isLeft = false;
		}else{
		    currentNodeParent = currentNode;
		    currentNode = currentNode.left;
		    isLeft = true;
		}
	    }
	    //puts in the new node and assign the parent's pointer
	    currentNode = new Node(data);
	    if(isLeft){
		currentNodeParent.left = currentNode;
		return true;
	    }else{
		currentNodeParent.right = currentNode;
		return true;
	    }

	}
    }

    //simple search function that traverses the tree exactly like the insert method (might have been useful to implement a method
    //that takes care of traversing the tree.
    public String search(String data){

	Node currentNode = root;
	int compareInt = currentNode.getData().compareTo(data);

	while(currentNode!=null){
	    if(compareInt==0){
		return currentNode.data;
	    }else if(compareInt<0){
		currentNode=currentNode.right;
	    }else if(compareInt>0){
		currentNode=currentNode.left;
	    }
	}
	return null;
    }
    //makes an object of SimilarWords and uses method from there to gain an ArrayList with all similar words
    public ArrayList<String> findSimilarWords(String s){
	SimilarWords sw = new SimilarWords();

	ArrayList<String> finalWords = new ArrayList<String>();
	finalWords = sw.generateSimilarWords(s);

	return finalWords;
    }
    //uses findSimilarWords method and generates an arraylist with all similar words.
    //Searches the tree and if it finds a word stores it in another array.
    //After all similar words have been searched for, it prints the array with all words that have been
    //found and suggests them
    public void suggestSimilarWords(String s){
	double startTime = System.nanoTime();
	double timeUsed;
	ArrayList<String> allWords = new ArrayList<String>();
	allWords = findSimilarWords(s);

	ArrayList<String> suggestedWords = new ArrayList<String>();

	for(String h: allWords){
	    if(search(h)!=null){
		suggestedWords.add(h);
	    }
	}
	if(!suggestedWords.isEmpty()){
	    System.out.println("You might have spelled '" + s +"' wrong. Here are a few suggestions:");
	    for(String j : suggestedWords){
		System.out.println(j);
	    }
	}else{
	    System.out.println("There are no similar words in the dictionary");
	}

	timeUsed = System.nanoTime() - startTime;

	System.out.println("\nThe search for similar words took " + (timeUsed/1000000) + " milliseconds, and found " + suggestedWords.size() + " appropriate words.");
    }
    //traverses the tree to find the correct node, if it finds it (corapedValue==0), then it checks how many children the node has and
    //acts accordingly. This is a code that has been very strongly influenced by the remove method in the book
    public Node remove(String data, Node n){

	if(n==null){
	    return null;
	}

	int comparedValue = data.compareTo(n.getData());

	if(comparedValue<0){
	    n.left = remove(data, n.left);
	}else if(comparedValue>0){
	    n.right = remove(data, n.right);
	}else if(n.left!=null && n.right!=null){
	    n.data = findMin(n.right).getData();
	    n.right = remove(n.data, n.right);
	}else{
	    n = (n.left!=null) ? n.left : n.right;
	}
	return n;
    }
    //traverses down the whole tree, and makes sure that absolutely every node is visisted. If a node's depth is lower than the currently
    //deepest recorded depth it changed maxDepth to currDepth.
    
    public void findMaxDepth(Node n, int currDepth){
	if(n!=root){
	    if(n!=null){
		currDepth++;
		findMaxDepth(n.left, currDepth);
		findMaxDepth(n.right, currDepth);
	    }else{
		if(currDepth>=maxDepth){
		    maxDepth=currDepth;
		}
	    }
	}else{
	    findMaxDepth(n.left, currDepth);
	    findMaxDepth(n.right, currDepth);
	}
    }

    public void printMaxDepth(){
	System.out.println("Maximum depth is: " + maxDepth);
    }
    //Makes sure all places in nodesPerDepth is 0
    public void setNodesPerDepth(){
	nodesPerDepth = new int[maxDepth+1];
	for(int i=0; i<nodesPerDepth.length; i++){
	    nodesPerDepth[i]=0;
	}
    }
    //finds max depth first. Uses that to initialise nodesPerDepth, then calls traverseAllNodes which visits every single
    //node the same way findMaxDepth does, and adds one to each node's respective depth
    public void findNodesPerDepth(Node n){
	findMaxDepth(root, 0);
	setNodesPerDepth();
	traverseAllNodes(root, 0);
    }

    public void printNodesPerDepth(){
	for(int i=0; i<nodesPerDepth.length; i++){
	    System.out.println("Depth " + i + " || " + nodesPerDepth[i] + " nodes");
	}
    }
    //see findsNodesPerDepth
    public void traverseAllNodes(Node n, int currDepth){
	if(n!=root){
	    if(n!=null){
		currDepth++;
		nodesPerDepth[currDepth]++;npp
		traverseAllNodes(n.left, currDepth);
		traverseAllNodes(n.right, currDepth);
	    }
	}else{
	    traverseAllNodes(n.left, currDepth);
	    traverseAllNodes(n.right, currDepth);
	}
    }
    //does a simple mathematic calculation of what the averageDepth of the nodes is.
    //A weakness of this, and some other methods, is that they have to be called in correct order, or else some variables
    //might not have been set to their correct values. I do, however, have complete controll of the method calls myself
    //and didn't bother making any boundaries for that
    public void printAverageDepthOfNodes(){
	int nbNodes=0;
	int sum=0;

	for(int i=0; i<nodesPerDepth.length; i++){
	    nbNodes += nodesPerDepth[i];
	    sum += (nodesPerDepth[i])*(i);
	}
	averageDepthOfNodes = ((double)sum/nbNodes);
	System.out.println("Average depth of all nodes: " + averageDepthOfNodes);
    }
    
    public void printFirstAndLastWord(){
	alphabeticallyFirst = findMin(root).data;
	alphabeticallyLast = findMax(root).data;
	System.out.println("\nThe alphabetically first word is: " + alphabeticallyFirst);
	System.out.println("The alphabetically last words is: " + alphabeticallyLast);
    }
    
    public void printStatistics(){
	findNodesPerDepth(root);
	printNodesPerDepth();
	System.out.println("\nThe depth of the tree is: " + maxDepth);
	printAverageDepthOfNodes();
	printFirstAndLastWord();
    }
    //uses search method to find the word/not find the word, and returns println accordingly
    public void searchForWord(String s){
	System.out.println("Searching for '" + s + "'");
	String searchResult = search(s);

	if(searchResult!=null){
	    System.out.println("Found: " + searchResult + "\n");
	}else{
	    System.out.println("'" + s + "' does not exist\n");
	    suggestSimilarWords(s);
	}
    }
    /*
      public void writeSearchForWord(String s, PrintWriter pw){
      pw.println("\nSearching for '" + s + "'");
      String searchResult = search(s);

      if(searchResult!=null){
      pw.println("Found: " + searchResult + "\n");
      }else{
      pw.println("'" + s + "' does not exist\n");
      writeSuggestSimilarWords(s, pw);
      }
      }

      public void writeSuggestSimilarWords(String s, PrintWriter pw){
      double startTime = System.currentTimeMillis();
      double timeUsed;
      ArrayList<String> allWords = new ArrayList<String>();
      allWords = findSimilarWords(s);

      ArrayList<String> suggestedWords = new ArrayList<String>();

      for(String h: allWords){
      if(search(h)!=null){
      suggestedWords.add(h);
      }
      }
      if(!suggestedWords.isEmpty()){
      pw.println("You might have spelled '" + s +"' wrong. Here are a few suggestions:");
      for(String j : suggestedWords){
      pw.println(j);
      }
      }else{
      pw.println("There are no similar words in the dictionary");
      }

      timeUsed = System.currentTimeMillis() - startTime;

      pw.println("\nThe search for similar words took " + (timeUsed) + " milliseconds, and found " + suggestedWords.size() + " appropriate words.");
      }
    */

    /*
      public void writeStatistics() throws Exception{
      PrintWriter pw = new PrintWriter("utskrift.txt");
      for(int i=0; i<nodesPerDepth.length; i++){
      pw.println("Depth " + i + " || " + nodesPerDepth[i] + " nodes");
      }
      pw.println("The depth of the tree is: " + maxDepth);
      pw.println("Average depth of nodes is: " + averageDepthOfNodes);
      pw.println("\nThe alphabetically first word is: " + alphabeticallyFirst);
      pw.println("The alphabetically last word is: " + alphabeticallyLast);
      pw.println();
      writeSearchForWord("achiev", pw);
      pw.println();
      writeSearchForWord("achiese", pw);
      pw.println();
      writeSearchForWord("achievee", pw);
      pw.println();
      writeSearchForWord("ahcieve", pw);
      pw.close();
      }
    */

    public Node findMin(Node n){
	while(n.left!=null){
	    n = n.left;
	}
	return n;
    }

    public Node findMax(Node n){
	while(n.right!=null){
	    n = n.right;
	}
	return n;
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

	String getData(){
	    return data;
	}

	Node getLeft(){
	    return left;
	}
	Node getRight(){
	    return right;
	}
    }


}
