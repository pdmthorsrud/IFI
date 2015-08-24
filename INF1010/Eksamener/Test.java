abstract class Bil{
    private String regNr;
    Bil(String s){
        if(s.length()==7){
            regNr = s;
        }else{
	    return;
	}
    }
}

abstract class Varebil extends Bil{
    Varebil(String s){
        super(s);
    }
}
class Lastebil extends Varebil{
    Lastebil(String s){
        super(s);
    }
}
abstract class Personbil extends Bil{

    Personbil(String s){
        super(s);
    }}
class Drosje extends Personbil{

    Drosje(String s){
        super(s);
    }}
class Privatbil extends Personbil{
    Privatbil(String s){
        super(s);
    }
}

public class Test{
    public static void main(String[] args) {
        new Privatbil("IN10101");
    }
}
