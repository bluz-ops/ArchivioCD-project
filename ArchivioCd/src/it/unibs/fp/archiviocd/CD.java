package it.unibs.fp.archiviocd;
import java.util.ArrayList;
import java.util.Random;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.NumeriCasuali;

/**
 * 
 * @author Molla Blen
 *
 */
public class CD {
	public static final String MSG_AGGIUNTA_SUCCESSO = "Brano %s aggiunto alla lista con successo";
	//attributi
	private String titoloCD;
	private String autore;
	private ArrayList <Brano> listaBrani= new ArrayList<Brano>();
	
	//costruttore
	/**
	 * @param titolo del CD
	 * @param autore del CD
	 * @param listaBrani contenuti nel CD
	 */
	public CD(String titoloCD, String autore, ArrayList<Brano> listaBrani) {
		this.titoloCD = titoloCD;
		this.autore = autore;
		this.listaBrani = listaBrani;
	}
	
	//getter
	public String getTitoloCD() {
		return titoloCD;
	}
	
	//metodi
	/**
	 * 
	 * @param inserimento
	 */
	public void aggiungiBranoAllaLista(Brano inserimento) {
		/*System.out.println("Funzionalita' Aggiunta Brano");
		ìinserimento.titolo= InputDati.leggiStringaNonVuota("Inserisci titolo:"); */
		listaBrani.add(inserimento);
		System.out.println(MSG_AGGIUNTA_SUCCESSO, inserimento.titolo);
	}
	/**
	 * metodo piu specializzato di branoCasuale
	 * @return braniToShuffle una lista di brani casuali da riprodurre
	 */
	public ArrayList<Brano> ShuffleBrani() {
		ArrayList<Brano> braniToShuffle = new ArrayList<Brano>();
		int numBraniRandom= InputDati.leggiIntero("Quanti brani vuoi ascoltare?");
		for (int i=0; i<=numBraniRandom; i++) {
			int indexBranoRandom = NumeriCasuali.estraiIntero(0, listaBrani.size());
			braniToShuffle.add(listaBrani.get(indexBranoRandom));	
		}
		return braniToShuffle;
	}
	/**
	 * 
	 * @param cercato
	 * @return
	 */
	public boolean cercaBranoPerTitolo(String cercato) {
		for (Brano i: listaBrani) {
			if (cercato.equalsIgnoreCase(Brano.GetTitolo)) {
				return true;
			}
			else return false;
		}
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("Titolo del CD:" + titoloCD + "Autore:" + autore);
		descrizione.append("Lista Brani:");
		for(Brano i:listaBrani) {
			descrizione.append(i.GetTitolo);
			System.out.print("\n");
		}
		return descrizione.toString();
	}
	
}
