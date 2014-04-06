
package de.proglabor.aufgabe3;


public interface TierInterface{
/**.
 * Mutiert das Tier
 * @param Zufallswerte f�r GENE und MUTATION
 */
void mutate(int randomGene, int randomMutation);
/**.
 * liefert die Richtung
 * @return int Direction
 */
int getDir();
/**.
 * liefert die Gene
 * @return int[] liefert Gene in einem Array
 */
int[] getGenes();
/**.
 * liefert die Energy
 * @return Energie
 */
int getEnergy();
/**.
 * liefert die Lebenszeit
 * @return Tage welche es �berlebt hat
 */
int getLifetime();
/**.
 * @return X-Koordinate
 */
int getX();
/**.
 * 
 * @return Y-Koordinate
 */
int getY();
/**.
 * dreht das Tier
 * @param randomDirection
 */
void turn(int randomDirection);
/**.
 * setzt zufallszahl
 */
void randomGenes();
/**.
 * setzt Gene Array
 * @param genes
 */
void setGenes(int[] genes);
/**.
 * setzt Position
 * @param x
 * @param y
 */
void setPosition(int x, int y);
/**.
 * Bewegt das Tier
 * @param height
 * @param width
 */
void move(int height, int width);
/**.
 * l�sst das Tier essen
 * @param plantEnergy
 */
void eat(int plantEnergy);
TierInterface reproduce(int randomGene, int randomMutation);
// public Tier reproduce();
String toString();

}
