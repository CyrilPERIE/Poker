package Poker;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
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
		
		/*
		Set carteDist = new HashSet(jdc.jeu);
		System.out.println(carteDist.size() + " cartes distinctes" + jdc.jeu);
		*/
		jdc.melanger();
		/*
		carteDist.clear();
		carteDist.addAll(jdc.jeu);
		System.out.println(carteDist.size() + " cartes distinctes" + jdc.jeu);
		*/
		
		//On distribue
		
		int nombreCarte = 2;
		for(int tourDistrib = 0; tourDistrib<nombreCarte;tourDistrib++) {
			for(int joueur = 0;joueur<jeu.joueurs.size();joueur++) {
				jeu.joueurs.get(joueur).distribuer(jdc);
			}
		}
		
		//On remplit le flop
		Flop flop = new Flop();
		nombreCarte = 5;
		for(int tourDistrib = 0; tourDistrib<nombreCarte; tourDistrib++) {
			flop.distribuer(jdc);
			
		}
		
		Joueur test = jeu.joueurs.get(0);
		Combinaison combinaison = new Combinaison();

		combinaison.joueurA(flop,test,test.cartes);
		System.out.println("carte du flop "+flop.cartes);
		System.out.println("carte de " + test.name + " " + jeu.joueurs.get(0).cartes);
		System.out.println("familles " + test.familles);
		System.out.println("valeurs " + test.valeurs);
		
		/* Boucle de jeu à mettre en place quand on s'intéressera aux mises
		do {
			
		}while(jeu.joueurs.size()>1);
		 */
		
	}
	
	
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
}

	