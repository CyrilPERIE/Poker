package Poker;
/**
 * 
 * enumère les valeurs présentes dans un jeu de cartes
 *
 */
public enum Valeur {	
	As(1),Deux(2),Trois(3),Quatre(4),Cinq(5),Six(6),Sept(7),Huit(8),Neuf(9),Dix(10),Valet(11),Dame(12),Roi(13);
	
	final int position;
	
	Valeur(int p){
		this.position = p;
	}
}
