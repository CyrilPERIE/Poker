package Poker;
/**
 * Cette classe permet de cr�er les diff�rentes Carte du JeuDeCarte
 * Elle nous permet �galement d'avoir acc�s � plus d'information concernant les Carte
 */
public class Carte {
	Valeur valeur;
	Famille famille;
	
	/**
	 * Constructeur
	 * @param value Value
	 * @param famille Famille
	 */
	public Carte(Valeur value, Famille famille) {
		this.valeur = value;
		this.famille = famille;
	}
	
	/**
	 * Permet d'acc�der � la valeur de la Carte
	 * @return Valeur
	 */
	public Valeur getValeur() {
		return this.valeur;
	}
	
	/**
	 * Permet de param�trer la valeur de la carte
	 * @param value Valeur
	 */
	public void setValeur(Valeur value) {
		this.valeur = value;
	}
	
	/**
	 * Permet d'acc�der � la famille de la carte
	 * @return Famille
	 */
	public Famille getFamille() {
		return this.famille;
	}
	
	/**
	 * Permet de param�trer la famille de la carte
	 * @param famille
	 */
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
	public String toString() {
		return this.valeur + " de " + this.famille;
	}

}
