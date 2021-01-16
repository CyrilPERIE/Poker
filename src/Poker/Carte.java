package Poker;
/**
 * Cette classe permet de créer les différentes Carte du JeuDeCarte
 * Elle nous permet également d'avoir accés à plus d'information concernant les Carte
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
	 * Permet d'accéder à la valeur de la Carte
	 * @return Valeur
	 */
	public Valeur getValeur() {
		return this.valeur;
	}
	
	/**
	 * Permet de paramétrer la valeur de la carte
	 * @param value Valeur
	 */
	public void setValeur(Valeur value) {
		this.valeur = value;
	}
	
	/**
	 * Permet d'accéder à la famille de la carte
	 * @return Famille
	 */
	public Famille getFamille() {
		return this.famille;
	}
	
	/**
	 * Permet de paramétrer la famille de la carte
	 * @param famille
	 */
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
	public String toString() {
		return this.valeur + " de " + this.famille;
	}

}
