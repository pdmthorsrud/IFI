import java.util.*;

public class BinaryTreeTest{

    Node root = null;
    ArrayList<Integer> treeDepths = new ArrayList<Integer>();
    int maxDepth=0;
    int[] nodesPerDepth;

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
        printNodesPerDepth();
    }

    public void printNodesPerDepth(){
        for(int i=0; i<nodesPerDepth.length; i++){
            System.out.println("Depth " + i + " || " + nodesPerDepth[i]);
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


    public void printAllDepths(){
        for(int i: treeDepths){
            System.out.println(i);
        }
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
