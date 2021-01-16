package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 * @author Cyril
 * Permet le déroulement d'une partie de Poker Classique
 */
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
	
	/**
	 * Trouve le gagnant du pli
	 * @return le joueur J gagnant du pli
	 */
	public Joueur quiGagne(){
		creationCombinaisonsJoueurs();
		int maxCol = maxCol();
		int joueurIndex = indexGagnant(maxCol);
		
		return joueurs.get(joueurIndex);
		
	}
	
	/**
	 * Ressors l'index (ligne) du gagnant dans la ragged array (combinaisonsJoueurs)
	 * @param maxCol le nombre maximum de colonne dans la ragged array (combinaisonsJoueurs)
	 * @return l'index du gagnant du pli
	 */
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
	
	/**
	 * Transforme une colonne en liste
	 * @param col l'index de la colonne à transformer en ligne
	 * @return une liste d'Integer
	 */
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
	
	/**
	 * Trouve la valeur maximal de colonne pour une ligne dans une matrice
	 */
	private int maxCol() {
		int result = 0;
		for(int[] row : this.combinaisonsJoueurs) {
			if(result < row.length) {
				result = row.length;
			}
		}
		return result;
	}

	/**
	 * Crée la ragged array, associe à chaque ligne les combinaisons d'un joueur
	 */
	
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
