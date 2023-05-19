package it.unibs.fp.archiviocd;
import java.util.*;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;
import it.unibs.fp.mylib.InputDati;
/**
 * 
 * @author Stocchetti Daian e Molla Blen Zena 
 *
 * Questa classe rappresenta una collezione di CD contenenti brani e si interfaccia alle relative classi.
 * Sono presenti metodi per la creazione di un nuovo CD e della sua lista di brani, la visualizzazione dei contenuti di un CD,
 * l'eliminazione di un CD, la riproduzione di una playlist casuale di brani, la visualizzazione dell'intera collezione.
 *
 */


public class ArchivioCD {
	public static final String MSG_ELIMINAZIONE_SUCCESSO = "%s e' stato eliminato dall'archivio con successo\n";
	public static final String MSG_CD_DA_ELIMINARE = "\nInserire il nome del CD da eliminare";
	public static final String MSG_TERMINAZIONE_LISTA = "La lista di brani casuali è terminata.";
	public static final String MSG_DURATA_BRANO_M = "Durata minuti formato[min:sec] ";
	public static final String MSG_DURATA_BRANO_S = "Durata secondi formato[min:sec] ";
	public static final String MSG_TIT_BRANO = "Come si intitola questo brano? ";
	public static final String MSG_INSERIMENTO_BRANI = "Ora dovresti inserire i brani del tuo CD\n";
	public static final String MSG_AUTORE_CD = "Chi è l'autore di questo CD?";
	public static final String MSG_REINSERIMENTO_TITOLO_CD = "Esiste gia' un CD dello stesso nome,"
			+ "\ninserisci un nuovo CD";
	public static final String MSG_TITOLO_CD = "Come vuoi chiamare questo CD?";
	//attributi
	private String nomeArchivio;
	private ArrayList<CD>listaCD= new ArrayList<CD> () ;
	private int cdIndex;
	private int branoIndex;
	private static String titoloCDInserito;
	private static String autoreCDInserito;
	// private static String titoloBranoInserito;
	// private static double durataBranoInserito;
	private ArrayList <Brano> listaBraniInCreazione= new ArrayList<Brano>();
	private int sceltaMenuBrani=0;
	private static String [] vociEditorBrani = {"Inserire nuovo brano al CD"};
	public static final String MSG_AGGIUNTA_SUCCESSO = "\nBrano %s aggiunto alla lista con successo\n";
	
	//costruttori
	public ArchivioCD() {
	}

	public ArchivioCD( String nomeArchivio, ArrayList<CD> listaCD) {
		this.nomeArchivio = nomeArchivio;
		this.listaCD = listaCD;
	}

	/**
	 * Inserisce un nuovo CD nell'archivio appoggiandosi al metodo creaCD.
	 */
	public void inserisciCD () {
		CD cdDaInserire= creaCD();
		listaCD.add(cdDaInserire);	
	}
	
	/**
	 *Metodo che raccoglie dall'utente tutti i dati necessari per la creazione
	 * di una nuova istanza di tipo CD. Per ottenere la lista dei brani chiama 
	 * il metodo creaListaBrani.
	 * @return new CD (...)
	 */
	public CD creaCD () {
		titoloCDInserito= InputDati.leggiStringaNonVuota(MSG_TITOLO_CD);
		// controllo sul titolo del CD
		for(CD i: listaCD) {
			if (titoloCDInserito.equalsIgnoreCase(i.getTitoloCD())) {
				titoloCDInserito= InputDati.leggiStringa(MSG_REINSERIMENTO_TITOLO_CD);
			}	
		}
		autoreCDInserito= InputDati.leggiStringaNonVuota(MSG_AUTORE_CD);
		return new CD(titoloCDInserito, autoreCDInserito, creaListaBrani());
	}
	/**
	 * Ritorna un arraylist contenente i brani inseriti in un ciclo interattivo con l'utente.
	 * @return ArrayList
	 */
	public ArrayList<Brano> creaListaBrani () {
		MyMenu editorBrani= new MyMenu("EditorBrani", vociEditorBrani);
		System.out.println(MSG_INSERIMENTO_BRANI);
		
		do {
		sceltaMenuBrani= editorBrani.scegli();
		switch (sceltaMenuBrani) {
		
		case 1:
		String titoloBranoInserito= InputDati.leggiStringaNonVuota(MSG_TIT_BRANO);	
		int durataM= InputDati.leggiIntero(MSG_DURATA_BRANO_M);
		int durataS= InputDati.leggiIntero(MSG_DURATA_BRANO_S);
		Brano branoDaInserire= new Brano(titoloBranoInserito, durataM, durataS);
		listaBraniInCreazione.add(branoDaInserire);
		System.out.printf(MSG_AGGIUNTA_SUCCESSO, branoDaInserire.getTitolo());
			break;
		default: 
			break;
			} 
		} while (sceltaMenuBrani!=0);
		return listaBraniInCreazione;
	}
    
    /**
     * Visualizza il contenuto di una lista di brani.
     * @param listaDaVisualizzare
     */
    public void visualizzaListaBrani(ArrayList<Brano> listaDaVisualizzare) {
    	for (branoIndex=0; branoIndex < listaDaVisualizzare.size(); branoIndex++) {
    		visualizzaBrano(listaDaVisualizzare.get(branoIndex));
    	}
    	System.out.println(MSG_TERMINAZIONE_LISTA);
    }
    
    
     /**
     * Visualizza il contenuto di un CD.
     * @param cdDaVisualizzare
     */
    
    public void visualizzaCD (CD cdDaVisualizzare) {
		
    	 System.out.println(cdDaVisualizzare.toString()+"\n");	
		
	}
    
	
     /**
     * Visualizza il contenuto di un brano.
     * @param branoDaVisualizzare
     */
    
    public void visualizzaBrano (Brano branoDaVisualizzare) {
    
    System.out.println(branoDaVisualizzare.toString()+"\n");	
    	
    	
    }
    
    
    /**
     * Elimina un CD intero dall'archivio basandosi sul titolo fornito dall'utente.
     */
    public void eliminaCD() {
    	titoloCDInserito= InputDati.leggiStringaNonVuota(MSG_CD_DA_ELIMINARE);
		cdIndex=0;
		while (cdIndex<listaCD.size()) {
			if (listaCD.get(cdIndex).getTitoloCD().equalsIgnoreCase(titoloCDInserito)) {
				listaCD.remove(cdIndex);
			}
			cdIndex=cdIndex+1;
			System.out.printf(MSG_ELIMINAZIONE_SUCCESSO, titoloCDInserito);
		}
		
	}
	
    /**
     * Seleziona un'istanza casuale della classe CD ed in essa chiama il metodo adibito alla realizzazione
     * di una playlist randomica di brani (vedi il metodo "shuffleBrani" nella classe CD).
     * Infine chiama il metodo visualizzaListaBrani fornendogli l'ArrayList di ritorno.
     */
    public void riproduciCDaCaso () {
    	int cdIndex = NumeriCasuali.estraiIntero(0, listaCD.size());
    	visualizzaListaBrani(listaCD.get(cdIndex).ShuffleBrani());
	}
    
    /**
     * Visualizza l'intero archivio.
     */
    public void visualizzaCollezione() {
    	for (CD i: listaCD) {
    		System.out.println(i.toString()+"\n");	
    	}
    }
    
}
