package it.unibs.fp.archiviocd;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
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
	 * costruttori
	 * @param titolo del CD
	 * @param autore del CD
	 * @param listaBrani contenuti nel CD
	 */
	public CD(String titoloCD, String autore, ArrayList<Brano> listaBrani) {
		this.titoloCD = titoloCD;
		this.autore = autore;
		this.listaBrani = listaBrani;
	}
	
	public CD(String titoloCD, String autore) {
		this.titoloCD = titoloCD;
		this.autore = autore;
	}

	//getter
	public String getTitoloCD() {
		return titoloCD;
	}
	public String getAutore() {
		return autore;
	}

	public ArrayList<Brano> getListaBrani() {
		return listaBrani;
	}
	
	public void setListaBrani(ArrayList<Brano> listaBrani) {
		this.listaBrani = listaBrani;
	}
	//metodi
	
	/**
	 * 
	 * @param inserimento
	 */
	
	public void aggiungiBrano(Brano inserimento) {
		//System.out.println("Funzionalita' Aggiunta Brano");
		// inserimento.getTitolo() = InputDati.leggiStringaNonVuota("Inserisci titolo:");
		listaBrani.add(inserimento);
		// System.out.printf(MSG_AGGIUNTA_SUCCESSO, inserimento.getTitolo());
	} 


	/**
	 * metodo che ritorna 3 brani casuali da riprodurre da un CD casuale
	 * viene richiamato da un altro metodo in ArchivioCD
	 * @return braniToShuffle una lista di brani casuali da riprodurre
	 */
	public Set<Brano> ShuffleBrani() {
		Set<Brano> braniToShuffle =new HashSet<Brano>(); //evita ripetizioni
		int numBraniRandom= 3; //InputDati.leggiIntero("Quanti brani vuoi ascoltare?");
		for (int i=0; i<numBraniRandom; i++) {
			int indexBranoRandom = NumeriCasuali.estraiIntero(0, listaBrani.size());
			braniToShuffle.add(listaBrani.get(indexBranoRandom));	
		}
		return braniToShuffle;
	}
	
	public Brano branoCasuale() {
		int indexBranoRandom = NumeriCasuali.estraiIntero(0, listaBrani.size());
		return listaBrani.get(indexBranoRandom);
	}
	/**
	 * 
	 * @param cercato
	 * @return true if brano appartiene alla collezione
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
	 * stringa descrittiva
	 */
	@Override
	public String toString() {
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("Titolo: " + getTitoloCD() + ", Autore: " + getAutore());
		descrizione.append(", Lista dei brani: ");
		if (listaBrani.size()>0) {
		for(Brano i: listaBrani) {
			descrizione.append("" + i.getTitolo() + " ");
			descrizione.append("[0" + i.getDuratam() + ":"+ i.getDuratas()+ "] ");
			descrizione.append("");
		}
		}
		return descrizione.toString();
	}
	
}
