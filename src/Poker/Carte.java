package Poker;

public class Carte {
	Valeur valeur;
	Famille famille;
	
	public Carte(Valeur value, Famille famille) {
		this.valeur = value;
		this.famille = famille;
	}
	
	public Valeur getValeur() {
		return this.valeur;
	}
	
	public void setValeur(Valeur value) {
		this.valeur = value;
	}
	
	public Famille getFamille() {
		return this.famille;
	}
	
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
	public String toString() {
		return this.valeur + " de " + this.famille;
	}

}
