package oot_battle.ships;

import java.util.Collections;
import java.util.LinkedList;

import oot_battle.PositionsAbfrage;
import oot_battle.ki.HardOpponent;

public abstract class Ship {

	protected int length;
	protected String partOneCoords = "";
	protected String partFiveCoords = "";
	protected boolean shipIsDestroyed;

	LinkedList<String> edgeList = new LinkedList<String>();

	/* Konstruktor */
	public Ship(String start, int length) {
		setPartOne(start);
		setLength(length);
		for (String edge : HardOpponent.edgeFields) {
			edgeList.add(edge);
		}
	}	
	
	//mensch konstruk
	public Ship(String start,String end){
		setPartOne(start);
		setLength(length);
	}
	
	private void setLength(int length) {
		this.length = length;
	}

	private void setPartOne(String start) {
		this.partOneCoords = start;
	}
	
	public String getPartOne() {
		return partOneCoords;
	}
	
	public int getLength() {
		return length;
	}

	/**
	 * Mögliche Endpunkte ermitteln, sind immer innerhalb des Spielfeldes
	 * 
	 * @return Liste mit Endkoordinaten
	 */
	public LinkedList<String> calculateEndCoords() {
		LinkedList<String> endCoords = new LinkedList<String>();
		String position;
		String start = getPartOne();

		// X-Achse nach rechts, muss zwischen 0 und 9 sein
		if (PositionsAbfrage.getX(start) + (this.length - 1) <= 9) {
			int coords = PositionsAbfrage.getX(start) + (this.length - 1);
			position = "" + partOneCoords.charAt(0) + partOneCoords.charAt(1)
					+ start.charAt(2) + coords;
			endCoords.add(position);
		}

		// X-Achse nach links, muss zwischen 0 und 9 sein
		if (PositionsAbfrage.getX(start) - (this.length - 1) >= 0) {
			int coords = PositionsAbfrage.getX(start) - (this.length - 1);
			position = "" + partOneCoords.charAt(0) + partOneCoords.charAt(1)
					+ start.charAt(2) + coords;
			endCoords.add(position);
		}

		// Y-Achse nach unten, muss zwischen 0 und 9 sein)
		if (PositionsAbfrage.getY(start) + (this.length - 1) <= 9) {
			int coords = PositionsAbfrage.getY(start) + (this.length - 1);
			position = "" + partOneCoords.charAt(0) + partOneCoords.charAt(1)
					+ coords + getPartOne().charAt(3);
			endCoords.add(position);
		}

		// Y-Achse nach oben, muss zwischen 0 und 9)
		if (PositionsAbfrage.getY(start) - (this.length - 1) >= 0) {
			int coords = PositionsAbfrage.getY(start) - (this.length - 1);
			position = "" + partOneCoords.charAt(0) + partOneCoords.charAt(1)
					+ coords + getPartOne().charAt(3);
			endCoords.add(position);
		}

		/* Mischen damit der Endpunkt unterschiedlich ist */
		Collections.shuffle(endCoords);
		return endCoords;
	}

	/**
	 * Test auf Randfeld 5er Schiff Koordinaten werden auf Randfelder getestet
	 * 
	 * @return true falls eine der Koordinaten ein Randfeld ist
	 */
	public boolean isShipInEdgeField(ShipFive ship) {
		boolean bool = false;
		if (edgeList.contains(ship.getPartOne())
				|| edgeList.contains(ship.getPartTwo())
				|| edgeList.contains(ship.getPartThree())
				|| edgeList.contains(ship.getPartFour())
				|| edgeList.contains(ship.getPartFive())) {
			bool = true;
		}
		return bool;
	}

	public boolean isShipInEdgeField(ShipFour ship) {
		boolean bool = false;
		if (edgeList.contains(ship.getPartOne())
				|| edgeList.contains(ship.getPartTwo())
				|| edgeList.contains(ship.getPartThree())
				|| edgeList.contains(ship.getPartFour())) {
			bool = true;
		}
		return bool;
	}

	public boolean isShipInEdgeField(ShipThree ship) {
		boolean bool = false;
		if (edgeList.contains(ship.getPartOne())
				|| edgeList.contains(ship.getPartTwo())
				|| edgeList.contains(ship.getPartThree())) {
			bool = true;
		}
		return bool;
	}

	public boolean isShipInEdgeField(ShipTwo ship) {
		boolean bool = false;
		if (edgeList.contains(ship.getPartOne())
				|| edgeList.contains(ship.getPartTwo())) {
			bool = true;
		}
		return bool;
	}

	public boolean isShipInEdgeField(ShipOne ship) {
		boolean bool = false;
		if (edgeList.contains(ship.getPartOne())) {
			bool = true;
		}
		return bool;
	}


	public int getTeilZerstoert() {
		return 1;
		// TODO Auto-generated method stub

	}


	public String getBoot() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getEnd(){
		return null;
	}

	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void hit() {
		// TODO Auto-generated method stub
		
	}

}
