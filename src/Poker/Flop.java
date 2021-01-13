package Poker;

import java.util.ArrayList;
import java.util.List;

public class Flop {
	
	List<Carte> cartes = new ArrayList<Carte>();
	
	public Flop() {
		// TODO Auto-generated constructor stub
	}
	
	public void distribuer(JeuDeCarte jdc) {
		cartes.add(jdc.jeu.get(0));
		jdc.jeu.remove(0);
		
	}
	
}
