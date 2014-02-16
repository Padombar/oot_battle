package oot_battle;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import oot_battle.ships.Ship;
import oot_battle.ships.ShipFive;
import oot_battle.ships.ShipFour;
import oot_battle.ships.ShipOne;
import oot_battle.ships.ShipThree;
import oot_battle.ships.ShipTwo;

public class Battlefield {

	private HashMap<String, Ship> shipList = new HashMap<String, Ship>();
	private LinkedList<String> hit = new LinkedList<String>();
	private int versenkteSchiffe = 0;

	private String[][][] feld = new String[3][11][11];

	public Battlefield() {

		int ebene = 0;
		while (ebene != 3) {
			// feld erstellen
			int yAchse = 1;
			int xAchse = 1;

			xAchse = 0;
			String zahl;

			// Beschriften der X Achse
			while (xAchse != 10) {
				zahl = "   " + xAchse + "  ";
				;
				this.feld[ebene][10][xAchse] = zahl;
				xAchse++;
				zahl = null;

			}

			// Beschriften der Y Achse
			yAchse = 0;
			while (yAchse != 11) {
				this.feld[ebene][yAchse][10] = "" + yAchse;
				yAchse++;

			}

			// leere Felder
			this.feld[ebene][10][10] = "   ";

			yAchse = 0;
			xAchse = 0;

			while (yAchse != 10) {
				while (xAchse != 10) {
					this.feld[ebene][yAchse][xAchse] = " [   ]";

					xAchse++;
				}
				xAchse = 0;
				yAchse++;
			}

			ebene++;
		}

	}

	public String[][][] getFeld() {
		return this.feld;
	}

	// Ausgabe des Feldes
	public void printFeld() {
		int y = 0;
		int x = 0;
		int ebenen = 0;
		int zahl;

		while (ebenen != 3) {
			zahl = ebenen + 1;
			System.out.println("");
			System.out.println("Ebene : " + zahl);

			while (y != 11) {
				while (x != 11) {

					System.out.print(this.feld[ebenen][y][x] + " ");
					x++;

				}
				System.out.println("");
				x = 0;
				y++;
			}
			y = 0;
			x = 0;
			ebenen++;
		}
	}

	// nur zum test die ausgabe der MAP
	public HashMap<String, Ship> getSMap() {
		return this.shipList;
	}

	// selbst erklaerend?
	public boolean isGameRunning() {
		if (this.versenkteSchiffe == 12) {

			return false;
		} else {

			return true;
		}
	}

	public boolean isHit(String coord) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException{

		// schaut in die setShipListe MAP nach ob genau an der coord ein treffer
		// war

		if (this.shipList.containsKey(coord)) {
			this.shipList.get(coord).hit();
			AwesomeProgrammStarten.musikTreffer();
			System.out.println("\n                              ________________");
			System.out.println("                             |    treffer!    |");
			System.out.println("                             |________________|\n");
			setHit(coord);
			// wenn z.B. beim 5er Schiff 5 mal getroffen wurde
			if (this.shipList.get(coord).isDestroyed()) {
				// es gibt 12 schiffe vorbereitung fuer spielbeenden abfrage
				AwesomeProgrammStarten.musikVersenkt();
				System.out.println("\n                              ________________");
				System.out.println("                             |   versenkt!    |");
				System.out.println("                             |________________|\n");
				
				versenkteSchiffe++;
				Thread.sleep(1000);
			}
			Thread.sleep(500);
			

			return true;

		} else if (!this.shipList.containsKey(coord)) {
			AwesomeProgrammStarten.musikDaneben();
			System.out.println("\n                              ________________");
			System.out.println("                             |   verfehlt!    |");
			System.out.println("                             |________________|\n");
			Thread.sleep(500);
			return false;
		}
		
		return false;

	}

