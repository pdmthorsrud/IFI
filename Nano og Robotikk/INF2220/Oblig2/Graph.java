import java.util.*;
import java.io.*;

public class Graph{
    static Task[] tasksArray;
    static Task[] tasksWithNoDependencies;
    static ArrayList<Task> loopContainer = new ArrayList<>();
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
	tasksArray = new Task[noOfTasks+1];

	//moves the cursor down to first task
	in.nextLine();

	//cycles through all the tasks and adds them to tasksArray
	String read;
	for(int i=1; i<tasksArray.length; i++){
	    read = in.nextLine();
	    String[] taskInfo = read.split("[\\s,;\\n\\t]+");
	    int[] edges = new int[taskInfo.length - 5];
	    //puts all the other tasks the task is dependent on in an array to be sent as a parameter when creating a task
	    for(int j=0; j<taskInfo.length-5; j++){
		edges[j] = Integer.parseInt(taskInfo[4+j]);
	    }
	    //creates a new task with a task ID corresponding to its place in the array (ID no. 1 to index 1, etc.)
	    //also prints what info has been sent as parameters to the Task, just to make sure everything is as it should be
	    tasksArray[i] = new Task(Integer.parseInt(taskInfo[0]), taskInfo[1], Integer.parseInt(taskInfo[2]), Integer.parseInt(taskInfo[3]), edges);
	    System.out.println("\n Adding new task, with info:");
	    for(int j=0; j<taskInfo.length; j++){
		System.out.print(" " + taskInfo[j]);
	    }
	}

