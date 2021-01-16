package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * Permet d'instancier les Joueur du Jeu
 */
public class Joueur {
	String name;
	List<Carte> cartes = new ArrayList<Carte>();
	List<Integer> combinaisons = new ArrayList<Integer>();
	
	/**
	 * Constructeur Joueur
	 * @param name le pseudo du joueur
	 */
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
	
	
	/**
	 * Ajoute les points associ�s � la combinaison poss�d�e par le joueur
	 * @param c Ajoute la valeur cod�e d'une combinaison 
	 */
	public void addCombinaison(int c) {
		this.combinaisons.add(c);
	}
	
	/**
	 * Permet de param�trer soit m�me le jeu de carte d'un joueur
	 * @param c1 Carte
	 * @param c2 Carte
	 */
	public void cartesSet(Carte c1, Carte c2){
		cartes.clear();
		cartes.add(c1);
		cartes.add(c2);
	}
	
	/**
	 * trie de fa�on d�croissante combinaisons
	 */
	public void sortCombinaison() {
		Collections.sort(combinaisons,Collections.reverseOrder());
		
	}
	
	/**
	 * Litt�ralise le dictionnaire combinaisons
	 * @param c Combinaison
	 * @return la phrase contenant les combinaisons de c
	 */
	public String combinaisonstoString(Combinaison c) {
		String result = "";
		for(int i = 0; i<this.combinaisons.size(); i++) {
			result += c.dictionnaireDesCombinaisons.get(combinaisons.get(i)) + " | ";
		}
		return result;
	}

}
