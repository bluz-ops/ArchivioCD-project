package it.unibs.fp.archiviocd;
import java.util.*;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;
import it.unibs.fp.mylib.InputDati;
/**
 * 
 * @author Stocchetti Daian 
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
	 * inserisce un nuovo CD all'archivioCD
	 */
	public void inserisciCD () {
		CD cdDaInserire= creaCD();
		listaCD.add(cdDaInserire);	
	}
	
	/**
	 * crea un CD chiedendo all'utente titolo ed autore
	 * @return CD
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
	 * ritorna un arraylist contenente i brani inseriti in un ciclo interattivo con l'utente
	 * @return
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
     * visualizza il contenuto di un CD
     * @param listaDaVisualizzare
     */
    public void visualizzaListaBrani(ArrayList<Brano> listaDaVisualizzare) {
    	for (branoIndex=0; branoIndex < listaDaVisualizzare.size(); branoIndex++) {
    		visualizzaBrano(listaDaVisualizzare.get(branoIndex));
    	}
    	System.out.println(MSG_TERMINAZIONE_LISTA);
    }
    
    
    
    public void visualizzaCD (CD cdDaVisualizzare) {
		
    	 System.out.println(cdDaVisualizzare.toString()+"\n");	
		
	}
    
    
    public void visualizzaBrano (Brano branoDaVisualizzare) {
    
    System.out.println(branoDaVisualizzare.toString()+"\n");	
    	
    	
    }
    
    
    /**
     * elimina un cd intero dall'archivio
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
     * riproduce 3 brani a caso di un cd preso a caso tra quelli presenti nell'archivio
     */
    public void riproduciCDaCaso () {
    	int cdIndex = NumeriCasuali.estraiIntero(0, listaCD.size());
    	visualizzaListaBrani(listaCD.get(cdIndex).ShuffleBrani());
	}
    
    /**
     * visualizza l'intero archivio
     */
    public void visualizzaCollezione() {
    	for (CD i: listaCD) {
    		System.out.println(i.toString()+"\n");	
    	}
    }
    
}
