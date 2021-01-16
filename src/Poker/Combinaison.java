package Poker;

import java.util.HashMap;
/**
 * 
 * Cette classe permet de lister les différents combinaisons possibles et de créer le dictionnaireDesCombinaisons qui sert à décrypter Joueur.combinaisons
 */

public class Combinaison {
	HashMap<Integer,String> dictionnaireDesCombinaisons = new HashMap();
	
	/**
	 * 
	 * Enumère toutes les combinaisons possibles au poker
	 *
	 */
	enum CombinaisonPossible{
		Seule(0),Paire(14),DoublePaire(28),Brelan(42),Suite(56),Couleur(70),Full(84),Carre(98),QuinteFlush(112),QuinteFlushRoyale(126);
		
		final int valeur;
		/**
		 * @param v le nombre de points associés à une combinaison
		 */
		CombinaisonPossible(int v){
			this.valeur = v;
		}
	}
	
	/**
	 * Constructeur, instancie dictionnaireDesCombinaisons avec l'instanciation de l'objet
	 */
	public Combinaison() {
		creationdictionnaireDesCombinaisons();
	}
	
	/**
	 * Crée dictionnaireDesCombinaisons
	 */
	public void creationdictionnaireDesCombinaisons() {
		for(int combinaison = 0; combinaison<CombinaisonPossible.values().length-1; combinaison++) {
			for(int valeur = 0; valeur<Valeur.values().length; valeur++) {
				dictionnaireDesCombinaisons.put(CombinaisonPossible.values()[combinaison].valeur+Valeur.values()[valeur].position, CombinaisonPossible.values()[combinaison] + " de " + Valeur.values()[valeur] );
			}
		}
		dictionnaireDesCombinaisons.put(CombinaisonPossible.QuinteFlushRoyale.valeur, CombinaisonPossible.QuinteFlushRoyale + "");
	}
	
	/**
	 * Détermine les combinaisons possédées par le Joueur j
	 * @param f Un objet de type Flop
	 * @param j Un object de type Joueur 
	 */
	public void joueurA(Flop f,Joueur j) {
		Carte cp1 = j.cartes.get(0);
		Carte cp2 = j.cartes.get(1);
		Carte cf1 = f.cartes.get(0);
		Carte cf2 = f.cartes.get(1);
		Carte cf3 = f.cartes.get(2);
		//Detection : Paire, Double paire, Brelan, Full, Carre, Quinte et des cartes seules
		HashMap<Valeur,Integer> valeurMain = memeValeur(cp1,cp2,cf1,cf2,cf3);
		detectionLieeValeur(valeurMain,j);
		
		//Detection Couleur
		HashMap<Famille,Integer> familleMain = memeFamille(cp1,cp2,cf1,cf2,cf3);
		//Si 5 cartes ont des valeurs différentes
		if(valeurMain.size() == 5) {
			//Si les 5 cartes sont de la même famille pour quinte flush et quinte flush royale
			if(familleMain.size() == 1) {
				//Il y a une couleur 
				j.addCombinaison(CombinaisonPossible.Couleur.valeur + max(cp1,cp2,cf1,cf2,cf3));
				//et une possible quinte flush /quinte flush royale
				int isFlush = cp1.valeur.position + cp2.valeur.position + cf1.valeur.position + cf2.valeur.position + cf3.valeur.position;
				//Case de la Quinte Flush Royale
				if(isFlush == 55) {
					j.addCombinaison(CombinaisonPossible.QuinteFlushRoyale.valeur);
				}
				//Cas de la Quinte Flush
				else if(minmaxDiff(cp1,cp2,cf1,cf2,cf3) == 4) {
					int maxCarteValeur = max(cp1,cp2,cf1,cf2,cf3);
					j.addCombinaison(CombinaisonPossible.QuinteFlush.valeur + maxCarteValeur);
				}
			}
			//Sinon on regarde si il y a une suite
			else {
				if(minmaxDiff(cp1,cp2,cf1,cf2,cf3) == 4) {
					int maxCarteValeur = max(cp1,cp2,cf1,cf2,cf3);
					j.addCombinaison(CombinaisonPossible.Suite.valeur + maxCarteValeur);
				}
			}
		}
	}
	
