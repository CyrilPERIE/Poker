package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jeu {
	List<Joueur> joueurs = new ArrayList<Joueur>();
	int[][] combinaisonsJoueurs;
	
	/**
	 * Ajoute un joueur à la partie
	 * @param j Le pseudo du joueur
	 */
	public void newJoueur(String j) {
		joueurs.add(new Joueur(j));
	}
	
	public Joueur quiGagne(){
		creationCombinaisonsJoueurs();
		int maxCol = maxCol();
		int joueurIndex = indexGagnant(maxCol);
		
		return joueurs.get(joueurIndex);
		
	}
	
	private int indexGagnant(int maxCol) {
		//On crée une liste avec l'index des joueurs
		List<Integer> indexsJoueur = new ArrayList<Integer>();
		
		for(int i = 0;i<this.combinaisonsJoueurs.length;i++) {
			indexsJoueur.add(i);
		}
		
		//On regarde toutes les colonnes car classé dans l'ordre décroissant
		for(int col = 0; col<maxCol;col++) {
			Set<Integer> set = new HashSet<>(columToList(col));
			int max = Collections.max(set);
			//Si on a autant de valeur dans le set que dans la colonne ca veut dire que les joueurs ont chacun une combi différente
			int sizeBeforeSous = indexsJoueur.size();
			for(int i = sizeBeforeSous-1; i>=0 ; i--) {
				int row = indexsJoueur.get(i);
				if(this.combinaisonsJoueurs[row][col] != max) {
					try {
					indexsJoueur.remove(i);
					}catch(Exception e) {
						indexsJoueur.remove(i);
					}
				}
			}
			
			if(indexsJoueur.size() == 1) {
				break;
			}
		}
		return indexsJoueur.get(0);
	}
	private List<Integer> columToList(int col) {
		List<Integer> result = new ArrayList();
		for(int row = 0; row< this.combinaisonsJoueurs.length; row++) {
			try {
				result.add(this.combinaisonsJoueurs[row][col]);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	private int getColSize(int col) {
		int count = 0;
        for (int[] row : this.combinaisonsJoueurs) {
            if (col < row.length) count++;
        }
        return count;
	}

	private int maxCol() {
		int result = 0;
		for(int[] row : this.combinaisonsJoueurs) {
			if(result < row.length) {
				result = row.length;
			}
		}
		return result;
	}

	private void creationCombinaisonsJoueurs() {
		this.combinaisonsJoueurs = new int[joueurs.size()][];
		for(int row = 0; row<joueurs.size(); row++) {
			int column = 0;
			Joueur joueur = this.joueurs.get(row);
			this.combinaisonsJoueurs[row] = new int[joueur.combinaisons.size()];
			for(int combinaison : joueur.combinaisons) {
				this.combinaisonsJoueurs[row][column] = combinaison;
				column++;
			}
		}	
		
	}
	
}
