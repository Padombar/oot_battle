package oot_battle.ships;

import oot_battle.PositionsAbfrage;

/**
 * Schiff der Länge 3
 * 
 */
public class ShipThree extends Ship {

	private final static int length = 3;
	private String partOneCoords = "";
	private String partTwoCoords = "";
	private String partThreeCoords = "";
	private String boot = " [[3]]";
	private int partDestroyed = 0;
	private boolean shipThreeIsDestroyed = false;
	
	/* Konstruktor mit Endpunkt mensch */
	public ShipThree(String start, String end) {
		super(start, end);
		setPartOne(start);
		setPartThree(end);
	}
	
	
	/* Konstruktor nur mit Startpunkt */
	public ShipThree(String start) {
		super(start, length);
		setPartOne(start);
		setPartThree(generateEnd());
		berechneSchiff();
	}
	
	/** bei jedem Treffer wird der counter um 1 erhöht */
	public void hit() {
		super.hit();
		
		if (this.partDestroyed <= 3) {
			this.partDestroyed++;
		}
		
		if (this.partDestroyed == 3){
			this.shipThreeIsDestroyed = true;
		}

	}
	
	public boolean isDestroyed(){
		super.isDestroyed();
		return this.shipThreeIsDestroyed;
	}
	
	/* Bootsymbol  */
	public String getBoot() {
		return boot;
	}
	
	/* Koordinaten setzen */

	public void setPartOne(String start) {
		this.partOneCoords = start;
	}
	
	public void setPartTwo(String partTwo) {
		this.partTwoCoords = partTwo;
	}
	
	public void setPartThree(String partThree) {
		this.partThreeCoords = partThree;
	}
	
	/* Koordinaten abrufen */
	
	public String getPartOne() {
		return partOneCoords;
	}
	
	public String getPartTwo() {
		return partTwoCoords;
	}
	
	public String getPartThree() {
		return partThreeCoords;
	}
	
	
	
	/** Errechnet die fehlenden Koordinaten zwischen Start- und Endpunkt */
	public void berechneSchiff() {

		char e1 = getPartOne().charAt(0);
		char e2 = getPartOne().charAt(1);

		int yStart = PositionsAbfrage.getY(getPartOne());
		int yEnde = PositionsAbfrage.getY(getPartThree());

		int xStart = PositionsAbfrage.getX(getPartOne());
		int xEnde = PositionsAbfrage.getX(getPartThree());
		
		if (yStart == yEnde) {

			// y - Achsenkoordinate übernehmen
			int i2 = xStart + 1;
								
			int i6 = xStart - 1;
									
			/* Startpunkt x-Achse kleiner als Endpunkt */
			if (xStart < xEnde) {
				setPartTwo(e1 + "" + e2 + "" + yStart + "" + i2);
			}

			/* Startpunkt x-Achse größer als Endepunkt */
			if (xStart > xEnde) {
				setPartTwo(e1 + "" + e2 + "" + yStart + "" + i6);
			}

		} // ~ if (yStart == yEnde)

		xStart = PositionsAbfrage.getY(getPartOne());
		xEnde = PositionsAbfrage.getY(getPartThree());
		
		int x2 = xStart + 1;
						
		/* Startpunkt y-Achse kleiner als der Endpunkt */
		if (xStart < xEnde) {
			setPartTwo(e1 + "" + e2 + "" + x2 + "" + getPartOne().charAt(3));
		}

		int x6 = xStart - 1;
			
		/* Startpunkt y-Achse größer als der Endpunkt */
		if (xStart > xEnde) {
			setPartTwo(e1 + "" + e2 + "" + x6 + "" + getPartOne().charAt(3));
		}

	} // ~berechneSchiff()
	
	
	
	/* Gibt die Koordinaten des Schiffs zurück */
	public ShipThree getShip() {
		return this;
	}
	
	/* automatisch generierter Endpunkt */
	public String generateEnd() {
		return this.calculateEndCoords().getFirst();
	}
	
	public String getEnd() {
		return getPartThree();
	}
	
	
	public String testAusgabe() {
		return getPartOne() + " " + getPartTwo() + " " + getPartThree();
	}
	
	
	
}
