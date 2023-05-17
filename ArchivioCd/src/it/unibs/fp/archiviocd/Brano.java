package it.unibs.fp.archiviocd;
/**
 * 
 * @author Fatih Aya
 *
 */
public class Brano {

		private String titolo;
		private double durata;
		
		public Brano(String titolo, double durata) {
			this.titolo = titolo;
			this.durata = durata;
		}
		
		public String getTitolo() {
			return titolo;
		}

		public double getDurata() {
			return durata;
		}

		@Override
		public String toString(){
			StringBuffer descrizione = new StringBuffer();
			descrizione.append("Titolo del Brano: "+titolo+ "\nDurata:" +durata);
			return descrizione.toString();
		}
}