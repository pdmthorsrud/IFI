public void depthFirst(Task t){
        //a recursive method that uses DFS to 'traverse' my whole graph. If the method manages to visit
        //a task that is already ongoing (it has been visited before, but is not done going through it's neighbour tasks
        //a loop has been found and the project is not realizable, and the system exits.
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
