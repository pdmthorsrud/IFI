public class Oblig9{

    public static void main(String[] args) throws Exception {
	SudokuBeholder sudBeh;
	Brett b;

	try{
	    sudBeh = new SudokuBeholder(args[1]);
	}catch(ArrayIndexOutOfBoundsException e){
	    sudBeh = null;
	}

	if(sudBeh==null){
	    b = new Brett(sudBeh, false);
	}else{
	    b = new Brett(sudBeh, true);
	}

	b.lesFil(args[0]);
	b.printRuteRadNr(0, 1);
	b.printBrett();
	b.startLosning();
	if(sudBeh!=null){
	    b.skrivTilFil();
	}
    }
}
