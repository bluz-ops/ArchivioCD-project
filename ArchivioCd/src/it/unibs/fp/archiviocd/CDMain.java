package it.unibs.fp.archiviocd;

import java.util.ArrayList;
import java.util.Random;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.NumeriCasuali;
import it.unibs.fp.mylib.MyMenu;
public class CDMain {
	
		private static final String SALUTO = "Benvenuto \n";
		private static final String RICHIESTA= "Come vuoi chiamare il tuo archivio?\n";
		private static String [] voci = {"Inserire nuovo CD alla collezione", "Eliminare CD dalla collezione", 
				  "Visualizzare intera collezione ", "Riprodurre 3 brani a caso da CD a caso"};
		
	/**
	* 
	*Utilizza la classe MyMenu per gestire le interazioni con l'utente. Fa grande uso
	* dei metodi della classe Archivio.
	*
	*@author Daian Stocchetti
	*/
	
		public static void main (String[] args) {	
			
		System.out.println(SALUTO);
		// istanza di ArchivioCD
		ArchivioCD archivio1= new ArchivioCD();
		
		int scelta=0;
		MyMenu menuPrincipale= creaMenuPrincipale();
		
		do {
			scelta = menuPrincipale.scegli();
			switch (scelta) {
			
			case 1:
				// Inserisce un nuovo Cd
				archivio1.inserisciCD();
				break;
			
			case 2:
				// Elimina un Cd
				archivio1.eliminaCD();
				break;
				
			case 3:
				// Visualizza l'intera collezione
				archivio1.visualizzaCollezione();
				break;
				
			case 4:
				// Riproduce una lista di brani a caso
				System.out.println("ATTENZIONE: fare almeno 3 inserimenti per cd");
				archivio1.riproduciCDaCaso();
				break;
				
			default:
				break;
			}
		

		} while (scelta != 0);
		
		
		
	}
		/**
		 * Metodo che raccoglie dall'utente tutti i dati necessari per la creazione
		 * di una nuova istanza di tipo MyMenu.
		 * @return new MyMenu(...)
		 */
		public static MyMenu creaMenuPrincipale() {
			String titolo = InputDati.leggiStringaNonVuota(RICHIESTA);
			return new MyMenu(titolo, voci);
		}
		
		
}
