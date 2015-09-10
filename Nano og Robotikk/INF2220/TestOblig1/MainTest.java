public class MainTest{


    public static void main(String[] args) {
        BinaryTreeTest bt = new BinaryTreeTest();

        bt.insert("d");
        bt.insert("b");
        bt.insert("i");
        bt.insert("l");
        bt.insert("h");
        bt.insert("c");
        bt.insert("a");

        bt.findNodesPerDepth(bt.root);


    }



}