	public boolean isHitFast(String coord) throws InterruptedException{

		// schaut in die setShipListe MAP nach ob genau an der coord ein treffer
		// war

		if (this.shipList.containsKey(coord)) {
			this.shipList.get(coord).hit();
			System.out.println("\n                              ________________");
			System.out.println("                             |    treffer!    |");
			System.out.println("                             |________________|\n");
			setHit(coord);
			// wenn z.B. beim 5er Schiff 5 mal getroffen wurde
			if (this.shipList.get(coord).isDestroyed()) {
				// es gibt 12 schiffe vorbereitung fuer spielbeenden abfrage
				System.out.println("\n                              ________________");
				System.out.println("                             |   versenkt!    |");
				System.out.println("                             |________________|\n");
				versenkteSchiffe++;
				Thread.sleep(500);
			}
			

			return true;

		} else if (!this.shipList.containsKey(coord)) {
			System.out.println("\n                              ________________");
			System.out.println("                             |   verfehlt!    |");
			System.out.println("                             |________________|\n");

			return false;
		}
		
		return false;

	}

	// setzt ins Feld einen Treffer (Array)
	private void setHit(String coord) {
		this.feld[(PositionsAbfrage.getEbene(coord))][PositionsAbfrage
				.getY(coord)][PositionsAbfrage.getX(coord)] = " [-X-]";

	}

	// setzt schiff
	public void setShip(String start, String end, Ship ship) {

		int groﬂ = 0;
		int klein = 0;

		if (PositionsAbfrage.getY(start) == PositionsAbfrage.getY(end)
				&& PositionsAbfrage.getX(start) == PositionsAbfrage.getX(end)) {

			this.feld[(PositionsAbfrage.getEbene(start))][PositionsAbfrage
					.getY(start)][PositionsAbfrage.getX(start)] = ship.getBoot();
			this.shipList.put(
					"E" + (PositionsAbfrage.getEbene(start) + 1)
							+ (PositionsAbfrage.getY(start))
							+ (PositionsAbfrage.getX(start)), ship);

		} else if (PositionsAbfrage.getY(start) == PositionsAbfrage.getY(end)) {
			if (PositionsAbfrage.getX(start) < PositionsAbfrage.getX(end)) {
				groﬂ = PositionsAbfrage.getX(end);
				klein = PositionsAbfrage.getX(start);

			}

			if (PositionsAbfrage.getX(start) > PositionsAbfrage.getX(end)) {
				groﬂ = PositionsAbfrage.getX(start);
				klein = PositionsAbfrage.getX(end);

			}

			// fuellt auch die zwischen Koordinaten z.B. 3er schiff E155 =
			// start, E157 = ende, E156 = zwischen
			while (klein <= groﬂ) {
				this.feld[(PositionsAbfrage.getEbene(start))][PositionsAbfrage
						.getY(start)][klein] = ship.getBoot();
				this.shipList.put("E" + (PositionsAbfrage.getEbene(start) + 1)
						+ (PositionsAbfrage.getY(start)) + klein, ship);
				klein++;

			}

			groﬂ = 0;
			klein = 0;

		} else if (PositionsAbfrage.getX(start) == PositionsAbfrage.getX(end)) {

			if (PositionsAbfrage.getY(start) < PositionsAbfrage.getY(end)) {
				groﬂ = PositionsAbfrage.getY(end);
				klein = PositionsAbfrage.getY(start);

			}

			if (PositionsAbfrage.getY(start) > PositionsAbfrage.getY(end)) {
				groﬂ = PositionsAbfrage.getY(start);
				klein = PositionsAbfrage.getY(end);

			}
			// fuellt auch die zwischen Koordinaten z.B. 3er schiff E155 =
			// start, E157 = ende, E156 = zwischen
			while (klein <= groﬂ) {
				this.feld[(PositionsAbfrage.getEbene(start))][klein][PositionsAbfrage
						.getX(start)] = ship.getBoot();
				this.shipList.put("E" + (PositionsAbfrage.getEbene(start) + 1)
						+ klein + (PositionsAbfrage.getX(start)), ship);
				klein++;

			}
			groﬂ = 0;
			klein = 0;

		}
		// nur zum testen ausgabe
//		for (String cord : this.shipList.keySet()) {
//			System.out.println(cord + ": Schiff "
//					+ this.shipList.get(cord).getLength());
//		}

	}
}
