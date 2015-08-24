import java.io.*;
import java.util.*;

public class SudokuBeholder{

    ArrayList<String[]> losninger = new ArrayList();
    private int antallLosninger;
    PrintWriter writer;
	
    SudokuBeholder(String filnavn){
        antallLosninger=0;
        try{
            writer = new PrintWriter(filnavn);
        }catch (Exception e){
            System.out.println("Noe har gaatt feil");
        }
    }

    public void settInn(String[] k){
        losninger.add(k);
        antallLosninger++;
    }

    public void taUt(int i){
        losninger.get(i);
    }    

    public void skrivTilFil(){
	for(int i=0; i<losninger.size(); i++){
	    if(i>2499){
		break;
	    }
	    writer.print(i + ": ");
	    for(int j=0; j<losninger.get(i).length; j++){
		String[] tmp = losninger.get(i);		
	        writer.print(tmp[j]);
		writer.print("//");
	    }
	    writer.println();
	}
	writer.close();
    }

    public int antallLosninger(){
        return antallLosninger;
    }


}
