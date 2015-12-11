public class BinarySearchTree{


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



}
