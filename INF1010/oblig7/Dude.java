import java.util.*;
import java.io.*;


// To do;
// ikke beskjed for opprettet lege
// Ikke catchetubrukt nr og lege i resept
// catche file not found
//
//

public class Dude{
    SortertEnkelListe<Lege, Lege> legeListe = new SortertEnkelListe<Lege, Lege>();
    EldsteForstReseptListe reseptListe = new EldsteForstReseptListe();
    YngsteForstReseptListe yngsteReseptListe = new YngsteForstReseptListe();
    Tabell<Legemiddel> legemiddelListe = new Tabell<Legemiddel>(100);
    Tabell<Person> personListe = new Tabell<Person>(100);


    public static void main(String[] args) throws Exception{
        Dude d = new Dude();

        d.lesFil("data.txt");
        d.kjorMeny();
        d.skrivFil("data.txt");
    }

    public void kjorMeny() throws Exception{
        String innlest = "hello";
        Scanner inTast = new Scanner(System.in);

        while(true){
            meny();
            Scanner in2 = new Scanner(System.in);
            innlest = in2.nextLine().toLowerCase();
            System.out.println("\n");

            if(innlest.equals("1")){
                String s;
                System.out.println("Skriv navnet paa filen du vil lese fra:");
                s = inTast.nextLine();
                File f = new File(s);
                if(f.exists()){
                    lesFil(s);
                }else{
                    System.out.println("Denne filen finnes ikke.");
                }
            }else if(innlest.equals("2")){
                String s;
                System.out.println("Skriv navnet paa filen du vil skrive til (finnes filen fra foer vil den blir erstattet. HUSK PAA .txt BAK!):");
                s = inTast.nextLine();
                skrivFil(s);
            }else if(innlest.equals("3")){
                printAlle();
            }else if(innlest.equals("4")){
                //String navn, String form, String type, String pris, String mengde, String virkestoff, String styrke
                String s;
                System.out.println("Skriv navnet paa legemidlet:");
                String navn = inTast.nextLine().toLowerCase();
                String form;
                System.out.println("Pille(p) eller Mikstur(m):");
                form=inTast.nextLine().toLowerCase();
                while(!form.equals("p") && !form.equals("m")){
                    System.out.println("Ugyldig inntastning, proev igjen:");
                    form = inTast.nextLine();
                }
                String type;
                System.out.println("Type a, b eller c (a/b/c):");
                type = inTast.nextLine().toLowerCase();
                while(!type.equals("a") && !type.equals("b") && !type.equals("c")){
                    System.out.println("Ugyldig inntastning, proev igjen:");
                    type = inTast.nextLine().toLowerCase();
                }
                System.out.println("Pris:");
                int pris = tryCatch();
                System.out.println("Mengde:");
                int mengde = tryCatch();
                System.out.println("Virkestoff:");
                int virkestoff = tryCatch();
                if(!type.equals("c")){

                    System.out.println("Styrke:");
                    int styrke = tryCatch();
                    if(nyLegemiddel(navn, form, type, pris, mengde, virkestoff, styrke)){
                        System.out.println("Legemiddel opprettet, med egenskapene:");
                        System.out.println("Navn: " + navn);
                        System.out.println("Type: " + type);
                        System.out.println("Pris: " + pris);
                        System.out.println("Mengde: " + mengde);
                        System.out.println("Virkestoff: " + virkestoff);
                        System.out.println("Styrke: " + styrke);
                    }
                    else{
                        System.out.println("Legemiddel ikke opprettet");
                    }
                }else{
                    if(nyLegemiddel(navn, form, type, pris, mengde, virkestoff)){
                        System.out.println("Legemiddel opprettet");
                        System.out.println("Legemiddel opprettet, med egenskapene:");
                        System.out.println("Navn: " + navn);
                        System.out.println("Type: " + type);
                        System.out.println("Pris: " + pris);
                        System.out.println("Mengde: " + mengde);
                        System.out.println("Virkestoff: " + virkestoff);
                    }
                    else{
                        System.out.println("Legemiddel ikke opprettet");
                    }
                }
            }else if(innlest.equals("5")){
                String navn;
                int avtaleNr;
                System.out.println("Skriv navn paa doktor, dude");
                navn = inTast.nextLine();
                System.out.println("Skriv inn avtalenr (0 = ingen avtalenr)");
                avtaleNr = tryCatch();
                nyLege(navn, avtaleNr);
            }else if(innlest.equals("6")){
                //String navn, int persNr, String adr, int postnr
                String navn;
                String persNr;
                String adr;
                int postnr;

                System.out.println("Skriv inn navn paa person, dude");
                navn = inTast.nextLine();
                System.out.println("Skriv inn personNr paa person, dude");
                persNr = inTast.nextLine();
                System.out.println("Skriv inn adresse til person, dude");
                adr = inTast.nextLine();
                System.out.println("Skriv inn postNr til person, dude");
                postnr = tryCatch();

                nyPerson(navn, persNr, adr, postnr);
            }else if(innlest.equals("7")){
                //String farge, int persNr, String lege, int legemiddelNummer, int reit
                String farge;
                int persNr;
                String lege;
                int legemiddelNummer;
                int reit;

                System.out.println("Er resepten blaa eller hvit? b/h");
                farge = inTast.nextLine().toLowerCase();
                while(!farge.equals("b") && !farge.equals("h")){
                    System.out.println("Ikke gyldig inntastning, prov igjen:");
                    farge = inTast.nextLine();
                }
                System.out.println("Skriv inn det unike nr til duden som eier resepten:");
                persNr = tryCatch();
                while(!personExistsUnikNr(persNr)){
                    System.out.println("Denne personen finnes ikke. Prov igjen:");
                    persNr = tryCatch();
                }

                System.out.println("Skriv inn navnet paa den dudete legen som skrev ut resepten:");
                lege = inTast.nextLine();
                while(!legeExistsNavn(lege)){
                    System.out.println("Denne legen finnes ikke. Prov igjen:");
                    lege = inTast.nextLine();
                }

                System.out.println("Skriv inn nummeret til legemiddelet:");
                legemiddelNummer = tryCatch();
                while(!legemiddelExistsUnikNr(legemiddelNummer)){
                    System.out.println("Dette legemiddelet finnes ikke. Prov igjen:");
                    legemiddelNummer = tryCatch();
                }

                System.out.println("Skriv inn reiten til resepten:");
                reit = tryCatch();

                nyResept(farge, persNr, lege, legemiddelNummer, reit);
                /*nyYngsteResept(farge, persNr, lege, legemiddelNummer, reit);*/
            }else if(innlest.equals("8")){
                System.out.println("Vil du bruke persNr eller personens unike nr? (p/u)");
                String svar = inTast.nextLine().toLowerCase();
                String svar2;
                int svar2Int;
                int reseptNr;
                while(!svar.equals("p") && !svar.equals("u")){
                    System.out.println("Ikke gyldig inntastning, proev igjen:");
                    svar = inTast.nextLine();
                }
                if(svar.equals("p")){
                    System.out.println("Skriv inn personnummeret:");
                    svar2 = inTast.nextLine();
                    while(!personExistsPersNr(svar2)){
                        System.out.println("Denne personen finnes ikke. Prov igjen:");
                        svar = inTast.nextLine();
                    }

                    System.out.println("Skriv inn reseptnummeret:");
                    reseptNr = tryCatch();
                    while(!reseptExistsUnikNr(reseptNr)){
                        System.out.println("Denne resepten finnes ikke. Prov igjen:");
                        reseptNr = tryCatch();
                    }

                    brukResept(svar2, reseptNr);
                }else if(svar.equals("u")){
                    System.out.println("Skriv inn personens unike nummer:");
                    svar2Int = tryCatch();

                    while(!personExistsUnikNr(svar2Int)){
                        System.out.println("Denne personen finnes ikke. Prov igjen:");
                        svar2Int = tryCatch();
                    }


                    System.out.println("Skriv inn reseptnummeret:");
                    reseptNr = tryCatch();

                    while(!reseptExistsUnikNr(reseptNr)){
                        System.out.println("Denne resepten finnes ikke. Prov igjen:");
                        reseptNr = tryCatch();
                    }

                    brukResept(svar2Int, reseptNr);
                }
            }else if(innlest.equals("9")){
                System.out.println("Hvilken statistikk vil du skrive ut?");
                System.out.println("1. Vanedannende resepter totalt, + de som er i Oslo");
                System.out.println("2. Skriv en persons blaa resepter, yngste forst");
                System.out.println("3. En leges miksturresepter, + totalt virkestoff + totalt virkestoff piller + totalt virkestoff mikstur");
                System.out.println("4. Finne medisinsk misbruk");
                kjorSubMeny();


            }else if(innlest.equals("0")){
                System.out.println("\nProgrammet er naa avsluttet");
                break;
            }else{
                System.out.println("\nDenne kommandoen finnes ikke, vaer vennlig aa skrive inn paa nytt");
            }
        }


    }







