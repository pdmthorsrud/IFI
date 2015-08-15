public class Etappe{
    int etappeNr;
    Etappe nesteEtappe;
    Etappetid forsteEtappetid;

    Etappe(int etappeNr, Etappe nesteEtappe, Etappetid forsteEtappetid){
	this.etappeNr = etappeNr;
	this.nesteEtappe = nesteEtappe;
	this.forsteEtappetid = forsteEtappetid;
    }

    public Etappetid forsteEtappetid(){
	return forsteEtappetid;
    }
}
