package Poker;

public class Combinaison {
	
	/**
	 * 
	 * Enumère toutes les combinaisons possibles au poker
	 *
	 */
	enum CombinaisonPossible{
		Paire(1),DoublePaire(1*14),Brelan(2*14),Suite(3*14),Couleur(4*14),Full(5*14),Carre(6*14),Quite(7*14),QuinteFlush(8*14);
		
		final int valeur;
		
		CombinaisonPossible(int v){
			this.valeur = v;
		}
	}
	
	public Combinaison() {
	}
	
	/**
	 * Détermine les combinaisons possédées par le Joueur j
	 * @param flop Un objet de type Flop
	 * @param j Un object de type Joueur
	 * @param jeu la liste de Carte du Joueur j
	 * 
	 */
	public void joueurA(Flop f,Joueur j) {
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
		 
		 Au final on retire les cartes qui combinées font le plus de point. 
		 Pour celle(s) qui reste(nt) on garde la plus grand en cas d'égalité
		
		*/

		
		Carte cp1 = j.cartes.get(0);
		Carte cp2 = j.cartes.get(1);
		Carte cf1 = f.cartes.get(0);
		Carte cf2 = f.cartes.get(1);
		Carte cf3 = f.cartes.get(2);
		
		int v1 = memeValeur(cp1,cf1,cf2,cf3);
		int v2 = memeValeur(cp2,cf1,cf2,cf3);
		
		if(cp1.valeur == cp2.valeur) {
			v1 ++;
		}
		else {
			
		}
	}
	
	public int memeValeur(Carte c1, Carte c2, Carte c3, Carte c4) {
		int result = 0;
		if(c1.valeur == c2.valeur) {
			result++;
		}
		if(c1.valeur == c3.valeur) {
			result++;
		}
		if(c1.valeur == c4.valeur) {
			result++;
		}
		return result;
	}
}




