package it.unibs.fp.archiviocd;
/**
 * Questa classe crea l'oggetto Brano
 * @author Fatih Aya
 *
 */
public class Brano {
		//attributi
		private String titolo;
		private double durata;
		
		//costruttori
		public Brano(String titolo, double durata) {
			this.titolo = titolo;
			this.durata = durata;
		}
		
		//getters
		public String getTitolo() {
			return titolo;
		}

		public double getDurata() {
			return durata;
		}
		/**
		 * toString sovrascrive il metodo toString della classe object
		 * restituisce una stringa descrittiva
		 */
		@Override
		public String toString(){
			StringBuffer descrizione = new StringBuffer();
			descrizione.append("Titolo del Brano: "+titolo+ "\nDurata:" +durata);
			return descrizione.toString();
		}
}