	/**
	 * Permet de récupérer la plus grande position parmis les cartes
	 * @param cp1 Carte du joueur
	 * @param cp2 Carte du joueur
	 * @param cf1 Carte du flop
	 * @param cf2 Carte du flop
	 * @param cf3 Carte du flop
	 * @return
	 */
	private int max(Carte cp1, Carte cp2, Carte cf1, Carte cf2, Carte cf3) {
		int tempMax = cp1.valeur.position;
		int[] valeurToTest = {cp2.valeur.position,cf1.valeur.position,cf2.valeur.position,cf3.valeur.position};
		for(int i = 0; i<valeurToTest.length;i++) {
			int temp = valeurToTest[i];
			if(temp>tempMax) {
				tempMax = valeurToTest[i];
			}
		}
		return tempMax;
	}

	/**
	 * Permet de récupérer la différence de la plus grande position et la plus petite position parmis les cartes
	 * @param cp1 Carte du joueur
	 * @param cp2 Carte du joueur
	 * @param cf1 Carte du flop
	 * @param cf2 Carte du flop
	 * @param cf3 Carte du flop
	 * @return
	 */
	private int minmaxDiff(Carte cp1, Carte cp2, Carte cf1, Carte cf2, Carte cf3) {
		int tempMin = cp1.valeur.position;
		int tempMax = cp2.valeur.position;
		int[] valeurToTest = {cf1.valeur.position,cf2.valeur.position,cf3.valeur.position};
		for(int i = 0; i<valeurToTest.length;i++) {
			int temp = valeurToTest[i];
			if(temp>tempMax) {
				tempMax = valeurToTest[i];
			}
			if(temp<tempMin) {
				tempMin = valeurToTest[i];
			}
		}
		return tempMax - tempMin;
	}
	
	/**
	 * Permet de récupérer la moyenne de position des cartes
	 * @param cp1 Carte du joueur
	 * @param cp2 Carte du joueur
	 * @param cf1 Carte du flop
	 * @param cf2 Carte du flop
	 * @param cf3 Carte du flop
	 * @return
	 */
	private int moyenne(Carte cp1, Carte cp2, Carte cf1, Carte cf2, Carte cf3) {
		return (cp1.valeur.position+cp2.valeur.position+cf1.valeur.position+cf2.valeur.position+cf3.valeur.position)/5;
	}

	/**
	 * Permet de rattacher la HashMap correspondant à 5 cartes (3du flop et 2 du joueur) à un des cas de main défini detectionLieeValeur(HashMap<Valeur, Integer> valeurMain,Joueur j)
	 * @param hm HashMap<Valeur, Integer>
	 * @return le int correspondant au cas de main
	 */
	private int evaluator(HashMap<Valeur, Integer> hm) {
		int result;
		if(hm.size()>2) {
			result = -hm.size();
		}
		else {
			result = 0;
		}
		int temp = 1;
		for(int v : hm.values()) {
			temp *= v;
		}
		return result+temp;
	}
	
