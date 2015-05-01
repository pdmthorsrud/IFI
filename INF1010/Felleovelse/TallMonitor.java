public class TallMonitor{

    public static void main(String[] args) {

	Monitor m = new Monitor();
	new Thread(new Up(m)).start();
	new Thread(new Down(m)).start();

	
    }
    
}


class Monitor{

    int lowNumber = Integer.MIN_VALUE/100;
    int highNumber = Integer.MAX_VALUE/100;

    synchronized boolean verify(){
	return lowNumber < highNumber;
    }
    
    public boolean insertLow(int low){
	lowNumber = low;
	return verify();
    }
    public boolean insertHigh(int high){
	highNumber = high;
	return verify();
    }
}


class Up implements Runnable{
    int number;
    Monitor monitor;
    Up(Monitor m){
	this.monitor = m;
	this.number = Integer.MIN_VALUE/100;
    }
    public void run(){
	while(monitor.insertLow(number)){
	    number++;
	}
	System.out.println("Up : " + number);
    }
}

class Down implements Runnable{
    int number;
    Monitor monitor;
    Down(Monitor m){
	this.monitor = m;
	this.number = Integer.MAX_VALUE/100;
    }
    public void run(){
	while(monitor.insertHigh(number)){
	    number--;
	}
	System.out.println("Down : " + number);
    }
}
