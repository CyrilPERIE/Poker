package Poker;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	List<Joueur> joueurs = new ArrayList<Joueur>();
	
	/**
	 * Ajoute un joueur à la partie
	 * @param j Le pseudo du joueur
	 */
	public void newJoueur(String j) {
		joueurs.add(new Joueur(j));
	}
	
}