    public void meny(){
        System.out.println("\nVelkommen til DudeSykehus, velg kommando, dude:");
        System.out.println("1. Les inn en fil, dude.");
        System.out.println("2. Opprett en fil med data, dude.");
        System.out.println("3. Print all info, dude.");
        System.out.println("4. Opprett et legemiddel, dude.");
        System.out.println("5. Opprett en ny lege, dude.");
        System.out.println("6. Opprett en ny person, dude.");
        System.out.println("7. Opprett en ny resept, dude.");
        System.out.println("8. Hent ut et legemiddel fra resept, dude.");
        System.out.println("9. Print ut statistikk, dude.");
        System.out.println("0. Avslutte programmet, dude.");
    }

    public void lesFil(String filnavn) throws Exception{
        System.out.println("Leser inn fil");
        File fil = new File(filnavn);
        Scanner in;
        try{
            in = new Scanner(fil);
        }catch(FileNotFoundException e){
            e.getMessage();
            return;
        }
        String innlest;

        innlest = in.nextLine();

        while(true){
            innlest = in.nextLine();
            if(innlest.length()==0){
                break;
            }
            String[] person = innlest.split(", ");
            nyPerson(person[1], person[2], person[3], Integer.parseInt(person[4]));
        }

        innlest = in.nextLine();

        while(true){
            innlest = in.nextLine();
            if(innlest.length()==0){
                break;
            }
            String[] legemiddel = innlest.split(", ");
            if(legemiddel[3].equals("c")){
                nyLegemiddel(legemiddel[1], legemiddel[2], legemiddel[3], Integer.parseInt(legemiddel[4]), Integer.parseInt(legemiddel[5]), Integer.parseInt(legemiddel[6]));
            }else{
                nyLegemiddel(legemiddel[1], legemiddel[2], legemiddel[3], Integer.parseInt(legemiddel[4]), Integer.parseInt(legemiddel[5]), Integer.parseInt(legemiddel[6]), Integer.parseInt(legemiddel[7]));
            }
        }

        innlest = in.nextLine();

        while(true){
            innlest = in.nextLine();
            if(innlest.length()==0){
                break;
            }
            String[] leger = innlest.split(", ");
            nyLege(leger[0], Integer.parseInt(leger[1]));
        }

        innlest = in.nextLine();

        while(true){
            innlest = in.nextLine();
            if(innlest.length()==0){
                break;
            }
            String[] resepter = innlest.split(", ");
            nyResept(resepter[1], Integer.parseInt(resepter[2]), resepter[3], Integer.parseInt(resepter[4]), Integer.parseInt(resepter[5]));
            /*nyYngsteResept(resepter[1], Integer.parseInt(resepter[2]), resepter[3], Integer.parseInt(resepter[4]), Integer.parseInt(resepter[5]));*/
        }
        System.out.println("Ferdig med innlesning");
    }

