package Poker;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * G�n�re le Flop de la Partie
 *
 */
public class Flop {
	
	List<Carte> cartes = new ArrayList<Carte>();
	
	public Flop() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Permet la transaction d'un carte de jdc � this.flop
	 * @param jdc Un objet de type JeuDeCarte
	 */
	
	public void distribuer(JeuDeCarte jdc) {
		cartes.add(jdc.jeu.get(0));
		jdc.jeu.remove(0);
		
	}
	
}
