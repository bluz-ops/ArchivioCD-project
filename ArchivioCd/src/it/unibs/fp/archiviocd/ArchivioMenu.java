package it.unibs.fp.archiviocd;
import it.unibs.fp.mylib.MyMenu;
/**
 * 
 * @author Molla Blen
 *
 */
public class ArchivioMenu extends MyMenu{
	private String titolo = " Opzioni per la gestione della mia collezione";
	  private String [] voci = {"Inserire nuovo CD alla mia collezione", "Eliminare CD dalla collezione", 
			  "Visualizzare intera collezione ", "Riprodurre un brano a caso"};
	/**
	 * costruttore 
	 * @param titolo
	 * @param voci
	 */
	public ArchivioMenu(String titolo, String[] voci) {
		super(titolo, voci);
	}
	
	
	
	
}
