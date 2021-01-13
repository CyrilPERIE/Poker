package Poker;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	String name;
	List<Carte> cartes = new ArrayList<Carte>();
	List<Integer> combinaison = new ArrayList<Integer>();
	
	public Joueur(String name) {
		
		this.name = name;
	}
	
	/**
	 * Permet la transaction d'un carte de jdc à this.joueur
	 * @param jdc Un objet de type JeuDeCarte
	 */
	public void distribuer(JeuDeCarte jdc) {
		cartes.add(jdc.jeu.get(0));
		jdc.jeu.remove(0);
		
	}
	
	public String toString() {
		return this.name + " a " + this.cartes;
	}
	
	
	/**
	 * Ajoute les points associés à la combinaison possédée par le joueur
	 * @param c
	 */
	public void addCombinaison(int c) {
		this.combinaison.add(c);
	}

}
