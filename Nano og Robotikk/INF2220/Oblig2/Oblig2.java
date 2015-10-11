public class Oblig2{

    public static void main(String[] args) throws Exception{
	Graph g = new Graph();

	if(args.length==1){
	    g.addAllTasks(args[0]);
	}else{
	    System.out.println(" ERROR: Wrong no of arguments. Terminating program");
	}

	g.printAllTasks();
    }

}
