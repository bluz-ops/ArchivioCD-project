package it.unibs.fp.archiviocd;
/**
 * 
 * @author Fatih Aya
 *
 */
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
		@Override
		public String toString(){
			StringBuffer descrizione = new StringBuffer();
			descrizione.append("Titolo del Brano:"+titolo+ "Durata:" +durata );
			return descrizione.toString();
		}
}