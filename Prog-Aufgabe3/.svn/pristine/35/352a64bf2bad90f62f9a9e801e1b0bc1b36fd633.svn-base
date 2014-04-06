package de.proglabor.aufgabe3.gui;

import de.proglabor.aufgabe3.SimCollections;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

//import de.proglabor.aufgabe3.SimCollections;

/**
 * Stellt die Simulation in einem Fenster dar
 * @author Tobias
 *
 */

public class SimView implements ActionListener, Observer, ComponentListener {
	
	private static final int FUENF = 5;
	private static final int FUENFHUNDERT = 500;
	private static final int NEUNHUNDERT = 900;

	private JFrame frame;

	private JPanel spielfeld;
	private JPanel eingabefeld;
	private JLabel felder [][];

	private GridLayout layoutSpielfeld;
	private BoxLayout layoutControl;
	private BorderLayout frameLayout;

	private JButton btnStartsim;
	private JButton btnDay;
	private JTextField width;
	private JTextField height;
	private JTextField jungleWidth;
	private JTextField jungleHeight;
	private JTextField countDays;
	private JTextArea details;

	private SimCollections model;
	private SimControlerInterface controler;

	private static final Dimension EINGABEDIM = new Dimension(300, 30);

	// Image Part
	private ImageIcon jungle = createImageIcon("/images/jungletex.jpg",
			"Jungle");
	private ImageIcon zombie45 = createImageIcon("/images/zombie_45_45.jpg",
			"Zombie45x45");
	private ImageIcon zombiej45 = createImageIcon("/images/zombie_45_45j.jpg",
			"Zombie45x45");

	private ImageIcon plant45 = createImageIcon("/images/plant_45_45.jpg",
			"Plant45x45");
	private ImageIcon plantj45 = createImageIcon("/images/plant_45_45j.jpg",
			"Plant45x45");

	public SimView(SimCollections modell, SimControlerInterface controlerr) {
		this.controler = controlerr;
		this.model = modell;
		this.model.addObserver(this);
	}

