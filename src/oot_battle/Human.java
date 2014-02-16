package oot_battle;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import oot_battle.ships.Ship;

public class Human {

	private LinkedList<String> geschossen = new LinkedList<String>();

	private LinkedList<String> schonGeschossen = new LinkedList<String>();

	public Human() {
	}

	public void shot(Battlefield gegner) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {

		boolean nochmal = true;
		if (!gegner.isGameRunning()) {
			nochmal = true;
		} else {
			while (nochmal) {

				boolean richtig = false;
				String antwort = "";

				while (!richtig) {

					System.out
							.println("                    Eingabe: Ebene (1,2 oder 3)\n");

					int eA = coordScannerEbene();

					System.out.println("                    Eingabe: Y-Achse:");

					System.out.println("\n\n");

					int yA = coordScanner();

					System.out.println("                    Eingabe: X-Achse:");

					System.out.println("\n\n");

					int xA = coordScanner();

					// Koord wird erstellt

					antwort = "E" + eA + yA + xA;
					if (PositionsAbfrage.isCoordinateValid(antwort)) {
						richtig = true;
					} else {
						System.out.println("ungueltige Eingabe");
					}
				}
				richtig = false;

				if (this.schonGeschossen.contains(antwort) == true) {
					System.out
							.println("Dieses Feld wurde schon Beschossen bitte neue Koordinaten eingeben!\n\n");

				} else {
					// scheißen du depp zw. markieren bzw. ja wie auch immer!!
					this.schonGeschossen.add(antwort);
					if (!gegner.isHit(antwort)) {
						nochmal = false;
					} else {
						System.out
								.println("\n  Sie duerfen nocheinmal schiessen\n    neue Koordinaten:\n\n");
					}

				}
			}
		}

	}

	public void setShip(String startCoord, String endCoord, Battlefield feld,
			Ship ship) {
		feld.setShip(startCoord, endCoord, ship);

	}

	public void addBelegteFelder(String feld) {
		this.geschossen.add(feld);
	}

	public LinkedList<String> getBelegteFelder() {
		return this.geschossen;
	}

	private static int coordScanner() {

		boolean richtig = false;
		int auswahl = 0;

		while (!richtig) {

			Scanner in = new Scanner(System.in);
			String zahl = in.nextLine();

			if (zahl.equals("0") || zahl.equals("1") || zahl.equals("2")
					|| zahl.equals("3") || zahl.equals("4") || zahl.equals("5")
					|| zahl.equals("6") || zahl.equals("7") || zahl.equals("8")
					|| zahl.equals("9")) {
				richtig = true;
				auswahl = Integer.parseInt(zahl);
				richtig = true;

			} else
				System.out
						.println("\n                    ungueltige Eingabe bitte nur zahlen zwischen 0-9 verwenden\n\n");
		}

		return auswahl;

	}

	private static int coordScannerEbene() {

		boolean richtig = false;
		int auswahl = 0;

		while (!richtig) {

			Scanner in = new Scanner(System.in);
			String zahl = in.nextLine();

			if (zahl.equals("1") || zahl.equals("2") || zahl.equals("3")) {
				richtig = true;
				auswahl = Integer.parseInt(zahl);
				richtig = true;

			} else
				System.out
						.println("\n                    ungueltige Eingabe bitte nur zahlen zwischen 1-3 verwenden\n\n");
		}

		return auswahl;

	}

}