	//cycles through all the tasks again, and makes sure all links between who's dependent on who are added
	for(int i=1; i<tasksArray.length; i++){
	    tasksArray[i].addAllDependencies();
	}
    }

    public Task getTask(int i){
	return tasksArray[i];
    }

    public Task[] getTasksArray(){
	return tasksArray;
    }


    public void printAllTasks(){
	for(int i=1; i<tasksArray.length; i++){
	    tasksArray[i].printTaskInfo();
	}
    }

    public int findTotalTime(){
	Task t = findLastTask();
	int totalTime = t.getTime() + t.getEarliestStart();
	System.out.println(" Totaltime: " + totalTime);
	return totalTime;
    }

    public Task findLastTask(){
	Task latestTask = tasksArray[1];
	for(int i=2; i<tasksArray.length; i++){
	    if(latestTask.getEarliestStart()<tasksArray[i].getEarliestStart()){
		latestTask = tasksArray[i];
	    }
	}
	return latestTask;
    }
    
    public ArrayList<Task> findLastTasks(){
	ArrayList<Task> lastTasks = new ArrayList<>();
	for(int i=1; i<tasksArray.length; i++){
	    if(tasksArray[i].getTasksThatDependsOnThisTask().size()==0){
		lastTasks.add(tasksArray[i]);
	    }
	}
	return lastTasks;
    }

    public void findLatestStartTimes(Task t, int time){
	int latestStart = time-t.getTime();
	int[] tmp = t.getDependentOn();
	t.setLatestStart(latestStart);
	for(int i = 0; i<tmp.length; i++){
	    findLatestStartTimes(tasksArray[tmp[i]], latestStart);
	}
    }
    
    public void searchLoop(Task t){
	//a recursive method that uses DFS to 'traverse' my whole graph. If the method manages to visit
	//a task that is already ongoing (it has been visited before, but is not done going through it's neighbour tasks
	//a loop has been found and the project is not realizable, and the system exits.
	loopContainer.add(t);
	if(t.ongoing){
	    System.out.println("\n A loop has been found! The project is not possible. Printing looped tasks' info, then terminating program");
	    for(int i=loopContainer.indexOf(t); i<loopContainer.size(); i++){
		loopContainer.get(i).printLoopInfo();
	    }
	    System.out.println();
	    System.exit(0);
	}else if(!t.seen()){
	    t.setOngoing(true);
	    ArrayList<Integer> tmp = t.getTasksThatDependsOnThisTask();
	    for(Integer k: tmp){
		searchLoop(tasksArray[k]);
	    }
	    t.setSeen(true);
	    t.setDone(true);
	    t.setOngoing(false);
	    loopContainer.remove(t);
	}
    }


    class Task {
	int id , time , staff;
	String name;
	boolean seen, ongoing, done;
	int earliestStart, latestStart;
	int cntPredecessors;
	int[] dependentOn;
	ArrayList<Integer> tasksThatDependsOnThisTask = new ArrayList<Integer>();

	public Task(int id, String name, int time, int staff, int[] edgesNo){
	    this.id = id;
	    this.name = name;
	    this.time = time;
	    this.staff = staff;
	    this.dependentOn = edgesNo;
	    this.seen = false;
	    this.ongoing = false;
	    this.done = false;
	    this.earliestStart = 0;
	}

	public void addAllDependencies(){
	    for(int i=0; i<dependentOn.length; i++){
		tasksArray[dependentOn[i]].addDependentTask(this.id);
	    }
	}

	public ArrayList<Integer> getTasksThatDependsOnThisTask(){
	    return tasksThatDependsOnThisTask;
	}

	public int getEarliestStart(){
	    return earliestStart;
	}

	public int getLatestStart(){
	    return latestStart;
	}

	public void setLatestStart(int time){
	    latestStart = time;
	}

	public boolean done(){
	    return done;
	}

	public boolean seen(){
	    return seen;
	}

	public boolean ongoing(){
	    return ongoing;
	}

	public void setDone(boolean b){
	    this.done = b;
	}

	public void setOngoing(boolean b){
	    this.ongoing = b;
	}

	public void setSeen(boolean b){
	    this.seen = b;
	}

	public int[] getDependentOn(){
	    return dependentOn;
	}

	public int getTime(){
	    return time;
	}

	public String getName(){
	    return name;
	}

	public void printLoopInfo(){
	    System.out.printf("-----------------------------------\n");
	    System.out.println(" Task id: " + id);
	    System.out.println(" Name: " + name);
	}

	public void printTaskInfo(){
	    System.out.println("\n-----------------------------------------\n");
	    System.out.println(" Task id: " + id);
	    System.out.println(" Name: " + name);
	    System.out.println(" Time: " + time);
	    System.out.println(" Staff: " + staff);
	    System.out.println(" EarliestStart: " + earliestStart);
	    System.out.println(" LatestStart: " + latestStart);

	    System.out.println("\n Dependent on: ");
	    if(dependentOn.length==0){
		System.out.println(" I am a strong independent woman!");
	    }
	    for(int i=0; i<dependentOn.length; i++){
		System.out.println(" " + dependentOn[i]);
	    }

	    System.out.println("\n Tasks dependent on this task: ");
	    if(tasksThatDependsOnThisTask.size()==0){
		System.out.println(" Sigh.. noone needs me");
	    }
	    for(int i=0; i<tasksThatDependsOnThisTask.size(); i++){
		System.out.println(" " + tasksThatDependsOnThisTask.get(i));
	    }
	}

	public void printID(){
	    System.out.println(id);
	}

	public void checkTotalTime(int totalTime){
	    if(totalTime>earliestStart){
		earliestStart=totalTime;
	    }
	}

	public void addDependentTask(int no){
	    tasksThatDependsOnThisTask.add(no);
	}
	//goes through all tasks that a task is dependent on and adds it to a totaltime, this totaltime then gets checked
	//to see if it is bigger than the totaltime of another route of tasks that the startTask is dependent on.
	public void findEarliestStart(Task t, Task startTask, int totalTime){
	    int[] tmp = t.getDependentOn();
	    if(tmp.length==0){
		if(t!=startTask){
		    totalTime += t.getTime();
		    startTask.checkTotalTime(totalTime);
		}
	    }else{
		if(t!=startTask){
		    totalTime += t.getTime();
		}
		startTask.checkTotalTime(totalTime);
		for(int i=0; i<tmp.length; i++){
		    findEarliestStart(tasksArray[tmp[i]], startTask, totalTime);
		}
	    }
	}
    }
}
