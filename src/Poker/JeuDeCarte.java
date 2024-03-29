package Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 
 *Cette classe permet de cr�er les objets de type JeuDeCarte utiles � jouer au Jeu
 */
public class JeuDeCarte {
	
	/**
	 * La liste contenant le paquet de cartes
	 */
	public List<Carte> jeu = new ArrayList<Carte>();
	
	/**
	 * Constructeur du jeu de carte
	 * Cr�e toutes les cartes � partie des �num�rations de familles et valeurs
	 */
	public JeuDeCarte() {
		creationDuJeu();
	}
	
	/**
	 * M�lange le jeu de carte
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
	
	/**
	 * Instancie le jeu de cartes, c'est un jeu de 52 cartes avec 4 familles et des valeurs allant de 2 � l'as
	 */
	public void creationDuJeu() {
		
		for(int value = 0; value < Valeur.values().length; value++) {
	         for(int famille = 0; famille < Famille.values().length; famille++) {
	        	 jeu.add(new Carte(Valeur.values()[value],Famille.values()[famille]));
	        	 
	         }
	        
	      }
	}

}
