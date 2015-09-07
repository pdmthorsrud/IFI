public class BinaryTree{

    private static Node root = null;

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
		if(currentNode.getData().compareTo(data)==0){
		    return false;
		}else if(currentNode.getData().compareTo(data)<0){
		    currentNodeParent = currentNode;
		    currentNode = currentNode.getRight();
		    isLeft = false;
		}else{
		    currentNodeParent = currentNode;
		    currentNode = currentNode.getLeft();
		    isLeft = true;
		}
	    }
	    currentNode = new Node(data);
	    
	}
	return false;
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
