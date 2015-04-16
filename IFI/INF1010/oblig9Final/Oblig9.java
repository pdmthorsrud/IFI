public class Oblig9{

    public static void main(String[] args) throws Exception {

	Brett b = new Brett();

	b.lesFil(args[0]);
	b.printRuteRadNr(0, 0);
	b.printBrett();
	b.startLosning();
	b.printBrett();
    }
}
