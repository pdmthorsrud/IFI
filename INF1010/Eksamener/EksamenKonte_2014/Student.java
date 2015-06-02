public class Student extends Person{

    private String studentNr;

    Student(String navn, String studentNr){
	super(navn);
	this.studentNr = studentNr;
    }

    public String id(){
	return studentNr;
    }


    public int compareTo(String s){
	if(studentNr.equals(s)){
	    return 0;
	}else{
	    return -1;
	}
    }    
}
