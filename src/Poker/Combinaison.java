package Poker;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Combinaison {
	
	enum CombinaisonPossible{
		Paire,DoublePaire,Brelan,Suite,Couleur,Full,Carre,Quite,QuinteFlush
	}
	
	public Combinaison() {
		// TODO Auto-generated constructor stub
	}
	
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
		//Cinq cartes qui se suivent avec au moins une de couleurs différentes
		isSuite();
		//Cinq cartes de la même couleur
		isCouleur();
		//Brelan + Paire
		isFull();
		//Quatres cartes de valeurs identique
		isCarre();
		//Cinq cartes de la même couleur qui se suivent
		isQuinte();
		//10,V,D,R,A de la même couleur
		isQuinteFlush();
		
		Créer un dico avec le nombre de cartes par valeur pour gérer
		 Paire, Double paire, Brelan, Full, Carre, Quinte
		
		Créer un dico avec le nombre de cartes par couleur pour gérer
		 Couleur
		
		Si on détecte qu'il est possible que le joueur possede les combinaisons suivantes, on regarde les valeur et familles
		 Quinte, Quinte Flush
		
		*/
		
		HashMap<Famille,Integer> famille = new HashMap<Famille, Integer>();
		HashMap<Valeur,Integer> valeurs = new HashMap<Valeur, Integer>();
		
		famille = compterFamille(jeu,flop.cartes,famille);
		valeurs = compterValeurs(jeu,flop.cartes,valeurs);
		
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



	private HashMap<Valeur, Integer> compterValeurs(List<Carte> jeu, List<Carte> flop, HashMap<Valeur, Integer> valeurs) {
		Valeur valeurVu;
		int occurence;
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

	private HashMap<Famille, Integer> compterFamille(List<Carte> jeu, List<Carte> flop, HashMap<Famille, Integer> familles) {
		Famille familleVu;
		int occurence;
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




