public class ElBil extends Bil{

    int batterikW;

    ElBil(String navn, String bilNr, int batteri){
	super(navn, bilNr);
	batterikW = batteri;
    }

    public void settBatterikW(int i){
	batterikW = i;
    }

    public void printElBil(){
	System.out.println("Batteri.kW: " + batterikW);
    }
}