    public void skrivFil(String filnavn) throws Exception{

        PrintWriter pw = new PrintWriter(filnavn);
        pw.println("# Personer (nr, navn, fnr, adresse, postnr)");
        for(Person p: personListe){
            if(p!=null){
                p.skrivPerson(pw);
            }
        }

        pw.println("\n# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])");
        for(Legemiddel l: legemiddelListe){
            if(l!=null){
                l.skrivLegemiddel(pw);
            }
        }

        pw.println("\n# Leger (navn, avtalenr / 0 hvis ingen avtale)");
        for(Lege l: legeListe){
            l.skrivLege(pw);
        }

        pw.println("\n# Resepter (nr, hvit/blaa, persNummer, legeNavn, legemiddelNummer, reit)");
        for(Resept r: reseptListe){
            r.skrivResept(pw);
        }

        pw.println("\n# Slutt");
        pw.close();

	System.out.println("Filen har blitt opprettet.");
        //skriver fil med filnavn
    }

    public void printAlle(){
        System.out.println("Leger:");
        legeListe.printUt();
        System.out.println("\nResepter:");
        reseptListe.printUt();
        System.out.println("\nPersoner:");
        personListe.printUt();
        System.out.println("\nLegemiddler:");
        legemiddelListe.printUt();
        //printer alle personer, leger, legemidler og resepter
    }
    public boolean nyLegemiddel(String navn, String form, String type, int pris, int mengde, int virkestoff, int styrke){
        Legemiddel l;
        if(type.equals("a")){
            if(form.equals("pille")){
                l = new AP(navn, pris, mengde, virkestoff, styrke);
            }
            else{
                l = new AM(navn, pris, mengde, virkestoff, styrke);
            }
        }
        else{
            if(form.equals("pille")){
                l = new BP(navn, pris, mengde, virkestoff, styrke);
            }
            else{
                l = new BM(navn, pris, mengde, virkestoff, styrke);
            }
        }
        return legemiddelListe.settInnIndeks(l, l.nummer());
        //oppretter nytt legemiddel a eller b
    }
    public boolean nyLegemiddel(String navn, String form, String type, int pris, int mengde, int virkestoff){
        Legemiddel l;
        if(form.equals("pille")){
            l = new CP(navn, pris, mengde, virkestoff);
        }
        else{
            l = new CM(navn, pris, mengde, virkestoff);
        }
        return legemiddelListe.settInnIndeks(l, l.nummer());
        //oppretter nytt legemiddel c
    }
    public boolean nyLege(String a, int b){
        Lege l = new Lege(a, b);
        return legeListe.settInn(l);

        //opretter ny lege
    }
    public boolean nyPerson(String navn, String persNr, String adr, int postnr){
        Person p = new Person(navn, persNr, adr, postnr);
        return personListe.settInnIndeks(p, p.nummer());

        //oppretter ny person
    }
    public boolean nyResept(String farge, int persNr, String lege, int legemiddelNummer, int reit){
        boolean fargen = true;
        if(farge.equals("h")){
            fargen = false;
        }
        Lege l = legeListe.finnElement(lege);
        if(l == null){
            System.out.println("Legen du proever aa legge til resepten finnes ikke");
            return false;
        }
        Legemiddel lm = legemiddelListe.finnIndeks(legemiddelNummer);
        if(lm == null){
            System.out.println("Legemiddelet du proever aa finne finnes ikke");
            return false;
        }
        Person p = personListe.finnIndeks(persNr);
        if(p == null){
            System.out.println("Personen du proever aa finne finnes ikke");
            return false;
        }
        Resept r = new Resept(lm, l, p, reit, fargen);
        System.out.println("Resepten er blitt opprettet, med egenskapene:");
        System.out.println("Legemiddel: " + lm);
        System.out.println("Lege: " + l);
        System.out.println("Person: " + p);
        System.out.println("Reit: " + r.reit());
        boolean eldste = reseptListe.settInn(r);
        boolean yngste = yngsteReseptListe.settInn(r);
        if(eldste && yngste){
            return true;
        }else{
            return false;
        }
    }

