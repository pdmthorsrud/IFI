/*
 *@author Per Daniel Thorsrud
 *
 *@version 1.0
 *@since 2015
 */
public interface TilUtlaan{
    /**
     *settUtlaaner tar imot setter utlaaner variabelen i klassen til aa vaere
     *
     *@param utlaaner er en String variabel som angir navnet til utlaaneren.
     *@return returnerer en boolean som er true hvis utlaaner blir satt.
     */
    public boolean settUtlaaner(String utlaaner);

    /**
     *leverTilbake setter utlaaner-variabelen til aa vaere null.
     *
     *@return returnerer Stringen som originalt var i utlaaner.
     */
    public String leverTilbake();

}
