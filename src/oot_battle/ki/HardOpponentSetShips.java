package oot_battle.ki;

import java.util.HashMap;
import oot_battle.ships.Ship;
import oot_battle.ships.ShipFive;
import oot_battle.ships.ShipFour;
import oot_battle.ships.ShipOne;
import oot_battle.ships.ShipThree;
import oot_battle.ships.ShipTwo;

public class HardOpponentSetShips {

	public HashMap<String, Ship> shipMapPlayerOne = new HashMap<String, Ship>();
	
	/* Konstruktor */
	public HardOpponentSetShips() {
		addAllShipsLevelTwo();
		addAllShipsLevelThree();
		addAllShipsLevelOne();
		
	}
	
	public static void main(String[] args) {
		HardOpponentSetShips producer = new HardOpponentSetShips();
		
		System.out.println(producer.shipMapPlayerOne.keySet());
		
	}
	

	
	/**Die erstellte Liste an Battlefield weiterreichen */
	public HashMap<String, Ship> getHardOpponentMap() {
		return shipMapPlayerOne;
	}
	
		/**
	 * 4 Schiffe für Ebene 2 erstellen, Koordinaten überprüfen, dürfen sich
	 * nicht überdecken
	 */
	public void addAllShipsLevelTwo() {

		while (shipMapPlayerOne.size() < 12) {
			/* 3er Schiff für Ebene 2 erstellen und in die Map schreiben */
			ShipThree s = new ShipThree(
					new HardOpponent().calculateStartCoordsLevelTwo());
			
			/* überprüfen ob es ein Randfeld ist */
			while (s.isShipInEdgeField(s) == true) {
				s = new ShipThree(
						new HardOpponent().calculateStartCoordsLevelTwo());
			} 	
			
			if (!shipMapPlayerOne.containsKey(s.getPartOne())
					&& !shipMapPlayerOne.containsKey(s.getPartTwo())
					&& !shipMapPlayerOne.containsKey(s.getPartThree())) {
				shipMapPlayerOne.put(s.getPartOne(), s);
				shipMapPlayerOne.put(s.getPartTwo(), s);
				shipMapPlayerOne.put(s.getPartThree(), s);
			}			
		}
	}

	/**
	 * 4 Schiffe für Ebene 3 erstellen, Koordinaten überprüfen, dürfen sich
	 * nicht überdecken
	 */
	public void addAllShipsLevelThree() {

		while (shipMapPlayerOne.size() < 24) {
			/* 3er Schiff für Ebene 3 erstellen und in die Map schreiben */
			ShipThree s = new ShipThree(
					new HardOpponent().calculateStartCoordsLevelThree());
			
			/* überprüfen ob es ein Randfeld ist */
			while (s.isShipInEdgeField(s) == true) {
				s = new ShipThree(
						new HardOpponent().calculateStartCoordsLevelThree());
			} 				
			
			if (!shipMapPlayerOne.containsKey(s.getPartOne())
					&& !shipMapPlayerOne.containsKey(s.getPartTwo())
					&& !shipMapPlayerOne.containsKey(s.getPartThree())) {
				shipMapPlayerOne.put(s.getPartOne(), s);
				shipMapPlayerOne.put(s.getPartTwo(), s);
				shipMapPlayerOne.put(s.getPartThree(), s);
			}
		}
	}

	/** Alle Schiffe der Ebene 1 erstellen und zur Map hinzufügen */
	public void addAllShipsLevelOne() {
		addShipOneLevelOne();
		addShipTwoLevelOne();
		addShipFourLevelOne();
		addShipFiveLevelOne();
	}

	/** 1er Schiff für Ebene 1 erstellen und in die Map schreiben */
	public void addShipOneLevelOne() {
		while (shipMapPlayerOne.size() < 25) {

			ShipOne s = new ShipOne(
					new HardOpponent().calculateStartCoordsLevelOne());
			
			/* überprüfen ob es ein Randfeld ist */
			while (s.isShipInEdgeField(s) == true) {
				s = new ShipOne(
						new HardOpponent().calculateStartCoordsLevelOne());
			} 	
			
				if (!shipMapPlayerOne.containsKey(s.getPartOne())) {
					shipMapPlayerOne.put(s.getPartOne(), s);
				}
			
		}
	}

	/** 2er Schiff für Ebene 1 erstellen und in die Map schreiben */
	public void addShipTwoLevelOne() {
		while (shipMapPlayerOne.size() < 27) {

			ShipTwo s = new ShipTwo(
					new HardOpponent().calculateStartCoordsLevelOne());

			/* überprüfen ob es ein Randfeld ist */
			while (s.isShipInEdgeField(s) == true) {
				s = new ShipTwo(
						new HardOpponent().calculateStartCoordsLevelOne());
			} 	
				if (!shipMapPlayerOne.containsKey(s.getPartOne())
						&& !shipMapPlayerOne.containsKey(s.getPartTwo())) {
					shipMapPlayerOne.put(s.getPartOne(), s);
					shipMapPlayerOne.put(s.getPartTwo(), s);
				
			} 
		}
	}

	/** 4er Schiff für Ebene 1 erstellen und in die Map schreiben */
	public void addShipFourLevelOne() {

		while (shipMapPlayerOne.size() < 31) {
			/* 4er Schiff für Ebene 1 erstellen und in die Map schreiben */
			ShipFour s = new ShipFour(
					new HardOpponent().calculateStartCoordsLevelOne());

			/* überprüfen ob es ein Randfeld ist */
			while (s.isShipInEdgeField(s) == true) {
				s = new ShipFour(
						new HardOpponent().calculateStartCoordsLevelOne());
			} 	
			
				if (!shipMapPlayerOne.containsKey(s.getPartOne())
						&& !shipMapPlayerOne.containsKey(s.getPartTwo())
						&& !shipMapPlayerOne.containsKey(s.getPartThree())
						&& !shipMapPlayerOne.containsKey(s.getPartFour())) {
					shipMapPlayerOne.put(s.getPartOne(), s);
					shipMapPlayerOne.put(s.getPartTwo(), s);
					shipMapPlayerOne.put(s.getPartThree(), s);
					shipMapPlayerOne.put(s.getPartFour(), s);
				}
			
		}
	}

	/** 5er Schiff für Ebene 1 erstellen und in die Map schreiben */
	public void addShipFiveLevelOne() {

		while (shipMapPlayerOne.size() < 36) {
			/* 5er Schiff für Ebene 1 erstellen und in die Map schreiben */
			ShipFive s = new ShipFive(
					new HardOpponent().calculateStartCoordsLevelOne());

			
			/* überprüfen ob es ein Randfeld ist */
			while (s.isShipInEdgeField(s) == true) {
				s = new ShipFive(
						new HardOpponent().calculateStartCoordsLevelOne());
			} 			
			if (!shipMapPlayerOne.containsKey(s.getPartOne())
						&& !shipMapPlayerOne.containsKey(s.getPartTwo())
						&& !shipMapPlayerOne.containsKey(s.getPartThree())
						&& !shipMapPlayerOne.containsKey(s.getPartFour())
						&& !shipMapPlayerOne.containsKey(s.getPartFive())) {
					shipMapPlayerOne.put(s.getPartOne(), s);
					shipMapPlayerOne.put(s.getPartTwo(), s);
					shipMapPlayerOne.put(s.getPartThree(), s);
					shipMapPlayerOne.put(s.getPartFour(), s);
					shipMapPlayerOne.put(s.getPartFive(), s);
				}
		
			} 
		
	}

}
