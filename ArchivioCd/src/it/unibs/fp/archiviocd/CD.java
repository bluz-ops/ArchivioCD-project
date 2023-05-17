package it.unibs.fp.archiviocd;
import java.util.ArrayList;
import java.util.Random;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.NumeriCasuali;

/**
 * Questa classe crea l'oggetto CD, ogni CD contiene una collezione di brani
 * Sono forniti metodi per aggiungere brani ad un CD istanziato, per creare una lista di brani casuali
 * da riprodurre, metodo per la ricerca di brani all' interno di un CD
 * @author Molla Blen Zena
 *
 */
public class CD {
	//attributi
	private String titoloCD;
	private String autore;
	private ArrayList <Brano> listaBrani= new ArrayList<Brano>();
	
	
	/**
	 * costruttore
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
	
	/*
	public void aggiungiBranoAllaLista(Brano inserimento) {
		System.out.println("Funzionalita' Aggiunta Brano");
		inserimento.titolo= InputDati.leggiStringaNonVuota("Inserisci titolo:");
		listaBrani.add(inserimento);
		System.out.printf(MSG_AGGIUNTA_SUCCESSO, inserimento.getTitolo());
	} 
	*/
	

	/**
	 * metodo che ritorna 3 brani casuali da riprodurre da un CD casuale
	 * @return braniToShuffle una lista di brani casuali da riprodurre
	 */
	public ArrayList<Brano> ShuffleBrani() {
		ArrayList<Brano> braniToShuffle = new ArrayList<Brano>();
		int numBraniRandom= 3; //InputDati.leggiIntero("Quanti brani vuoi ascoltare?");
		for (int i=0; i<numBraniRandom; i++) {
			int indexBranoRandom = NumeriCasuali.estraiIntero(0, listaBrani.size());
			braniToShuffle.add(listaBrani.get(indexBranoRandom));	
		}
		return braniToShuffle;
	}
	
	/**
	 * 
	 * @param cercato
	 * @return true if brano appartiene al CD
	 */
	public boolean cercaBranoPerTitolo(String cercato) {
		for (Brano i: listaBrani) {
			if (cercato.equalsIgnoreCase(i.getTitolo())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("Titolo del CD:" + titoloCD + "\nAutore:" + autore);
		descrizione.append("\n\nLista Brani:\n");
		for(Brano i:listaBrani) {
			descrizione.append("brano " + i.getTitolo() + "\n");
			descrizione.append("durata " + i.getDurata() + " min\n");
			descrizione.append("\n");
		}
		return descrizione.toString();
	}
	
}
