class Katt{

    private String navn;
    private int vekt = 5000;
    private int antMus;
    private boolean syk=false;

    public Katt(String navn){
        this.navn = navn;
    }

    public Katt(String navn, int vekt, boolean syk){
        this.navn = navn;
        this.vekt = vekt;
        this.syk = syk;
    }

    //gaaPaaJaktI er en metode som sjekker ut alle kondisjonene som er i forhold til bolet, og gjoer saa det katten skal gjoere naar de forskjellige 
    //kondisjonene er til stede
    public Mus gaaPaaJaktI(Bol<Mus> musebolet){
        if(!musebolet.tomt()){
            Mus mm = musebolet.taUt();
            if(mm.lever()){
                if(antMus<2){
                    if(mm.syk()){
                        antMus++;
                        vekt += Integer.parseInt(mm.vekt());
                        syk = true;
                        return null;
                    }else{
                        antMus++;
                        vekt += Integer.parseInt(mm.vekt());
                    }
                }else{
                    mm.bliBitt();
                    return mm;
                }
            }else{
                return mm;
            }
        }
	return null;
    }

    public String navn(){
        return navn;
    }

    public int vekt(){
        return vekt;
    }

    public int antMus(){
	return antMus;
    }

    public boolean syk(){
	return syk;
    }

}
