package Poker;
/**
 * 
 * enumère les valeurs présentes dans un jeu de cartes
 *
 */
public enum Valeur {	
	As(13),Deux(1),Trois(2),Quatre(3),Cinq(4),Six(5),Sept(6),Huit(7),Neuf(8),Dix(9),Valet(10),Dame(11),Roi(12);
	
	final int position;
	/**
	 * @param p la valeur de la carte
	 */
	Valeur(int p){
		this.position = p;
	}
}
