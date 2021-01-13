package Poker;

public class Carte {
	Valeur valeur;
	Famille famille;
	
	public Carte(Valeur v, Famille f) {
		this.valeur = v;
		this.famille = f;
	}
	
	public Valeur getValeur() {
		return this.valeur;
	}
	
	public void setValeur(Valeur v) {
		this.valeur = v;
	}
	
	public Famille getFamille() {
		return this.famille;
	}
	
	public void setFamille(Famille f) {
		this.famille = f;
	}
	
	public String toString() {
		return this.valeur + " de " + this.famille;
	}

}
