package de.proglabor.aufgabe3;

import java.util.LinkedList;
import java.util.TreeMap;

public interface SimCollectionsInterface {
/**.
 * Ablauf eines Tages
 */
void day();
/**
 * Ablauf eines Tages mit Zufallswerten.
 * @param randomDirection Zufallsrichtung
 * @param randomReproduceGene
 * @param randomReproduceMutation
 */
void day(int randomDirection, int randomReproduceGene, int randomReproduceMutation);
/**
 * @param x,y XY-Koordinaten
 * @return Anzahl der Tiere auf dem Feld
 */
int getAnzahlTiere(int x, int y);
/**.
 * Gibt alle Tiere aus
 * @return Anzahl Tiere
 */
int getAnzahlTiereAll();
/**.
 * @param x,y XY-Koordinaten
 * @return Anzahl der Tiere auf dem Feld
 */
int getAnzahlPflanzen(int x, int y);
/**.
 * Gibt alle Pflanzen aus
 * @return Anzahl Pflanzen
 */
int getAnzahlPflanzenAll();
/**.
 * @return LinkedList aller Tiere
 */
abstract LinkedList<TierInterface> getTiere();
/**.
 * 
 * @return TreeMap aller Plfanzen
 */
abstract TreeMap<Pflanze, Integer> getPflanzen();
/**.
 * Setzt neues Tier
 * @param Tier welches gesetzt wird
 */
void setTier(Tier neuesTier);
String toString();
}
