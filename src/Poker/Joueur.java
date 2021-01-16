package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Joueur {
	String name;
	List<Carte> cartes = new ArrayList<Carte>();
	List<Integer> combinaisons = new ArrayList<Integer>();
	
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
		this.combinaisons.add(c);
	}
	
	public void cartesSet(Carte c1, Carte c2){
		cartes.clear();
		cartes.add(c1);
		cartes.add(c2);
	}

	public void sortCombinaison() {
		Collections.sort(combinaisons,Collections.reverseOrder());
		
	}

	public String combinaisonstoString(Combinaison c) {
		String result = "";
		for(int i = 0; i<this.combinaisons.size(); i++) {
			result += c.dictionnaireDesCombinaisons.get(combinaisons.get(i)) + " | ";
		}
		return result;
	}

}
