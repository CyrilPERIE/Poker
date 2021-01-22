<!-- INTRO -->
<p align="center">
  <img src="https://www.francestickers.com/2609-thickbox/jetons-de-poker-.jpg" alt="Logo" width="80" height="80">

  <h3 align="center">Poker</h3>

  <p align="center">
    The goal is to create a game of Poker, distribute the cards to the players and the flop, evaluate the winner.
    <br />
    Without the constraints of the bets.
    <br />
    <a href="https://github.com/CyrilPERIE/Poker/tree/main/src/Poker"><strong>Explore the src »</strong></a>
    <br />
  </p>
</p>

<!-- TABLE OF CONTENT -->
<details open="open">
  <summary>Table of content</summary><ol>
  <li>UML Diagramm
  <ul>
    <li><a href="#diagramm">Diagramm</a></li>
    <li><a href="#functions-explanation">Functions explanation</a></li>
  </ul>
  </li>
  <li>Thinking
  <ul>
    <li><a href="#index-of-combination">Index of Combination</a></li>
    <li><a href="#poker-cards-combos">Poker card combos</a></li>
    <li><a href="#combo-detection-based-on-card-value">Combos detection based on card value</a></li>
    <li><a href="#in-practice">In practice</a></li>
    <li><a href="#other-type-of-combo-detection">Other type of combo dectection</a></li>
    <li><a href="#winner-detection">Winner detection</a></li>
  </ul>
  </li>
</ol></details>

<!-- UML DIAGRAMM -->
## UML Diagramm

### Diagramm

<br />Here is the UML Diagramm used to modelise the problem.<br/>

![UML diagramm][UMLDIAGRAMM]

### Functions explanation 

<!-- FUNCTIONS USED -->
<details close="close">
  <summary>A simple explanation of each function : </summary>
  <ol>
 - Jeu.quiGagne() return the player who win the set, it calls Joueur.indexGagnant and Joueur.maxCol to help it. <br /><br />
 - Jeu.indexGagnant(int) return the index of the player that won the set, Jeu.combinaisonsJoueurs is a jagged Array that's why we send as a parameter its maximum length 
to make the function scan all the array. <br /><br />
 - Jeu.columnToList(int i) convert the i-th column of Jeu.combinaisonsJoueurs as a List of integers. <br /><br />
 - Jeu.maxCol() return the max index of column of Jeu.combinaisonsJoueurs. <br /><br />
 - Jeu.creationCombinaisonsJoueurs add all players combos in Jeu.combinaisonsJoueurs it-h row corresponds to i-th player in Jeu.joueurs. <br /><br />
 - Joueur.distribuer(JeuDeCarte) give 2 cards from JeuDeCarte.jeu to Joueur.cartes. <br /><br />
 - Joueur.addCombinaison(int) Combinaison.joueurA call this function to add the combo point to the player's combo list named Joueur.combinaisons. <br /><br />
 - Joueur.sortCombinaison() sort Joueur.combinaisons from highest value to lowest value. <br /><br />
 - Flop.distribuer(JeuDeCarte) give 3 cards from JeuDeCarte.jeu to Flop.cartes. <br /><br />
 - JeuDeCarte.creationDuJeu() create JeuDeCarte.jeu which is a card game made of 52 cards from 2 to Ace with 4 families. <br /><br />
 - JeuDeCarte.melanger() shuffle JeuDeCarte.jeu. <br /><br />
 - Combinaison.joueurA(Flop,Joueur) based on Flop.cartes and Joueur.cartes add the combos made with theses 5 cards to Joueur.combinaisons with the help of Joueur.addCombinaison(int).<br /> 
It can detect straight flush(royal or not), colors and suite, it also calls Combinaison.detectionLieeValeur(HashMap<Valeur, Integer>). <br /><br />
 - Combinaison.max(List<Carte>) return the max Carte.valeur.position from the list of Carte objects. <br /><br />
 - Combinaison.minmaxDiff(List<Carte>) return the difference between the highest Carte.valeur.position and lowest Carte.valeur.position from the list of Carte objects. <br /><br /> 
 - Combinaison.evaluator(HashMap<Valeur, Integer>) return the scenario of hand hold by the player based on a calculation explained below. <br /><br />
 - Combinaison.detectionLieeValeur(HashMap<Valeur, Integer>) handle the detection of combos based on card's value. <br /><br />
 - Combinaison.memeValeur(List<Carte>) return a hashmap that holds occurences of Carte.valeur by valeur. <br /><br />
 - Combinaison.memeFamille(List<Carte>) return a hashmap that holds occurences of Carte.famille by famille. <br /><br />
  </ol>
</details>


You can find the Javadoc here : [JAVADOC] 

<!-- THINKING -->
## Thinking

### Index of combination