    public Legemiddel brukResept(String persNr, int reseptNr){
        Resept r = reseptListe.finnResept(reseptNr);
        if(r.riktigResept(reseptNr, persNr, -1)){
            if(r.bruk()){
		System.out.println("\n");
                System.out.println("Pris: " + r.getPris());
                System.out.println("LegeNavn: " + r.getLege().toString());
                System.out.println("PersonNavn" + r.getPerson().toString());
                r.getLegemiddel().printInfo();
                return r.getLegemiddel();
            }else{
                System.out.println("Resepten er ikke gyldig");
            }
        }else{
            System.out.println("Denne respten finnes ikke/personen eier ikke denne respten.");
        }
        return null;
    }

    public Legemiddel brukResept(int unikNr, int reseptNr){
        Resept r = reseptListe.finnResept(reseptNr);
        if(r.riktigResept(reseptNr, "-1", unikNr)){
            if(r.bruk()){
                System.out.println(r.getPris());
                System.out.println(r.getLege().toString());
                System.out.println(r.getPerson().toString());
                r.getLegemiddel().printInfo();
                return r.getLegemiddel();
            }else{
                System.out.println("Resepten er ikke gyldig");
            }
        }else{
            System.out.println("Denne resepten finnes ikke/personen eier ikke denne respten.");
        }
        return null;
    }

