package Poker;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Combinaison {
	
	/**
	 * 
	 * Enum�re toutes les combinaisons possibles au poker
	 *
	 */
	enum CombinaisonPossible{
		Paire,DoublePaire,Brelan,Suite,Couleur,Full,Carre,Quite,QuinteFlush
	}
	
	public Combinaison() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * D�termine les combinaisons poss�d�es par le Joueur j
	 * @param flop Un objet de type Flop
	 * @param j Un object de type Joueur
	 * @param jeu la liste de Carte du Joueur j
	 * 
	 */
	public void joueurA(Flop flop,Joueur j,List<Carte> jeu) {
		/*
		Les combinaisaisons possibles sont les suivantes
		
		couleur = famille
		
		//Deux cartes de valeurs identiques
		isPaire();
		//Deux paires
		isDoublePaire();
		//Trois cartes de valeurs identiques
		isBrelan();
		//Cinq cartes qui se suivent avec au moins une de couleurs diff�rentes
		isSuite();
		//Cinq cartes de la m�me couleur
		isCouleur();
		//Brelan + Paire
		isFull();
		//Quatres cartes de valeurs identique
		isCarre();
		//Cinq cartes de la m�me couleur qui se suivent
		isQuinte();
		//10,V,D,R,A de la m�me couleur
		isQuinteFlush();
		
		Cr�er un dico avec le nombre de cartes par valeur pour g�rer
		 Paire, Double paire, Brelan, Full, Carre, Quinte
		
		Cr�er un dico avec le nombre de cartes par couleur pour g�rer
		 Couleur
		
		Si on d�tecte qu'il est possible que le joueur possede les combinaisons suivantes, on regarde les valeur et familles
		 Quinte, Quinte Flush
		
		*/
		
		HashMap<Famille,Integer> famille = new HashMap<Famille, Integer>();
		HashMap<Valeur,Integer> valeurs = new HashMap<Valeur, Integer>();
		
		famille = compterFamille(jeu,flop.cartes);
		valeurs = compterValeurs(jeu,flop.cartes);
		
		/*
		int valeursMaxValue = Collections.max(valeurs.values());
		switch(valeursMaxValue) {
		case 2:
			
		case 3:
			
		case 4:
		}
		int familleMaxValue = Collections.max(famille.values());
		*/
		
		j.addFamille(famille);
		j.addValeur(valeurs);
		
	}


	/**
	 * 
	 * @param jeu Une liste de Carte 
	 * @param flop Un objet de type Flop
	 * @return une Hashmap contenant les valeurs pr�sentes dans le jeu et le flop (cl�) et leur nombre (valeur)
	 */
	private HashMap<Valeur, Integer> compterValeurs(List<Carte> jeu, List<Carte> flop) {
		Valeur valeurVu;
		int occurence;
		HashMap<Valeur, Integer> valeurs = new HashMap<Valeur, Integer>();
		for(int v = 0; v<Valeur.values().length;v++) {
			occurence = 0;
			valeurVu = Valeur.values()[v];
			for(int v2 = 0; v2<jeu.size();v2++) {
				Carte carte = jeu.get(v2);
				if(carte.getValeur() == valeurVu) {
					occurence++;
				}
			}
			
			for(int v2 = 0; v2<flop.size();v2++) {
				Carte carte = flop.get(v2);
				if(carte.getValeur() == valeurVu) {
					occurence++;
				}
			}
			
			if(occurence >=1) {
				valeurs.put(valeurVu, occurence);
			}
			
		}
		return valeurs;
	}
	
	/**
	 * 
	 * @param jeu Une liste de Carte 
	 * @param flop Un objet de type Flop
	 * @return une Hashmap contenant les familles pr�sentes dans le jeu et le flop (cl�) et leur nombre (valeur)
	 */
	private HashMap<Famille, Integer> compterFamille(List<Carte> jeu, List<Carte> flop) {
		Famille familleVu;
		int occurence;
		HashMap<Famille, Integer> familles = new HashMap<Famille, Integer>();
		for(int f = 0; f<Famille.values().length;f++) {
			occurence = 0;
			familleVu = Famille.values()[f];
			for(int f2 = 0; f2<jeu.size();f2++) {
				Carte carte = jeu.get(f2);
				if(carte.getFamille() == familleVu) {
					occurence++;
				}
			}
			
			for(int f2 = 0; f2<flop.size();f2++) {
				Carte carte = flop.get(f2);
				if(carte.getFamille() == familleVu) {
					occurence++;
				}
			}
			
			if(occurence >=1) {
				familles.put(familleVu, occurence);
			}
			
		}
		return familles;
	}
}