	/**
	 * Initialisiert das Frame, bestehend aus einem Control- und Spielfeld.
	 * @param modell
	 */
	public void init(SimCollections modell) {

		frame = new JFrame("Simulation");

		frameLayout = new BorderLayout(FUENF, FUENF);

		frame.setSize(NEUNHUNDERT, FUENFHUNDERT);
		frame.setLayout(frameLayout);

		// GUI-Komponenten
		spielfeld = new JPanel();
		eingabefeld = new JPanel();

		// eingabefeld.setMinimumSize(dim);

		spielfeld.setVisible(true);
		eingabefeld.setVisible(true);

		layoutSpielfeld = new GridLayout();
		layoutControl = new BoxLayout(eingabefeld, BoxLayout.Y_AXIS);

		eingabefeld.setLayout(layoutControl);
		spielfeld.setLayout(layoutSpielfeld);

		// Erzeugung der Elemente im Eingabepanel

		btnDay = new JButton("Day++");
		btnStartsim = new JButton("Start / Reset");

		countDays = new JTextField("Anzahl der Tage");
		countDays.setToolTipText("Anzahl der Tage welche ausgeführt werden sollen");

		width = new JTextField("Breite");
		height = new JTextField("Höhe");

		height.setToolTipText("Höhe");
		width.setToolTipText("Breite");

		jungleWidth = new JTextField("Jungle Breite");
		jungleHeight = new JTextField("Jungle Höhe");

		jungleHeight.setToolTipText("Jungle Höhe");
		jungleWidth.setToolTipText("Jungle Breite");

		details = new JTextArea(
				"Statistiken zur Simulation \n werden hier angezeigt");
		details.setEditable(false);
		// GrÃ¶ÃŸenbegrenzung der TextFields

		width.setMaximumSize(EINGABEDIM);
		height.setMaximumSize(EINGABEDIM);
		jungleHeight.setMaximumSize(EINGABEDIM);
		jungleWidth.setMaximumSize(EINGABEDIM);
		btnDay.setMaximumSize(EINGABEDIM);
		btnStartsim.setMaximumSize(EINGABEDIM);
		countDays.setMaximumSize(EINGABEDIM);

		// HinzufÃ¼gen und Anordnung der Elemente

		eingabefeld.add(width);
		eingabefeld.add(height);
		eingabefeld.add(jungleHeight);
		eingabefeld.add(jungleWidth);
		eingabefeld.add(btnStartsim);
		eingabefeld.add(countDays);
		eingabefeld.add(btnDay);
		eingabefeld.add(details);

		btnStartsim.addActionListener(this);
		btnDay.addActionListener(this);
		frame.setVisible(true);

		frame.add(eingabefeld, frameLayout.WEST);
		frame.add(spielfeld, frameLayout.CENTER);

		// Exit on Close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	/**.
	 * Generiert das Spielfeld und ersetzt die 
	 * Standartwerte für die Breite und Höhe von Spielfeld und Jungle im Model
	 */
	public void generateFeld() {
		int w = Integer.parseInt(width.getText());
		int h = Integer.parseInt(height.getText());
		int jw = Integer.parseInt(jungleHeight.getText());
		int jh = Integer.parseInt(jungleWidth.getText());

		controler.buildWorld(w, h, jw, jh);
		layoutSpielfeld.setColumns(w);
		layoutSpielfeld.setRows(h);
		felder = new JLabel[w][h];
		for (int x = 0; x < felder.length; x++) {
			for (int y = 0; y < felder[0].length; y++) {

				felder[x][y] = new JLabel();
				felder[x][y].setVisible(true);
				felder[x][y].setBorder(BorderFactory.createEtchedBorder());
				felder[x][y].setToolTipText("Y: " + (y) + " X: " + (x));
				spielfeld.add(felder[x][y]);
			}
		}
		felder[1][1].addComponentListener(this);
	}

	/**.
	 * liefert die Anzahl der Tage welche ausgeführt werden sollen 
	 * und im Textfeld countDays eingetragen wurden
	 * @return int AnzahlTage 
	 */
	public int getCountDays() {
		return Integer.parseInt(countDays.getText());
	}

	/**.
	 * Diese Methode wird ausgeführt sobald im Model 
	 * die Methode run() ausgeführt wurde
	 * @param ..-.- 
	 */
	
	@Override
	public void update(Observable obs, Object arg) {
		System.out.println("Updating View");

		for (int x = 0; x < felder.length; x++) {
			for (int y = 0; y < felder[0].length; y++) {
				felder[x][y].setBackground(Color.WHITE);
				felder[x][y].setIcon(null);

				if (model.getFeldTyp(x, y)) {
					felder[x][y].setIcon(jungle);
				}

				if (model.getAnzahlPflanzen(x, y) > 0 && model.getFeldTyp(x, y)) {
					felder[x][y].setIcon(plantj45);
				} else if (model.getAnzahlPflanzen(x, y) > 0) {
					felder[x][y].setIcon(plant45);
				}
				if (model.getAnzahlTiere(x, y) > 0 && model.getFeldTyp(x, y)) {
					felder[x][y].setIcon(zombiej45);
				} else if (model.getAnzahlTiere(x, y) > 0) {
					felder[x][y].setIcon(zombie45);
				}
				felder[x][y].setToolTipText("Pflanzen: "
						+ model.getAnzahlPflanzen(x, y) + "      Tiere: "
						+ model.getAnzahlTiere(x, y));
			}
		}
		details.setText(" ");
		details.append("Details:\n");
		details.append("Anzahl der Tiere: " + model.getAnzahlTiereAll() + "\n");
		details.append("Anzahl der Pflanzen: " + model.getAnzahlPflanzenAll()
				+ "\n");
	}

	/**.
	 * Enthält die Aktionen welche bei einem Buttonklick ausgeführt werden sollen
	 * 
	 * btnStartsim:
	 * generiert das Spielfeld mit den eingegebenen Werten und setzt Jungletexturen
	 * 
	 * btnDay:
	 * Führt die eingegebene Anzahl an Tagen durch
	 */
	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource().equals(btnStartsim)) {
			if (!controler.getRunning()) {
				generateFeld();
				for (int x = 0; x < model.getWIDTH(); x++) {
					for (int y = 0; y < model.getHEIGHT(); y++) {
						if (model.getFeldTyp(x, y)) {
							felder[x][y].setIcon(jungle);
						}
					}
				}
				frame.repaint();
				controler.setRUNNING(true);
			} else {
				// Feld Clearen
				for (int x = 0; x < felder.length; x++) {
					for (int y = 0; y < felder[0].length; y++) {
						spielfeld.remove(felder[x][y]);
						controler.setRUNNING(false);
					}
				}
				frame.repaint();
			}
		}

		if (event.getSource().equals(btnDay)) {
			try {
				controler.run(this.getCountDays());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**.
	 * Resized die Images auf die passende JLabel größe
	 */
	@Override
	public void componentResized(ComponentEvent e) {

		zombie45 = createImageIcon("/images/zombie_45_45.jpg", "Zombie45x45");
		zombiej45 = createImageIcon("/images/zombie_45_45j.jpg", "Zombie45x45");

		plant45 = createImageIcon("/images/plant_45_45.jpg", "Plant45x45");
		plantj45 = createImageIcon("/images/plant_45_45j.jpg", "Plant45x45");

		// resize Images
		plantj45.setImage(plantj45.getImage().getScaledInstance(
				felder[1][1].getWidth(), felder[1][1].getHeight(),
				Image.SCALE_SMOOTH));
		plant45.setImage(plant45.getImage().getScaledInstance(
				felder[1][1].getWidth(), felder[1][1].getHeight(),
				Image.SCALE_SMOOTH));
		zombiej45.setImage(zombiej45.getImage().getScaledInstance(
				felder[1][1].getWidth(), felder[1][1].getHeight(),
				Image.SCALE_SMOOTH));
		zombie45.setImage(zombie45.getImage().getScaledInstance(
				felder[1][1].getWidth(), felder[1][1].getHeight(),
				Image.SCALE_SMOOTH));
	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentShown(ComponentEvent e) {

	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}

	// Texture Loader
	/** 
	 * Returns an ImageIcon, or null if the path was invalid.
	 */
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
