package Poker;

import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		partieClassique();
	}
	
	/**
	 * Créer les objets Joueur associés à l'objet Jeu
	 * @param jeu Un objet de type Jeu
	 * @param n Le nombre de joueur(s)
	 */
	public static void creationDesJoueurs(Jeu jeu, int n) {

		Scanner names = new Scanner(System.in);
		String name;
		for(int i = 0; i<n;i++) {
			System.out.println("Nom du joueur " + (i+1) + ":" );
			name = names.nextLine();
			jeu.newJoueur(name);
		}
		names.close();
		
	}
	
	public static void partieClassique() {
		//Creation du jeu
		Jeu jeu = new Jeu();
		
		//Creation des differents joueurs
		Scanner sc = new Scanner(System.in);
		System.out.println("Nombre de joueurs ? (2 à 5)");
		int n = sc.nextInt();
		creationDesJoueurs(jeu,n);
		
		//Creation du jeu de carte
		JeuDeCarte jdc = new JeuDeCarte();
		//On mélange le jeu de carte
		jdc.melanger();
		
		//On distribue les cartes aux joueurs
		int nombreCarte = 2;
		for(int tourDistrib = 0; tourDistrib<nombreCarte;tourDistrib++) {
			for(int joueur = 0;joueur<jeu.joueurs.size();joueur++) {
				jeu.joueurs.get(joueur).distribuer(jdc);
			}
		}
		
		//On remplit le flop
		Flop flop = new Flop();
		nombreCarte = 3;
		for(int tourDistrib = 0; tourDistrib<nombreCarte; tourDistrib++) {
			flop.distribuer(jdc);
			
		}
		
		//On détecte les combinaisons pour chaque joueur
		Combinaison combinaison = new Combinaison();
		for(Joueur joueur : jeu.joueurs) {
			combinaison.joueurA(flop,joueur);
			joueur.sortCombinaison();
			System.out.println(joueur.name + " :" + joueur.combinaisons);
		}
		
		//On regarde qui gagne
		Joueur gagnant = jeu.quiGagne();
		System.out.println(gagnant.name + " gagne avec " + gagnant.combinaisonstoString(combinaison));
	}
}

