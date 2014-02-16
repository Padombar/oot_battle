package oot_battle.ships;

/**
 * Schiff der Länge 2 
 * 
 */
public class ShipTwo extends Ship {

	private final static int length = 2;
	private String partOneCoords = "";
	private String partTwoCoords = "";
	private String boot = " [[2]]";
	private int partDestroyed = 0;
	private boolean shipTwoIsDestroyed = false;
	
	/* Konstruktor nur mit Startpunkt */
	public ShipTwo(String start) {
		super(start, length);
		setPartOne(start);
		setPartTwo(generateEnd());
	}
	
	/* KonstruktorMensch */
	public ShipTwo(String start, String end) {
		super(start, end);
		setPartOne(start);
		setPartTwo(end);
	}
	
	/** bei jedem Treffer wird der counter um 1 erhöht */
	public void hit() {
		super.hit();
		
		if (this.partDestroyed <= 2) {
			this.partDestroyed++;
		}
		
		if (this.partDestroyed == 2){
			this.shipTwoIsDestroyed = true;
		}

	}
	
	public boolean isDestroyed(){
		super.isDestroyed();
		return this.shipTwoIsDestroyed;
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
	
	/* Koordinaten abufen */
	
	public String getPartOne() {
		return partOneCoords;
	}
	
	public String getPartTwo() {
		return partTwoCoords;
	}
	
		
	
	
	public int getLength() {
		return length;		
	}

	
	/* Gibt die Koordinaten des Schiffs zurück */
	public ShipTwo getShip() {
		return this;
	}
	
	/* automatisch generierter Endpunkt */
	public String generateEnd() {
		return this.calculateEndCoords().getFirst();
	}
	
	public String getEnd() {
		return getPartTwo();
	}
	
}