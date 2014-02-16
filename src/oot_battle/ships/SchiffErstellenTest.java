package oot_battle.ships;

import java.util.Random;

import oot_battle.PositionsAbfrage;
import oot_battle.ki.HardOpponent;

public class SchiffErstellenTest {

	private static String LastHit;
	private static String FirstHit;
	
	public static void main(String[] args) {
		
		ShipFive s5 = new ShipFive("E111");		
		System.out.println("Schiff(5er) - Start: " + s5.getPartOne() + "   Ende: " + s5.getPartFive() + "    Alle: " + s5.testAusgabe());
		
		ShipFive s6 = new ShipFive("E215");		
		System.out.println("Schiff(5er) - Start: " + s6.getPartOne() + "   Ende: " + s6.getPartFive() + "    Alle: " + s6.testAusgabe());
		
		ShipFive s7 = new ShipFive("E356");		
		System.out.println("Schiff(5er) - Start: " + s7.getPartOne() + "   Ende: " + s7.getPartFive() + "    Alle: " + s7.testAusgabe());

		ShipFive s8 = new ShipFive("E196");
		System.out.println("Schiff(5er) - Start: " + s8.getPartOne() + "   Ende: " + s8.getPartFive() + "    Alle: " + s8.testAusgabe());
		
		ShipFour s4 = new ShipFour("E111");		
		System.out.println("Schiff(4er) - Start: " + s4.getPartOne() + "   Ende: " + s4.getPartFour() + "    Alle: " + s4.testAusgabe());
				
		ShipThree s3 = new ShipThree("E176");
		System.out.println("Schiff(3er) - Start: " + s3.getPartOne() + "   Ende: " + s3.getPartThree() + "    Alle: " + s3.testAusgabe());

		
		
		
		
		FirstHit = "E1I7";
		LastHit = "E1I6";
		
//		FirstHit = "E1C2";
//		LastHit = "E1D2";
		
		// E1I6 first
		// E1I7
		// E1I8 last
		//
		// E1I5 wird gebraucht		
		
		ShipFive randSchiff = new ShipFive(new HardOpponent().calculateStartCoordsLevelOne());

		System.out.println("Randschiff: " + randSchiff.testAusgabe() + " Rand: " + randSchiff.isShipInEdgeField(randSchiff));
		
		
		/* überprüfen ob es ein Randfeld ist */
		while (randSchiff.isShipInEdgeField(randSchiff) == true) {
			randSchiff = new ShipFive(
					new HardOpponent().calculateStartCoordsLevelOne());
		} 
		

		
//		System.out.println(s5.getShip().testAusgabe());	
//		
//		Ship test = new ShipFive("E1B8");
//		System.out.println(test.getPartOne() +": "+ test.calculateEndCoords()  + " --> E1B4 und E1F8" ); // E1B4 und E1F8 erwartet
//		
		System.out.println();
		ShipFive test2 = new ShipFive("E141");
		System.out.println(test2.getPartOne() +": " + "ermittelte Endpunkte " + test2.calculateEndCoords() + " --> E145 und E181, E101" ); // E1E5 und E1I1 erwartet
		System.out.println("Schiff(5er): " + test2.getShip().testAusgabe());

		System.out.println();
		Ship test3 = new ShipFive("E181");
		System.out.println(test3.getPartOne() +": " + test3.calculateEndCoords() + " --> E141 und E185" ); 

//		Ship s3ohneStartpunkt = new ShipThree("E2I8");
//		System.out.println(s3ohneStartpunkt.getPartOne() +": " + s3ohneStartpunkt.calculateEndCoords() + " --> E1E1 und E1I5" ); 
//
//				
//	}
//	
//	
		
	}
}
