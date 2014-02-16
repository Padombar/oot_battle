package oot_battle.ships;

public class ShipOne extends Ship {

	private final static int length = 1;
	private String partOneCoords = "";
	private String boot = " [[1]]";
	private int partDestroyed = 0;
	private boolean shipOneIsDestroyed = false;
	
	/* Konstruktor */
	public ShipOne(String start) {
		super(start, length);
		setPartOne(start);
	}
	
	
	/* Konstruktor Mensch*/
	public ShipOne(String start,String end) {
		super(start, end);
		setPartOne(start);
	}
	
	/** bei jedem Treffer wird der counter um 1 erhöht */
	public void hit() {
		super.hit();
		if (this.partDestroyed <= 1) {
			this.partDestroyed++;
		}
		
		if (this.partDestroyed == 1){
			this.shipOneIsDestroyed = true;
		}

	}
	
	public boolean isDestroyed(){
		super.isDestroyed();
		return this.shipOneIsDestroyed;
	}
	
	/* Bootsymbol  */
	public String getBoot() {
		return boot;
	}
	
	/* Koordinaten setzen */

	public void setPartOne(String start) {
		this.partOneCoords = start;
	}
	
	/* Koordinaten abrufen */
	
	public String getPartOne() {
		return partOneCoords;
	}
	
	
		
	/* Länge des Schiffs */
	public int getLength() {
		return length;		
	}
	
	public String getEnd(){
		return getPartOne();
	}
	
	
	/* Gibt die Koordinaten des Schiffs zurück */
	public ShipOne getShip() {
		return this;
	}
	
}
