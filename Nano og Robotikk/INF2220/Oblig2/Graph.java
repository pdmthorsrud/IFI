import java.util.*;
import java.io.*;

public class Graph{
    static Task[] tasksArray;
    static Task[] tasksWithNoDependencies;
    static ArrayList<Task> loopContainer = new ArrayList<>();
    int noOfTasks;


    public void runEverything(String fileName) throws Exception{
        addAllTasks(fileName);

        System.out.println("\n Checking possibility of the project");
        searchLoop(tasksArray[1]);
        System.out.println("\n No loops were found. The project is possible. FULL SPEED AHEAD CAP'N!");
	//finds the earliestStartTime for every single node
	/*
        for(int i=1; i<tasksArray.length; i++){
            tasksArray[i].findEarliestStart(tasksArray[i], tasksArray[i], 0);
	    }*/

	for(Task t: findIndependentTasks()){
	    findEarliestStartAlt(t, 0);
	}

        for(Task t: findTasksThatNoOneDependsOn()){
            findLatestStartTimes(t, findTotalTime());
        }

        printAllTasks();

        runProjectSimulation();
    }

    public void runProjectSimulation(){
        int i = 0;
        int currStaff=0;
        HashMap<Integer, ArrayList<Task>> startTimes = makeHashMapWithStartTimes();
        HashMap<Integer, ArrayList<Task>> finishingTimes = makeHashMapWithFinishingTimes();

        while(i<findTotalTime()+1){
            if(startTimes.containsKey(i) || finishingTimes.containsKey(i)){
                System.out.println("\n Time: " + i);
                if(startTimes.containsKey(i)){
                    for(Task t: startTimes.get(i)){
                        System.out.println(" Starting: " + t.getID());
                        currStaff+=t.getStaff();
                    }
                }else{
                    System.out.println(" No new tasks have been started.");
                }
                if(finishingTimes.containsKey(i)){
                    for(Task t: finishingTimes.get(i)){
                        System.out.println(" Finished: " + t.getID());
                        currStaff-=t.getStaff();
                    }
                }else{
                    System.out.println(" No new tasks have been finished.");
                }
                System.out.println(" Current staff: " + currStaff);
            }
            i++;
        }

        System.out.println("\n WE'RE FINISHED CAP'N");
        System.out.println("\n**** Shortest possible project execution is " + findTotalTime() + " ****");
    }

    public HashMap makeHashMapWithStartTimes(){
        HashMap<Integer, ArrayList<Task>> tmpStartTimes = new HashMap<>();
        int startTime;

        for(int i=1; i<tasksArray.length; i++){
            startTime = tasksArray[i].getEarliestStart();
            if(!tmpStartTimes.containsKey(startTime)){
                tmpStartTimes.put(startTime, new ArrayList<>());
                tmpStartTimes.get(startTime).add(tasksArray[i]);
            }else{
                tmpStartTimes.get(startTime).add(tasksArray[i]);
            }
        }
        return tmpStartTimes;
    }

    public HashMap makeHashMapWithFinishingTimes(){
        HashMap<Integer, ArrayList<Task>> tmpFinishingTimes = new HashMap<>();
        int startTime;
        int finishingTime;

        for(int i=1; i<tasksArray.length; i++){
            startTime = tasksArray[i].getEarliestStart();
            finishingTime = startTime + tasksArray[i].getTime();

            if(!tmpFinishingTimes.containsKey(finishingTime)){
                tmpFinishingTimes.put(finishingTime, new ArrayList<>());
                tmpFinishingTimes.get(finishingTime).add(tasksArray[i]);
            }else{
                tmpFinishingTimes.get(finishingTime).add(tasksArray[i]);
            }
        }
        return tmpFinishingTimes;
    }

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
            tasksArray[i] = new Task(Integer.parseInt(taskInfo[0]), taskInfo[1], Integer.parseInt(taskInfo[2]), Integer.parseInt(taskInfo[3]), edges);
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
        System.out.println("\n-----------------------------------------------------------\n");
        System.out.println(" Minimum project realization time: " + findTotalTime());
    }

    public int findTotalTime(){
        Task t = findLastTask();
        int totalTime = t.getTime() + t.getEarliestStart();
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

    public ArrayList<Task> findTasksThatNoOneDependsOn(){
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
        t.setSlack(latestStart-t.getEarliestStart());
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

    public ArrayList<Task> findIndependentTasks(){
        ArrayList<Task> tmp = new ArrayList<>(); 
	for(int i=1; i<tasksArray.length; i++){
	    if(tasksArray[i].getDependentOn().length==0){
		tmp.add(tasksArray[i]);
	    }
	}
	return tmp;
    }



    public void findEarliestStartAlt(Task t, int totalTime){
	if(totalTime>t.getEarliestStart()){
	    t.setEarliestStart(totalTime);
	}
	totalTime += t.getTime();

	for(int i: t.getTasksThatDependsOnThisTask()){
	    findEarliestStartAlt(tasksArray[i], totalTime);
	}
    }


    class Task {
        int id , time , staff;
        String name;
        boolean seen, ongoing, done;
        int earliestStart, latestStart, slack;
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

        public int getStaff(){
            return staff;
        }

        public int getID(){
            return id;
        }

        public void setLatestStart(int time){
            this.latestStart = time;
        }

	public void setEarliestStart(int time){
	    this.earliestStart = time;
	}

        public void setSlack(int slack){
            this.slack = slack;
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
            System.out.println(" Slack: " + slack);

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
        //to see if it is bigger than the totaltime of another route of tasks that the startTask is dependent on. Has a complexity of V^2
	/*        public void findEarliestStart(Task t, Task startTask, int totalTime){
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
	    }*/
    }
}
