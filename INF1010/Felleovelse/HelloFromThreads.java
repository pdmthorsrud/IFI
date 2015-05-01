public class HelloFromThreads{
    public static void main(String[] args) {

	Monitor m = new Monitor();
        int k = Integer.parseInt(args[0]);

        for(int i = 0; i<k; i++){
            HelloRunnable hello = new HelloRunnable(i, m);
            Thread traad = new Thread(hello);
	    traad.start();
        }
    }
}


class HelloRunnable implements Runnable{
    int id;
    int tries;
    Monitor monitor;
    
    HelloRunnable(int id, Monitor m){
        this.id = id;
	monitor = m;
    }
    
    public void run(){
	monitor.runOrWait(id);
    }
}

class Monitor{
    int traadSinTur = 0;

    synchronized void runOrWait(int id){
	while(id != traadSinTur){
	    try{
		System.out.println("I am waiting..." + id);
		wait();
	    }catch(InterruptedException e){
		System.out.println("No gikk feil");
	    }
	    
	}
	System.out.println("Hello world from Thread " + id);
	traadSinTur++;
	notifyAll();
    }

}
