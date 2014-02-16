package oot_battle.ki;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import oot_battle.Battlefield;
import oot_battle.PositionsAbfrage;
import oot_battle.ships.ShipFive;
import oot_battle.ships.ShipFour;
import oot_battle.ships.ShipOne;
import oot_battle.ships.ShipThree;
import oot_battle.ships.ShipTwo;

public class EasyOpponent {

	private LinkedList<String> schonGeschossen = new LinkedList<String>();
	private LinkedList<String> schonGesetzteSchiffe = new LinkedList<String>();

	/**
	 * Berechnet per Zufalls eine Koordinate zum Beschie�en und speichert sie in
	 * eine Liste ab
	 */

	private String calculateShotCoordinates() {

		boolean stop = false;
		String position = "";

		while (!stop) {
			// EASY KI Random shot

			// Ascii umwandlung

			position = "E" + (int) (Math.random() *
			// Random von 1-3
					(4 - 1) + 1) + ""

			// Random von 0-9
					+ ((int) (Math.random() * (11 - 1)))

					// Random von 0-9
					+ ((int) (Math.random() * (11 - 1)));

			if (!this.schonGeschossen.contains(position)) {
				this.schonGeschossen.addFirst(position);

				stop = true;
			}
		}

		return position;
	}

	public void shot(Battlefield gegner) throws InterruptedException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		boolean nochmal = false;

