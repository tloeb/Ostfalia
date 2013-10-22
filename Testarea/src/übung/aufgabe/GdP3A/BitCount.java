package übung.aufgabe.GdP3A;

public class BitCount {

	private int anyint;
	private int bitanzahl = 0;

	public BitCount(int i) {
		this.anyint = i;
	}

	public String getBits() {

		// Herausfinden wie viele Stellen benötigt werden
		int count = 1;

		int tempresult = 1;
		int rest = anyint;

		do {
			tempresult = (int) Math.pow(2, (double) count);
			count++;
		} while (anyint > tempresult);

		// Die Dualzahl wird in ein Array geschrieben
		String dual = "";

		// Einsen finden
		for (int i = count; i > 0; i--) {
			int val = (int) Math.pow(2, i - 1);
			if (val <= rest) {
				rest = rest - val;
				bitanzahl++;
				dual += '1'; // Einsen in das Array schreiben, -1 da der Index
								// von 0-3 geht
			} else
				dual += '0';
		
		}

		return dual;
	}
	
	public int toInt(String s){
		int out = 00;
		
		
		
		return out;
		
	}


	public int getBitanzahl() {
		return this.bitanzahl;
	}
}