CombinaisonPossible.valeur and Valeur.position help making this index. Using this kind of index will help with the combo valorisation and to compare the differents hand's combo. <br />
| | Deux(1) | Trois(2) | Quatre(3) | Cinq(4) | Six(5) | Sept(6) | Huit(7) | Neuf(8) | Dix(9) | Jack(10) | Queen(11) | King(12) | Ace(13) |
| :---:  | :---:  | :---:  | :---:  | :---:  | :---:  | :---:  | :---:  | :---:  | :---:  | :---:  | :---:  | :---:  | :---:  |
| Alone(0)|1|2|3|4|5|6|7|8|9|10|11|12|13|
| One pair(14) |15|16|17|18|19|20|21|22|23|24|25|26|27|
| Two pairs(28) |29|30|31|32|33|34|35|36|37|38|39|40|41|
| Three of a kind(42)|43|44|45|46|47|48|49|50|51|52|53|54|55|
| Straight(56) |57|58|59|60|61|62|63|64|65|66|67|68|69|
| Flush(70) |71|72|73|74|75|76|77|78|79|80|81|82|
| Full Hourse(84) |85|86|87|88|89|90|91|92|93|94|95|96|97|
| Four of a kind(98) |99|100|101|102|103|104|105|106|107|108|109|110|111|
| Straight Flush(112) |113|114|115|116|117|118|119|120|121|122|123|124|125|

Royal Flush has a value of 126 by default, there is only one kind of Royal Flush.<br /><br />
<b>For example : </b> player1 has a pair of two and player2 has a pair of 3. Because 16 is greater than 15, player 2 will win.<br />
### Poker cards combos
Here are the different combos that a player can have : <br />
| Combo | Based on card family | Based on card value | Based on both |Cards used for the combo|
| :---:  | :---:  | :---:  | :---:  | :---: |
| One pair ||X||2|
| Two pairs ||X||4|
| Three of a kind||X||3|
| Straight |||X|5|
| Flush |X|||5|
| Full Hourse ||X||5|
| Four of a kind ||X||4|
| Straight Flush |||X|5|
| Royal Flush |||X|5|

The programm will first test if a combo based on card value is hold by the player. <br />
If the player hold one of this type of combo, he can't hold any more combo, 2 cards in player's hands and 3 in flop. <br /> 
That's what we will test first. <br />

### Combo detection based on card value
Using HashMap we can count the occurences of each value by value <br />
Here are the different possibilities : <br />
1 1 1 1 1 -- No combo based on value, but other types of combos are all possible <br />
2 1 1 1   -- One pair <br />
2 2 1     -- Two pairs <br />
3 1 1     -- Three of a kind <br />
3 2       -- Full House <br />
4 1       -- Four of a kind <br />


<b>For example : </b> if the player has a 2 and a 5, and the flop holds 2, 5 and King then it's a 2 2 1

### In practice

<b>That was theorical, but how to know in which case the player is ?</b><br />
For this we will create a case for each possibility base on a calculation: the product of each occurence from wich we substract the lenght of the HashMap of occurences, if this one is strictly superior to 2. That gives us these differents cases values : 
|Combo|Case| 
| :---  | :---: |
| No combo |-4|
| One pair |-2|
| Two pairs |1|
| Three of a kind |0|
| Full House |6|
| Four of a kind |4|

<b> For example : </b> We still have our 2 2 1 combo, (2 * 2 * 1)-3=1 then our programm knows it's a double pair we just have to detect our pairs and assign the values from the 
combos index in Joueur.combinaison<br />
The Joueur.combinaisons of this player will looks like this [33,29,12]

### Other type of combo detection

We will create another HashMap but this one is counting occurences by family. <br /><br />
<b>If the length of this HashMap is greater than 1</b>, then there is more than one family and we can exclude Flush,Straight Flush and Royal Flush. <br />
Only the straight remains in this case.<br />
That's where we use Combinaison.minmaxDiff(List<Carte>), if the return statement is 4 then we have a straight and we assign the value to Joueur.combinaisons else we only have odds and we assign Carte.position of each cards to the players combination list.<br /><br />
<b>If the length of the HashMap is equals to 1</b>, then we have a Flush the programm will seek if there is a straight Flush or a royal Flush. <br />
That's where we use Combinaison.minmaxDiff(List<Carte>), if the return statement is 4 then we have a straight Flush at least.
We now use Combinaison.max(List<Carte>), if the result is 13 we are facing a royal Fulsh.


### Winner Detection

If the 4 players are playing against each others we can have this kind of Jeu.combinaisonsJoueurs.<br />
||||||| 
| :---: | :---: | :---: | :---: | :---: | :---: |
|Alfred|8|7|5|4|1|
|Moussa|15|12|7|4||
|Colinne|12|9|7|4|1|
|Ben|15|13|7|4||

It's called a jagged Array, each row doesn't have the same length. <br />
We just have to scan from left to right until we find the winner. If no winner is find, then it's a draw.<br />
The first step eliminate Fred and Colinne. At this state onle Moussa and Ben can win the game. <br />
At the second step of the scan Ben is declared the winner ! <br /><br />

<p align="center">
<b>Thanks for reading !</b><br/>
  <a href="#poker">
    <img src="https://image.freepik.com/icones-gratuites/fleche-vers-haut-epaisseur_318-8345.jpg" alt="Logo" width="40" height="40">
  </a>
</p>

<!-- LINKS -->
[UMLDIAGRAMM]: images/UML.PNG
[JAVADOC]: doc/index.html