		while (!nochmal) {

			boolean stop = false;

			String coord = "";
			while (!stop) {
				coord = calculateShotCoordinates();
				if (coord.equals("banane")) {

				} else {
					stop = true;
				}
			}

			if (!gegner.isHitFast(coord)) {
				nochmal = true;
			}
		}

	}

	public static String augenscheEndpunktBerechnung(String startCoord,
			int shiplength, Battlefield feld) {
		LinkedList<String> possibleEndpoints = new LinkedList();
		int options = 0;

		// berechnung der Möglichen Endpunkte, für jede richtung
		if (shiplength > 1) {
			// endpunkt auf der X-Achse wird geprueft (Osten)
			if (PositionsAbfrage.getX(startCoord) + shiplength - 1 <= 9) {
				int coord = PositionsAbfrage.getX(startCoord) + shiplength - 1;
				String endpoint = "" + startCoord.charAt(0)
						+ startCoord.charAt(1) + startCoord.charAt(2) + coord;
				int shipPlaces = 0;
				if (!feld.getSMap().containsKey(endpoint)) {
					if (startCoord.charAt(3) != endpoint.charAt(3)) {
						if (startCoord.charAt(3) < endpoint.charAt(3)) {
							int i = 0;

							while (i < shiplength) {
								String taken = "" + startCoord.charAt(0)
										+ startCoord.charAt(1)
										+ startCoord.charAt(2);
								int xposition = PositionsAbfrage
										.getX(startCoord) + i;
								taken += xposition;
								i++;
								if (!feld.getSMap().containsKey(taken)) {
									shipPlaces++;
								}
							}
						}
					}
				}
				if (shipPlaces == shiplength) {
					options++;
					possibleEndpoints.add(endpoint);

				}
			}

			// endpunkt aud der X-Achse wird geprueft (West)
			if (PositionsAbfrage.getX(startCoord) - shiplength + 1 >= 0) {
				int coord = PositionsAbfrage.getX(startCoord) - shiplength + 1;
				String endpoint = "" + startCoord.charAt(0)
						+ startCoord.charAt(1) + startCoord.charAt(2) + coord;
				int shipPlaces = 0;
				if (!feld.getSMap().containsKey(endpoint)) {
					if (startCoord.charAt(3) != endpoint.charAt(3)) {
						if (startCoord.charAt(3) > endpoint.charAt(3)) {
							int i = 0;

							while (i < shiplength) {
								String taken = "" + startCoord.charAt(0)
										+ startCoord.charAt(1)
										+ startCoord.charAt(2);
								int xposition = PositionsAbfrage
										.getX(startCoord) - i;
								taken += xposition;
								i++;
								if (!feld.getSMap().containsKey(taken)) {
									shipPlaces++;
								}
							}
						}
					}

				}
				if (shipPlaces == shiplength) {
					options++;
					possibleEndpoints.add(endpoint);
					
				}
			}

			// endpunkt auf der Y-Achse wird geprueft (Sued)
			if (PositionsAbfrage.getY(startCoord) + shiplength - 1 <= 9) {
				int coord = PositionsAbfrage.getY(startCoord) + shiplength - 1;
				String endpoint = "" + startCoord.charAt(0)
						+ startCoord.charAt(1) + coord + startCoord.charAt(3);
				int shipPlaces = 0;
				if (!feld.getSMap().containsKey(endpoint)) {
					if (startCoord.charAt(2) != endpoint.charAt(2)) {
						if (startCoord.charAt(2) < endpoint.charAt(2)) {
							int i = 0;
							while (i < shiplength) {
								String taken = "" + startCoord.charAt(0)
										+ startCoord.charAt(1);
								int yposition = PositionsAbfrage.getY(endpoint)
										- i;
								taken += yposition;
								taken += startCoord.charAt(3);
								i++;
								if (!feld.getSMap().containsKey(taken)) {
									shipPlaces++;
								}
							}
						}
					}

				}
				if (shipPlaces == shiplength) {
					options++;
					possibleEndpoints.add(endpoint);
					
				}

			}

			// endpunkt aud der Y-Achse wird geprueft (Nord)
			if (PositionsAbfrage.getY(startCoord) - shiplength + 1 >= 0) {
				int coord = PositionsAbfrage.getY(startCoord) - shiplength + 1;
				String endpoint = "" + startCoord.charAt(0)
						+ startCoord.charAt(1) + coord + startCoord.charAt(3);
				int shipPlaces = 0;
				if (!feld.getSMap().containsKey(endpoint)) {
					if (startCoord.charAt(2) != endpoint.charAt(2)) {
						if (startCoord.charAt(2) > endpoint.charAt(2)) {
							int i = 0;
							while (i < shiplength) {
								String taken = "" + startCoord.charAt(0)
										+ startCoord.charAt(1);
								int yposition = PositionsAbfrage.getY(endpoint)
										+ i;
								taken += yposition;
								taken += startCoord.charAt(3);
								i++;
								if (!feld.getSMap().containsKey(taken)) {
									shipPlaces++;
								}
							}
						}
					}

				}
				if (shipPlaces == shiplength) {
					options++;
					possibleEndpoints.add(endpoint);
			
				}
			}
		}

		if (options > 0) {

			int i = 1;
			int j = 0;
			while (i <= options) {

				i++;
				j++;
			}
			return chooseEndcoordinate(possibleEndpoints, startCoord, options,
					shiplength, feld);
		} else {
			
			return "banane";
		}
	}

	private static String chooseEndcoordinate(LinkedList<String> endCoords,
			String startCoord, int options, int shipLength, Battlefield feld) {

		String coord = "";
		int selection = 0;
		boolean valid = false;

		String zufall = "" + ((char) ((Math.random() * (5 - 1) + 1) + 48));

		String number = zufall;

		if (number.equals("1") || number.equals("2") || number.equals("3")
				|| number.equals("4")) {
			selection = Integer.parseInt(number);

			if (selection > options) {

			
				return chooseEndcoordinate(endCoords, startCoord, options,
						shipLength, feld);
			}
			if (selection <= options && selection > 0) {
				valid = true;
			}

		} else {
		
			return chooseEndcoordinate(endCoords, startCoord, options,
					shipLength, feld);
		}
		if (options == 4) {

			switch (selection) {
			case 1:
				coord = endCoords.get(0);
				break;
			case 2:
				coord = endCoords.get(1);
				break;
			case 3:
				coord = endCoords.get(2);
				break;
			case 4:
				coord = endCoords.get(3);
				break;
			}
		} else if (options == 3) {

			switch (selection) {
			case 1:
				coord = endCoords.get(0);
				break;
			case 2:
				coord = endCoords.get(1);
				break;
			case 3:
				coord = endCoords.get(2);
				break;
			}
		} else if (options == 2) {
			switch (selection) {
			case 1:
				coord = endCoords.get(0);
				break;
			case 2:
				coord = endCoords.get(1);
				break;
			}
		} else if (options == 1) {
			switch (selection) {
			case 1:
				coord = endCoords.get(0);
				break;
			}
		}

		if (!feld.getSMap().containsKey(coord)) {

			return coord;
		} else {

			return chooseEndcoordinate(endCoords, startCoord, options,
					shipLength, feld);
		}
	}

	private String calculateSetCoordinatesShip(int ebene, Battlefield feld) {
		boolean stop = false;
		String position = "";

		while (!stop) {
			// EASY KI Random shot

			// Ascii umwandlung

			position = "E" + ebene

			// Random von 0-9
					+ ((int) (Math.random() * (11 - 1)))

					// Random von 0-9
					+ ((int) (Math.random() * (11 - 1)));

			if (PositionsAbfrage.isCoordinateValidAndNotSet(position, feld)) {
				this.schonGeschossen.addFirst(position);

				stop = true;
			}
		}
		return position;

	}

	public void setShips(Battlefield feld) throws InterruptedException {

		ShipFive banane = new ShipFive("E123", "E123");
		ShipFour banane2 = new ShipFour("E123", "E123");
		ShipTwo banane3 = new ShipTwo("E123", "E123");
		ShipOne banane4 = new ShipOne("E123", "E123");
		
		System.out.print("\n\nSchiffe  setzten    ");
		for (int zeichen = 0; zeichen <= 55; zeichen++) {
			System.out.print("|");
			Thread.sleep(15);
		}

		// 5
		String endCoords = "";
		String startCoords = "";
		boolean stop = false;
		while (!stop) {
			startCoords = calculateSetCoordinatesShip(1, feld);
			endCoords = augenscheEndpunktBerechnung(startCoords,
					banane.getLength(), feld);


			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startCoords, feld)) {
				
			} else if (endCoords.equals("banane")) {
				
			} else {
				stop = true;
			}

		}
		stop = false;

		feld.setShip(startCoords, endCoords, banane);