    public int tryCatch(){
        Scanner in = new Scanner(System.in);
        try{
            String s = in.nextLine();
            int b = Integer.parseInt(s);
            return b;
        }catch(Exception e){
            System.out.println("Dude... detta er ikke et tall, dude. Proev igjen:");
            tryCatch();
        }
        return -1;
    }


    public boolean personExistsUnikNr(int nr){
        for(Person p: personListe){
            if(p!=null){
                if(p.sjekkUnikNr(nr)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean personExistsPersNr(String persNr){
        for(Person p: personListe){
            if(p!=null){
                if(p.sjekkPersNr(persNr)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean legeExistsNavn(String navn){
        for(Lege l: legeListe){
            if(l.toString().equals(navn)){
                return true;
            }
        }
        return false;
    }

    public boolean legemiddelExistsUnikNr(int nr){
        for(Legemiddel l: legemiddelListe){
            if(l!=null){
                if(l.nummer() == nr){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean reseptExistsUnikNr(int nr){
        for(Resept r: reseptListe){
            if(r.getReseptNr()==nr){
                return true;
            }
        }
        return false;
    }

    public void kjorSubMeny(){
        Scanner inTast = new Scanner(System.in);
        String innlest;
        innlest = inTast.nextLine();
        if(innlest.equals("1")){
            printVanedannende();
        }else if(innlest.equals("2")){
            printPersonBlaaResepter();
        }else if(innlest.equals("3")){
            printLegeMikstur();
        }else if(innlest.equals("4")){
            printMisbruk();
        }else{
            System.out.println("Ugyldig inntastning. Prov igjen");
            kjorSubMeny();
        }
    }



    public void printVanedannende(){
        int tellerVanedannende=0;
        int tellerPersonerOslo=0;
        for(Resept r: reseptListe){
            if(r.getLegemiddel() instanceof TypeB){
                tellerVanedannende++;
            }
        }
        System.out.println("Det finnes totalt " + tellerVanedannende + " vanedannende legemidler.");

        for(Resept r: reseptListe){
            if(r.getPerson().getPostnummer()<1296 && r.getLegemiddel() instanceof TypeB){
                tellerPersonerOslo++;
            }
        }
        System.out.println("Det finnes totalt " + tellerPersonerOslo + " person(er) med vanedannende legemidler i Oslo");

    }



    public void printPersonBlaaResepter(){
        Scanner taInn = new Scanner(System.in);
        String innlest = "";
        String innlest2;
        int innlest2Int;

        System.out.println("Vil du finne personen ved hjelp av personNr eller personens unike nummer? (p/u)");
        innlest = taInn.nextLine().toLowerCase();
        while(!innlest.equals("p") && !innlest.equals("u")){
            System.out.println("Ikke gyldig inntastning. Prov igjen:");
            innlest = taInn.nextLine().toLowerCase();
        }
        if(innlest.equals("p")){
            System.out.println("Skriv inn personnummeret:");
            innlest2 = taInn.nextLine();
            while(!personExistsPersNr(innlest2)){
                System.out.println("Denne personen finnes ikke. Prov igjen:");
                innlest2 = taInn.nextLine();
            }
            System.out.println("\nDenne personen eier disse blaa reseptene, yngste forst:");
            for(Resept r: yngsteReseptListe){
                if(r.sjekkPersonPersNr(innlest2) && r.erBlaa()){
                    System.out.println(r);
                }
            }
        }else{
            System.out.println("Skriv inn personens unike nummer");
            innlest2Int = tryCatch();
            while(!personExistsUnikNr(innlest2Int)){
                System.out.println("Denne personen finnes ikke. Prov igjen:");
                innlest2Int = tryCatch();
            }
            System.out.println("\nDenne personen eier disse blaa reseptene, yngste forst:");
            for(Resept r: yngsteReseptListe){
                if(r.sjekkPersonUnikNr(innlest2Int) && r.erBlaa()){
                    System.out.println(r);
                }
            }
        }
    }

    public void printLegeMikstur(){
        String innlest;
        Scanner inTast = new Scanner(System.in);

        System.out.println("Skriv inn navnet paa legen:");
        innlest = inTast.nextLine();
        while(!legeExistsNavn(innlest)){
            System.out.println("Denne legen finnes ikke. Prov igjen:");
            innlest = inTast.nextLine();
        }

        int virkestoffTot=0;
        int virkestoffPille=0;
        int virkestoffMikstur=0;
        System.out.println("\nLegens utskrevne resepter med mikstur (nr, farge, persNr, legenavn, legemiddelNr, reit):");
        for(Resept r: reseptListe){
            String temp = r.getLege().toString();
            if(r.getLegemiddel() instanceof Mikstur && temp.equals(innlest)){
                Mikstur m = (Mikstur) r.getLegemiddel();
                r.printResept();
                virkestoffTot += m.getVirkestoffTot();
                virkestoffMikstur += m.getVirkestoffTot();
            }else if(r.getLegemiddel() instanceof Pille && temp.equals(innlest)){
                Pille p = (Pille) r.getLegemiddel();
                virkestoffTot += p.getVirkestoffTot();
                virkestoffPille += p.getVirkestoffTot();
            }
        }
        System.out.println("\nDenne legen har resepter med legemidler som har en samlet mengde virkestoff lik " + virkestoffTot);
        System.out.println("Denne legen har resepter med legemidler som har en samlet mengde virkestoff i piller lik " + virkestoffPille);
        System.out.println("Denne legen har resepter med legemidler som har en samlet mengde virkestoff i mikstur lik " + virkestoffMikstur);
    }

    public void printMisbruk(){
        for(Lege l: legeListe){
            int teller=0;
            for(Resept r: reseptListe){
                if(r.getLege() == l && r.getLegemiddel() instanceof TypeA){
                    teller++;
                }
            }if(teller>0){
                System.out.println(l + " har " + teller + " resept(er) med narkotiske legemidler");
            }
        }

        for(Person p: personListe){
            int teller=0;
            for(Resept r: reseptListe){
                if(r.getPerson() == p && r.getLegemiddel() instanceof TypeA && r.reit()>0){
                    teller++;
                }
            }if(teller>0){
                System.out.println(p + " har " + teller + " resept(er) med narkotiske legemidler som er gyldige");
            }
        }
    }
}
