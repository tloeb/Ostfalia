package online.aufgaben.Vererbung;

public class Lastkraftwagen extends Fahrzeug  {
    private int ladekraft = 42;
	
    public int getLadekraft() {
        return ladekraft;
    }

    public void setLadekraft(int ladekraft) {
        this.ladekraft = ladekraft;
    }

    public void beladen() {
        System.out.println("Lastkraftwagen");
    }
}
