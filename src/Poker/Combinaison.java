package Poker;

public class Combinaison {
	
	/**
	 * 
	 * Enum�re toutes les combinaisons possibles au poker
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
	 * D�termine les combinaisons poss�d�es par le Joueur j
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
		 
		 Au final on retire les cartes qui combin�es font le plus de point. 
		 Pour celle(s) qui reste(nt) on garde la plus grand en cas d'�galit�
		
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