//		feld.printFeld();



		// 4
		endCoords = "";
		startCoords = "";

		while (!stop) {
			startCoords = calculateSetCoordinatesShip(1, feld);

			endCoords = augenscheEndpunktBerechnung(startCoords,
					banane2.getLength(), feld);

			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startCoords, feld)) {
			
			} else if (endCoords.equals("banane")) {
				
			} else {
				stop = true;
			}
		}
		stop = false;

		feld.setShip(startCoords, endCoords, banane2);

//		feld.printFeld();



		// 2
		endCoords = "";
		startCoords = "";
		while (!stop) {
			startCoords = calculateSetCoordinatesShip(1, feld);
			endCoords = augenscheEndpunktBerechnung(startCoords,
					banane3.getLength(), feld);

			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startCoords, feld)) {
			
			} else if (endCoords.equals("banane")) {
				
			} else {
				stop = true;
			}

		}
		stop = false;

		feld.setShip(startCoords, endCoords, banane3);

//		feld.printFeld();



		// 1
		endCoords = "";
		startCoords = "";
		while (!stop) {
			startCoords = calculateSetCoordinatesShip(1, feld);

			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startCoords, feld)) {
				

			} else {
				stop = true;
			}

		}

		feld.setShip(startCoords, startCoords, banane4);
//		feld.printFeld();



		for (int i = 1; i <= 4; i++) {

			endCoords = "";
			startCoords = "";
			stop = false;

			while (!stop) {
				startCoords = calculateSetCoordinatesShip(2, feld);

				endCoords = augenscheEndpunktBerechnung(startCoords, 3, feld);


				if (!PositionsAbfrage.isCoordinateValidAndNotSet(startCoords,
						feld)) {
				

				} else if (endCoords.equals("banane")) {
					
				} else {
					stop = true;
				}

			}
			stop = false;

			ShipThree banane5 = new ShipThree(startCoords, endCoords);

			feld.setShip(startCoords, endCoords, banane5);



		}

//		feld.printFeld();



		for (int in = 1; in <= 4; in++) {

			endCoords = "";
			startCoords = "";
			
			stop = false;
			while (!stop) {
				startCoords = calculateSetCoordinatesShip(3, feld);
				endCoords = augenscheEndpunktBerechnung(startCoords, 3, feld);

				if (!PositionsAbfrage.isCoordinateValidAndNotSet(startCoords,
						feld)) {
				

				} else if (endCoords.equals("banane")) {
					
				} else {
					stop = true;
				}

			}
			stop = false;

			ShipThree banane6 = new ShipThree("E123", "E123");

			feld.setShip(startCoords, endCoords, banane6);



		}
		stop = false;

//		feld.printFeld();



	}
}
