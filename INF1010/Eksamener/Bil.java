abstract class Bil{
    private String regNr;
    
    Bil(String s){
	regNr = s;
    }
}

abstract class Varebil extends Bil{
}
class Lastebil extends Varebil{
}
abstract class Personbil extends Bil{
}
class Drosje extends Personbil{
}
class Privatbil extends Personbil{
}

public class Test{
    public static void main(String[] args) {
	new Privatbil("IN10101");
    }
}
