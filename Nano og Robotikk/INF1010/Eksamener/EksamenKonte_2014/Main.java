public class Main{


    public static void main(String[] args) {
	System.out.println("Oppretter beholder for frukt");
	Beholder<Frukt> bFrukt = new Beholder<Frukt>();
	System.out.println("Beholder opprettet");
	bFrukt.settInn(new Banan());
	bFrukt.settInn(new Kiwi());
	bFrukt.settInn(new Kiwi());
	bFrukt.settInn(new Eple());
	bFrukt.settInn(new Eple());


	System.out.println("Oppretter beholder for personer/studenter");
	Beholder<Person> bPerson = new Beholder<Person>();

	bPerson.settInn(new Person("PD"));
	bPerson.settInn(new Person("Maria"));
	bPerson.settInn(new Student("Andreas", "1234"));
	bPerson.settInn(new Student("Mikkel", "1234"));
	bPerson.settInn(new Student("Erik", "4321"));
    }






}
