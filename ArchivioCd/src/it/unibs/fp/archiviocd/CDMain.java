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
				  "Visualizzare intera collezione ", "Riprodurre un brano a caso"};
		
		 
		public static void main (String[] args) {
			
		System.out.println(SALUTO);
		
		int scelta=0;
		
		MyMenu principale= creaMenuPrincipale();
		
		
		
		ArchivioCD archivio1= new ArchivioCD("Titolo archivio");
		
		do {
			scelta = principale.scegli();
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
				// Riproduce un brano a caso
				archivio1.riproduciCDaCaso();
				break;
				
			default:
				break;
			}
			System.out.println("puzzi");

		} while (scelta != 0);
		
		
		
	}

		
		public static MyMenu creaMenuPrincipale() {
			String titolo = InputDati.leggiStringaNonVuota(RICHIESTA);
			return new MyMenu(titolo, voci);
		}
		
		
}
