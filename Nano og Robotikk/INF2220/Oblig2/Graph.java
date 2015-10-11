import java.util.*;
import java.io.*;

public class Graph{
    static Task[] tasksArray;
    int noOfTasks;


    public void addAllTasks(String fileName) throws Exception{
	Scanner in;
	File file = new File(fileName);
	//makes sure to exit program if the file does not exist
	if(!file.exists()){
	    System.out.println("ERROR: The file does not exists. Terminating program");
	    System.exit(0);
	}
	//initializes the scanner and reads first line and sets this to be noOfTasks
	in = new Scanner(file);
	noOfTasks = Integer.parseInt(in.nextLine());
	tasksArray = new Task[noOfTasks];
	

	//moves the cursor down to first task
	in.nextLine();

	//cycles through all the tasks and adds them to tasksArray
	String read;
	for(int i=0; i<tasksArray.length; i++){
	    read = in.nextLine();
	    String[] taskInfo = read.split("[\\s,;\\n\\t]+");
	    int[] edges = new int[taskInfo.length - 5];

	    for(int j=0; j<taskInfo.length-5; j++){
		edges[j] = Integer.parseInt(taskInfo[4+j]);
	    }

	    tasksArray[i] = new Task(Integer.parseInt(taskInfo[0]), taskInfo[1], Integer.parseInt(taskInfo[2]), Integer.parseInt(taskInfo[3]), edges);
	    System.out.println("\n Adding new task, with info:");
	    for(int j=0; j<taskInfo.length; j++){
		System.out.print(" " + taskInfo[j]);
	    }
	}
    }


    public void printAllTasks(){

	for(int i=0; i<tasksArray.length; i++){
	    System.out.println("\n Task number " + i + ": ");
	    tasksArray[i].printTaskInfo();
	}

    }



    class Task {
	int id , time , staff;
	String name;
	int earliestStart, latestStart;
	int cntPredecessors;
	int[] edgesNo;

	public Task(int id, String name, int time, int staff, int[] edgesNo){
	    this.id = id;
	    this.name = name;
	    this.time = time;
	    this.staff = staff;
	    this.edgesNo = edgesNo;
	}

	public void printTaskInfo(){
	    System.out.println(" Name: " + name);
	    System.out.println(" Time: " + time);
	    System.out.println(" Staff: " + staff);

	    System.out.println(" Dependencies: ");
	    for(int i=0; i<edgesNo.length; i++){
		System.out.println(" " + edgesNo[i]);
	    }
	}
	
	public void printID(){
	    System.out.println(id);
	}
    }
}
