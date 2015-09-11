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

    public boolean insert(String data){
        Node currentNode;
        Node currentNodeParent;
        boolean isLeft=true;

        if(root==null){
            root = new Node(data);
        }else{
            currentNodeParent = root;
            currentNode = root;
            while(currentNode!=null){

                int compareInt = currentNode.getData().compareTo(data);

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
            currentNode = new Node(data);
            if(isLeft){
                currentNodeParent.left = currentNode;
                return true;
            }else{
                currentNodeParent.right = currentNode;
                return true;
            }

        }
        return false;
    }


    public String search(String data){

        Node currentNode = root;

        while(currentNode!=null){
            if(currentNode.getData().compareTo(data)==0){
                return currentNode.data;
            }else if(currentNode.getData().compareTo(data)<0){
                currentNode=currentNode.right;
            }else if(currentNode.getData().compareTo(data)>0){
                currentNode=currentNode.left;
            }
        }
        return null;
    }

    public ArrayList<String> findSimilarWords(String s){
        SimilarWords sw = new SimilarWords();

        ArrayList<String> finalWords = new ArrayList<String>();
        finalWords = sw.generateSimilarWords(s);

        return finalWords;
    }

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

    public Node remove(String data, Node n){

        if(n==null)
            return null;

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

    public void setNodesPerDepth(){
        nodesPerDepth = new int[maxDepth+1];
        for(int i=0; i<nodesPerDepth.length; i++){
            nodesPerDepth[i]=0;
        }
    }

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

    public void traverseAllNodes(Node n, int currDepth){
        if(n!=root){
            if(n!=null){
                currDepth++;
                nodesPerDepth[currDepth]++;
                traverseAllNodes(n.left, currDepth);
                traverseAllNodes(n.right, currDepth);
            }
        }else{
            traverseAllNodes(n.left, currDepth);
            traverseAllNodes(n.right, currDepth);
        }
    }

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
