package Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JeuDeCarte {
	
	public List<Carte> jeu = new ArrayList<Carte>();
	
	/**
	 * Constructeur du jeu de carte
	 * Crée toutes les cartes à partie des énumérations de familles et valeurs
	 */
	public JeuDeCarte() {
		creationDuJeu();
	}
	
	/**
	 * Mélange le jeu de carte
	 */
	public void melanger() {
		
		Random r = new Random();
		
		List<Carte> jeuMelange = new ArrayList<Carte>();
		
		int initJeuSize = jeu.size();
		
		for(int carteVu = 0; carteVu<initJeuSize;carteVu++) {
			int temp = r.nextInt(jeu.size());
			jeuMelange.add(jeu.get(temp));
			jeu.remove(temp);
		}	
		
		this.jeu = jeuMelange;
		
	}
	
	public void creationDuJeu() {
		
		for(int value = 0; value < Valeur.values().length; value++) {
	         for(int famille = 0; famille < Famille.values().length; famille++) {
	        	 jeu.add(new Carte(Valeur.values()[value],Famille.values()[famille]));
	        	 
	         }
	        
	      }
	}

}
