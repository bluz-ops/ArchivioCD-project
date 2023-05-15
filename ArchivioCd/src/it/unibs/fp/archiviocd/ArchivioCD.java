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
	
	
	private ArrayList<CD>listaCD= new ArrayList<CD> () ;	
	private String nomeArchivio;
	private int cdIndex;
	private int branoIndex;
	private static String titoloCDInserito;
	private static String autoreCDInserito;
	private static String titoloBranoInserito;
	private static double durataBranoInserito;
	private ArrayList <Brano> listaBraniInCreazione= new ArrayList<Brano>();
	private int sceltaMenuBrani=0;
	private static String [] vociEditorBrani = {"Inserire nuovo brano al CD"};
	
	public ArchivioCD(String nomeArchivio) {
		super();
		this.nomeArchivio = nomeArchivio;
	} 
	
	
	public void inserisciCD () {
		CD cdDaInserire= creaCD();
		listaCD.add(cdDaInserire);	
	}
	
	public CD creaCD () {
		titoloCDInserito= InputDati.leggiStringaNonVuota("Come vuoi chiamare questo CD?");
		autoreCDInserito= InputDati.leggiStringaNonVuota("Chi è l'autore di questo CD?");
		return new CD(titoloCDInserito, autoreCDInserito, creaListaBrani());
	}
	
	public ArrayList<Brano> creaListaBrani () {
		
		
		MyMenu editorBrani= new MyMenu("EditorBrani", vociEditorBrani);
		System.out.println("Ora dovresti inserire i brani del tuo CD\n");
		sceltaMenuBrani= editorBrani.scegli();
		
		do {
		switch (sceltaMenuBrani) {
		
		case 1:
		
		titoloBranoInserito= InputDati.leggiStringaNonVuota("Come si intitola questo brano?");	
		durataBranoInserito= InputDati.leggiDouble("Quanto dura questo brano?");
		Brano branoDaInserire= new Brano(titoloBranoInserito, durataBranoInserito);
		listaBraniInCreazione.add(branoDaInserire);
		}
		
		} while (sceltaMenuBrani!=0);
		
		return listaBraniInCreazione;
	}
    
    
    public void visualizzaListaBrani(ArrayList<Brano> listaDaVisualizzare) {
    	branoIndex=0;
    	
    	while (branoIndex< listaDaVisualizzare.size()) {
    		
    		visualizzaBrano(listaDaVisualizzare.get(branoIndex));
    		branoIndex=branoIndex+1;
    	}
    	
    	System.out.println("La lista di brani è terminata.");
    }
    
    
    
    public void visualizzaCD (CD cdDaVisualizzare) {
		
    	 System.out.println(cdDaVisualizzare.toString()+"/n");	
		
	}
    
    
    public void visualizzaBrano (Brano branoDaVisualizzare) {
    
    System.out.println(branoDaVisualizzare.toString()+"/n");	
    	
    	
    }
    
    
    
    public void eliminaCD() {
    	titoloCDInserito= InputDati.leggiStringaNonVuota("Come si intitola il CD da eliminare?");
		cdIndex=0;
		
		while (cdIndex<listaCD.size()) {
			
			if (listaCD.get(cdIndex).getTitoloCD()==titoloCDInserito) {
				listaCD.remove(cdIndex);        //COME OBLITERO UN OGGETTO?
			}
			cdIndex=cdIndex+1;
		}
	}
	
    
    public void riproduciCDaCaso () {
    	int cdIndex = NumeriCasuali.estraiIntero(0, listaCD.size());
    	visualizzaListaBrani(listaCD.get(cdIndex).ShuffleBrani());
	}
	
    public void visualizzaCollezione () {
	  cdIndex=0;
      branoIndex=0;
    	
		
		
	}
	
    
    

}

