package Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JeuDeCarte {
	
	public List<Carte> jeu = new ArrayList<Carte>();
	
	public JeuDeCarte() {
		for(int v = 0; v < Valeur.values().length; v++)
	      {
	         for(int f = 0; f < Famille.values().length; f++)
	         {
	        	 jeu.add(new Carte(Valeur.values()[v],Famille.values()[f]));
	        	 
	         }
	        
	      }
	}
	
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

}
