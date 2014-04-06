package online.aufgaben.Vererbung;

public class Fahrzeug {
    private int gewicht = 1337;
	
    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public void fahren() {
        System.out.println("Fahrzeug");
    }
}