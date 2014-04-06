package de.proglabor.aufgabe3.gui;

import java.io.IOException;

/**
 * Controler Interface
 * Created by Tobias on 10.12.13.
 */
public interface SimControlerInterface {
void run(int daysToDo) throws IOException, InterruptedException;
void setRUNNING(boolean b);
boolean getRunning();
public void buildWorld(int w, int h, int jungleW, int jungleH);

}