	/**
	 * Liste les différents cas possibles de main et ajoute au Joueur.combinaisons la valeur des combinaisons en possession par le Joueur j
	 * @param valeurMain HashMap<Valeur, Integer>
	 * @param j Joueur
	 */
	private void detectionLieeValeur(HashMap<Valeur, Integer> valeurMain,Joueur j) {
		int evaluation = evaluator(valeurMain);
		switch(evaluation) {
		case 6:
		//Cas du full
			for (HashMap.Entry<Valeur, Integer> entry : valeurMain.entrySet()) {
				Valeur key = entry.getKey();
				int value = entry.getValue();
				switch(value) {
				case 3:
					j.addCombinaison(CombinaisonPossible.Full.valeur + key.position);
					break;
				case 2:
					j.addCombinaison(CombinaisonPossible.Full.valeur + key.position);
					break;
				default:
					System.out.println("erreur dans le cas du full");
					System.out.println(valeurMain);
				}
			}
			break;
		case 4:
		//Cas du carré
			for (HashMap.Entry<Valeur, Integer> entry : valeurMain.entrySet()) {
				Valeur key = entry.getKey();
				int value = entry.getValue();
				switch(value) {
				case 4:
					j.addCombinaison(CombinaisonPossible.Carre.valeur + key.position);
					break;
				case 1:
					j.addCombinaison(CombinaisonPossible.Seule.valeur + key.position);
					break;
				default:
					System.out.println("erreur dans le cas du carré");
					System.out.println(valeurMain);
				}
			}
			break;
		case 1:
		//Cas de la double paire
			for (HashMap.Entry<Valeur, Integer> entry : valeurMain.entrySet()) {
				Valeur key = entry.getKey();
				int value = entry.getValue();
				switch(value) {
				case 2:
					j.addCombinaison(CombinaisonPossible.DoublePaire.valeur + key.position);
					break;
				case 1:
					j.addCombinaison(CombinaisonPossible.Seule.valeur + key.position);
					break;
				default:
					System.out.println("erreur dans le cas de la double paire");
					System.out.println(valeurMain);
				}
			}
			break;
		case 0:
		//Cas du brelan
			for (HashMap.Entry<Valeur, Integer> entry : valeurMain.entrySet()) {
				Valeur key = entry.getKey();
				int value = entry.getValue();
				switch(value) {
				case 3:
					j.addCombinaison(CombinaisonPossible.Brelan.valeur + key.position);
					break;
				case 1:
					j.addCombinaison(CombinaisonPossible.Seule.valeur + key.position);
					break;
				default:
					System.out.println("erreur dans le cas du brelan");
					System.out.println(valeurMain);
				}
			}
			break;
		case -2:
		//Cas de la simple paire
			for (HashMap.Entry<Valeur, Integer> entry : valeurMain.entrySet()) {
				Valeur key = entry.getKey();
				int value = entry.getValue();
				switch(value) {
				case 2:
					j.addCombinaison(CombinaisonPossible.Paire.valeur + key.position);
					break;
				case 1:
					j.addCombinaison(CombinaisonPossible.Seule.valeur + key.position);
					break;
				default:
					System.out.println("erreur dans le cas de la paire");
					System.out.println(valeurMain);
				}
			}
			
			break;
		case -4:
		//Cas où on a rien lié à la valeur
			for (HashMap.Entry<Valeur, Integer> entry : valeurMain.entrySet()) {
				Valeur key = entry.getKey();
				int value = entry.getValue();
				switch(value) {
				case 1:
					j.addCombinaison(CombinaisonPossible.Seule.valeur + key.position);
					break;
				default:
					System.out.println("erreur dans le cas de rien");
					System.out.println(valeurMain);
				}
			}
		}
		
	}
	
	/**
	 * Crée un dictionnaire comptant les cartes par valeur présentes dans la main et la flop combinés
	 * @param c1 Carte
	 * @param c2 Carte
	 * @param c3 Carte
	 * @param c4 Carte
	 * @param c5 Carte
	 * @return Un dictionnaire avec en clé la Valeur et en valeur le nombre d'occurence de cette Valeur
	 */
	public HashMap<Valeur,Integer> memeValeur(Carte c1, Carte c2, Carte c3, Carte c4, Carte c5) {
		Valeur[] valeur = {c1.valeur,c2.valeur,c3.valeur,c4.valeur,c5.valeur};
		HashMap<Valeur,Integer> result =  new HashMap<Valeur,Integer>();
		for(int i = 0; i<Valeur.values().length;i++) {
			int occurence = 0;
			for(int j = 0;j<valeur.length;j++) {
				if(Valeur.values()[i] == valeur[j]) {
					occurence++;
				}
			}
			if(occurence > 0) {
				result.put(Valeur.values()[i],occurence);
			}
		}
		//Sort HashMap by Value
		return result;
		
	}
	/**
	 * Crée un dictionnaire comptant les cartes par famille présentes dans la main et la flop combinés
	 * @param c1 Carte
	 * @param c2 Carte
	 * @param c3 Carte
	 * @param c4 Carte
	 * @param c5 Carte
	 * @return Un dictionnaire avec en clé la Famille et en valeur le nombre d'occurence de cette Famille
	 */
	public HashMap<Famille,Integer> memeFamille(Carte c1, Carte c2, Carte c3, Carte c4, Carte c5) {
		Famille[] famille = {c1.famille,c2.famille,c3.famille,c4.famille,c5.famille};
		HashMap<Famille,Integer> result =  new HashMap<Famille,Integer>();
		for(int i = 0; i<Famille.values().length;i++) {
			int occurence = 0;
			for(int j = 0;j<famille.length;j++) {
				if(Famille.values()[i] == famille[j]) {
					occurence++;
				}
			}
			if(occurence > 0) {
				result.put(Famille.values()[i],occurence);
			}
		}
		//Find a way to sort HashMap by Value
		
		return result;
		
	}
}




