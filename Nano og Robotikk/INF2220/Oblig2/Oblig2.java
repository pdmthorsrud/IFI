import java.util.*;

public class Oblig2{

    public static void main(String[] args) throws Exception{
        Graph g = new Graph();

	if(args.length==1){
	    g.runEverything(args[0]);
	}else{
	    System.out.println("Wrong number of arguments. Terminating program");
	}

    }

}
