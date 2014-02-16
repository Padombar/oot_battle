package oot_battle.ships;

import oot_battle.PositionsAbfrage;

public class ShipFour extends Ship {

	private final static int length = 4;
	private String partOneCoords = "";
	private String partTwoCoords = "";
	private String partThreeCoords = "";
	private String partFourCoords = "";
	private String boot = " [[4]]";
	private int partDestroyed = 0;
	private boolean shipFourIsDestroyed = false;

	/* Konstruktor Mensch */
	public ShipFour(String start, String ende) {
		super(start, ende);
		setPartOne(start);
		setPartFour(ende);
	}
	
	/* Konstruktor nur mit Endpunkt */
	public ShipFour(String start){
		super(start, length);
		setPartOne(start);
		setPartFour(generateEnd());
		berechneSchiff();
	}
	
	/* Bootsymbol  */
	public String getBoot() {
		return boot;
	}
	
	/** bei jedem Treffer wird der counter um 1 erhöht */
	public void hit() {
		super.hit();
		if (this.partDestroyed <= 4) {
			this.partDestroyed++;
		}
		
		if (this.partDestroyed == 4){
			this.shipFourIsDestroyed = true;
		}

	}
	
	public boolean isDestroyed(){
		super.isDestroyed()
		;
		return this.shipFourIsDestroyed;
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
	
	public void setPartFour(String partFour) {
		this.partFourCoords = partFour;
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
	
	public String getPartFour() {
		return partFourCoords;
	}
	
			
	/* Länge des Schiffs */
	public int getLength() {
		return length;		
	}
	
	
	/** Errechnet die fehlenden Koordinaten zwischen Start- und Endpunkt */
	public void berechneSchiff() {

		char e1 = getPartOne().charAt(0);
		char e2 = getPartOne().charAt(1);

		int yStart = PositionsAbfrage.getY(getPartOne());
		int yEnde = PositionsAbfrage.getY(getPartFour());

		int xStart = PositionsAbfrage.getX(getPartOne());
		int xEnde = PositionsAbfrage.getX(getPartFour());
		
		if (yStart == yEnde) {

			// y - Achsenkoordinate übernehmen
			int i2 = xStart + 1;
			int i3 = xStart + 2;
						
			int i6 = xStart - 1;
			int i7 = xStart - 2;
						
			/* Startpunkt x-Achse kleiner als Endpunkt */
			if (xStart < xEnde) {
				setPartTwo(e1 + "" + e2 + "" + yStart + "" + i2);
				setPartThree(e1 + "" + e2 + "" + yStart + "" + i3);
			}

			/* Startpunkt x-Achse größer als Endepunkt */
			if (xStart > xEnde) {
				setPartTwo(e1 + "" + e2 + "" + yStart + "" + i6);
				setPartThree(e1 + "" + e2 + "" + yStart + "" + i7);
			}

		} // ~ if (yStart == yEnde)

		xStart = PositionsAbfrage.getY(getPartOne());
		xEnde = PositionsAbfrage.getY(getPartFour());
		
		int x2 = xStart + 1;
		int x3 = xStart + 2;
				
		/* Startpunkt y-Achse kleiner als der Endpunkt */
		if (xStart < xEnde) {
			setPartTwo(e1 + "" + e2 + "" + x2 + "" + getPartOne().charAt(3));
			setPartThree(e1 + "" + e2 + "" + x3 + "" + getPartOne().charAt(3));
		}

		int x6 = xStart - 1;
		int x7 = xStart - 2;
		
		/* Startpunkt y-Achse größer als der Endpunkt */
		if (xStart > xEnde) {
			setPartTwo(e1 + "" + e2 + "" + x6 + "" + getPartOne().charAt(3));
			setPartThree(e1 + "" + e2 + "" + x7 + "" + getPartOne().charAt(3));
		}

	} // ~berechneSchiff()
	
	/* Gibt die Koordinaten des Schiffs zurück */
	public ShipFour getShip() {
		return this;
	}
	
	/* automatisch generierter Endpunkt */
	public String generateEnd() {
		return this.calculateEndCoords().getFirst();
	}
	
	public String getEnd(){
		return getPartFour();
	}
	
	public String testAusgabe() {

		return getPartOne() + " " + getPartTwo() + " " + getPartThree() + " "
				+ getPartFour();

	}
	
	
}
