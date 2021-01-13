package Poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Joueur {
	String name;
	List<Carte> cartes = new ArrayList<Carte>();
	HashMap<Famille, Integer> familles;
	HashMap<Valeur, Integer> valeurs;
	List<Integer> combinaison = new ArrayList<Integer>();
	
	public Joueur(String name) {
		
		this.name = name;
	}
	
	/**
	 * Permet la transaction d'un carte de jdc � this.joueur
	 * @param jdc Un objet de type JeuDeCarte
	 */
	public void distribuer(JeuDeCarte jdc) {
		cartes.add(jdc.jeu.get(0));
		jdc.jeu.remove(0);
		
	}
	
	public String toString() {
		return this.name + " a " + this.cartes;
	}
	
	public void addFamille(HashMap<Famille, Integer> f) {
		this.familles = f;
		
	}

	public void addValeur(HashMap<Valeur, Integer> v) {
		this.valeurs = v;
		
	}
	
	/**
	 * Ajoute les points associ�s � la combinaison poss�d�e par le joueur
	 * @param c
	 */
	public void addCombinaison(int c) {
		this.combinaison.add(c);
	}

}
