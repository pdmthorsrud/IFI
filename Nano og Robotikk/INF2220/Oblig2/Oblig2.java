public class Oblig2{

    public static void main(String[] args) throws Exception{
	Graph g = new Graph();

	if(args.length==1){
	    g.addAllTasks(args[0]);
	}else{
	    System.out.println(" ERROR: Wrong no. of arguments. Terminating program");
	    System.exit(0);
	}

	for(int i=1; i<g.getTasksArray().length; i++){
	    g.getTask(i).findEarliestStart(g.getTask(i), g.getTask(i), 0);
	}
	
	g.printAllTasks();

	System.out.println("\n Checking possibility of the project");
	g.searchLoop(g.getTask(1));
	System.out.println("\n No loops were found. The project is possible. FULL SPEED AHEAD CAP'N!\n");
    }

}
