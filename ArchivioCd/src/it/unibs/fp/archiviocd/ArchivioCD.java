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
	
	private String nomeArchivio;
	private ArrayList<CD>listaCD= new ArrayList<CD> () ;
	private int cdIndex;
	private int branoIndex;
	private static String titoloCDInserito;
	private static String autoreCDInserito;
	private static String titoloBranoInserito;
	private static double durataBranoInserito;
	private ArrayList <Brano> listaBraniInCreazione= new ArrayList<Brano>();
	private int sceltaMenuBrani=0;
	private static String [] vociEditorBrani = {"Inserire nuovo brano al CD"};
	public static final String MSG_AGGIUNTA_SUCCESSO = "\nBrano %s aggiunto alla lista con successo\n";
	
	public ArchivioCD() {
	}

	public ArchivioCD( String nomeArchivio, ArrayList<CD> listaCD) {
		this.nomeArchivio = nomeArchivio;
		this.listaCD = listaCD;
	}

	/**
	 * inserisce CD all'archivioCD
	 */
	public void inserisciCD () {
		CD cdDaInserire= creaCD();
		listaCD.add(cdDaInserire);	
	}
	
	/**
	 * 
	 * @return
	 */
	public CD creaCD () {
		titoloCDInserito= InputDati.leggiStringaNonVuota("Come vuoi chiamare questo CD?");
		// controllo sul titolo del CD
		for(CD i: listaCD) {
			if (titoloCDInserito.equalsIgnoreCase(i.getTitoloCD())) {
				titoloCDInserito= InputDati.leggiStringa("Esiste gia' un CD dello stesso nome,"
						+ "\ninserisci un nuovo CD");
			}	
		}
		autoreCDInserito= InputDati.leggiStringaNonVuota("Chi è l'autore di questo CD?");
		return new CD(titoloCDInserito, autoreCDInserito, creaListaBrani());
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Brano> creaListaBrani () {
		MyMenu editorBrani= new MyMenu("EditorBrani", vociEditorBrani);
		System.out.println("Ora dovresti inserire i brani del tuo CD\n");
		
		do {
		sceltaMenuBrani= editorBrani.scegli();
		switch (sceltaMenuBrani) {
		case 1:
		titoloBranoInserito= InputDati.leggiStringaNonVuota("Come si intitola questo brano? ");	
		durataBranoInserito= InputDati.leggiDouble("Quanti minuti dura questo brano? ");
		Brano branoDaInserire= new Brano(titoloBranoInserito, durataBranoInserito);
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
     * 
     * @param listaDaVisualizzare
     */
    public void visualizzaListaBrani(ArrayList<Brano> listaDaVisualizzare) {
    	for (branoIndex=0; branoIndex < listaDaVisualizzare.size(); branoIndex++) {
    		visualizzaBrano(listaDaVisualizzare.get(branoIndex));
    	}
    	System.out.println("La lista di brani casuali è terminata.");
    }
    
    
    
    public void visualizzaCD (CD cdDaVisualizzare) {
		
    	 System.out.println(cdDaVisualizzare.toString()+"\n");	
		
	}
    
    
    public void visualizzaBrano (Brano branoDaVisualizzare) {
    
    System.out.println(branoDaVisualizzare.toString()+"\n");	
    	
    	
    }
    
    
    /**
     * 
     */
    public void eliminaCD() {
    	titoloCDInserito= InputDati.leggiStringaNonVuota("\nInserire il nome del CD da eliminare");
		cdIndex=0;
		while (cdIndex<listaCD.size()) {
			if (listaCD.get(cdIndex).getTitoloCD().equalsIgnoreCase(titoloCDInserito)) {
				listaCD.remove(cdIndex);
			}
			cdIndex=cdIndex+1;
			System.out.printf("%s e' stato eliminato dall'archivio con successo\n", titoloCDInserito);
		}
		
	}
	
    //non compila
    /**
     * 
     */
    public void riproduciCDaCaso () {
    	int cdIndex = NumeriCasuali.estraiIntero(0, listaCD.size());
    	visualizzaListaBrani(listaCD.get(cdIndex).ShuffleBrani());
	}
    
    /**
     * 
     */
    public void visualizzaCollezione() {
    	for (CD i: listaCD) {
    		System.out.println(i.toString()+"\n");	
    	}
    }
    
}
