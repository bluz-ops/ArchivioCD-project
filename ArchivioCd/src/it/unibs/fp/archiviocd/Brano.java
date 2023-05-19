package it.unibs.fp.archiviocd;
/**
 * Questa classe crea l'oggetto Brano
 * @author Fatih Aya
 *
 */
public class Brano {
		//attributi
		private String titolo;
		private int duratam;
		private int duratas;
		
		//costruttore
		/**
		 * @param titolo
		 * @param duratam
		 * @param duratas
		 */
		public Brano(String titolo, int duratam, int duratas) {
			this.titolo = titolo;
			this.duratam = duratam;
			this.duratas = duratas;
		}

		//getters
		public String getTitolo() {
			return titolo;
		}
		
		public int getDuratam() {
			return duratam;
		}

		public int getDuratas() {
			return duratas;
		}
		
		/**
		 * toString sovrascrive il metodo toString della classe object
		 * restituisce una stringa descrittiva
		 */
		@Override
		public String toString(){
			StringBuffer descrizione = new StringBuffer();
			descrizione.append(""+titolo+ " [0" +duratam+ ":"+ duratas+ "]");
			return descrizione.toString();
		}
}