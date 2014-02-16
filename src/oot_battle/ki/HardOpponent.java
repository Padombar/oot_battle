package oot_battle.ki;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

import javax.print.attribute.standard.MediaSize.Other;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import oot_battle.Battlefield;
import oot_battle.PositionsAbfrage;
import oot_battle.ships.Ship;
import oot_battle.ships.ShipFive;
import oot_battle.ships.ShipFour;
import oot_battle.ships.ShipOne;
import oot_battle.ships.ShipThree;
import oot_battle.ships.ShipTwo;

/**
 * @author CodeEvolution
 */
public class HardOpponent {

	LinkedList<String> validList = new LinkedList<String>();
	Map<String, String> coordsMap = new HashMap<String, String>();

	public static String FirstHit;
	public static String LastHit;
	public static String LastShot;
	private boolean LastHitSuccessfully = false;

	/*
	 * wird auf true gesetzt. wenn nach schiessenNachTreffer ein Randfeld ist,
	 * oder kein treffer erzielt wird
	 */
	private boolean nextOtherSide = false;

	/*
	 * wird auf true gesetzet damit die methode weiterSchiessen() aufgerufen
	 * wird
	 */
	private boolean nextRoundNorth = false;
	private boolean nextRoundEast = false;
	private boolean nextRoundSouth = false;
	private boolean nextRoundWest = false;

	/* weiterInDieRichtung */
	private boolean forwardNorth = false;
	private boolean forwardEast = false;
	private boolean forwardSouth = false;
	private boolean forwardWest = false;

	/* Schüsse speichern sowie die besten Schusskoordinaten für Level 2 und 3 */
	private LinkedList<String> shotList = new LinkedList<String>();
	private LinkedList<String> levelTwo = new LinkedList<String>();
	private LinkedList<String> levelThree = new LinkedList<String>();
	private LinkedList<String> edgeList = new LinkedList<String>();

	private final String[] bestShotsTwo = { "E202", "E205", "E208", "E211",
			"E214", "E217", "E220", "E223", "E226", "E229", "E232", "E235",
			"E238", "E241", "E244", "E247", "E250", "E253", "E256", "E259",
			"E262", "E265", "E268", "E271", "E274", "E277", "E280", "E283",
			"E286", "E289", "E292", "E295", "E298", };

	private final String[] bestShotsThree = { "E302", "E305", "E308", "E311",
			"E314", "E317", "E320", "E323", "E326", "E329", "E332", "E335",
			"E338", "E341", "E344", "E347", "E350", "E353", "E356", "E359",
			"E362", "E365", "E368", "E371", "E374", "E377", "E380", "E383",
			"E386", "E389", "E392", "E395", "E398", };

	int[] levelNumbers = { 1, 2, 3 };

	/* Alles Randfelder um diese beim Setzen ausschließen zu können */
	public final static String[] edgeFields = { "E100", "E101", "E102", "E103",
			"E104", "E105", "E106", "E107", "E108", "E109", "E110", "E120",
			"E130", "E140", "E150", "E160", "E170", "E180", "E119", "E129",
			"E139", "E149", "E159", "E169", "E179", "E180", "E191", "E192",
			"E193", "E194", "E195", "E196", "E197", "E199", "E199",

			"E200", "E201", "E202", "E203", "E204", "E205", "E206", "E207",
			"E208", "E209", "E210", "E220", "E230", "E240", "E250", "E260",
			"E270", "E280", "E219", "E229", "E239", "E249", "E259", "E269",
			"E279", "E280", "E291", "E292", "E293", "E294", "E295", "E296",
			"E297", "E299", "E299",

			"E300", "E301", "E302", "E303", "E304", "E305", "E306", "E307",
			"E308", "E309", "E310", "E320", "E330", "E340", "E350", "E360",
			"E370", "E380", "E319", "E329", "E339", "E349", "E359", "E369",
			"E379", "E380", "E391", "E392", "E393", "E394", "E395", "E396",
			"E397", "E399", "E399" };

	/* Alle gültigen Koordinaten */
	public final static String[] validFields = { "E100", "E101", "E102",
			"E103", "E104", "E105", "E106", "E107", "E108", "E109", "E110",
			"E111", "E112", "E113", "E114", "E115", "E116", "E117", "E118",
			"E119", "E120", "E121", "E122", "E123", "E124", "E125", "E126",
			"E127", "E128", "E129", "E130", "E131", "E132", "E133", "E134",
			"E135", "E136", "E137", "E138", "E139", "E140", "E141", "E142",
			"E143", "E144", "E145", "E146", "E147", "E148", "E149", "E150",
			"E151", "E152", "E153", "E154", "E155", "E156", "E157", "E158",
			"E159", "E160", "E161", "E162", "E163", "E164", "E165", "E166",
			"E167", "E168", "E169", "E170", "E171", "E172", "E173", "E174",
			"E175", "E176", "E177", "E178", "E179", "E180", "E181", "E182",
			"E183", "E184", "E185", "E186", "E187", "E188", "E189", "E190",
			"E191", "E192", "E193", "E194", "E195", "E196", "E197", "E198",
			"E199",

			"E200", "E201", "E202", "E203", "E204", "E205", "E206", "E207",
			"E208", "E209", "E210", "E211", "E212", "E213", "E214", "E215",
			"E216", "E217", "E218", "E219", "E220", "E221", "E222", "E223",
			"E224", "E225", "E226", "E227", "E228", "E229", "E230", "E231",
			"E232", "E233", "E234", "E235", "E236", "E237", "E238", "E239",
			"E240", "E241", "E242", "E243", "E244", "E245", "E246", "E247",
			"E248", "E249", "E250", "E251", "E252", "E253", "E254", "E255",
			"E256", "E257", "E258", "E259", "E260", "E261", "E262", "E263",
			"E264", "E265", "E266", "E267", "E268", "E269", "E270", "E271",
			"E272", "E273", "E274", "E275", "E276", "E277", "E278", "E279",
			"E280", "E281", "E282", "E283", "E284", "E285", "E286", "E287",
			"E288", "E289", "E290", "E291", "E292", "E293", "E294", "E295",
			"E296", "E297", "E298", "E299",

			"E300", "E301", "E302", "E303", "E304", "E305", "E306", "E307",
			"E308", "E309", "E310", "E311", "E312", "E313", "E314", "E315",
			"E316", "E317", "E318", "E319", "E320", "E321", "E322", "E323",
			"E324", "E325", "E326", "E327", "E328", "E329", "E330", "E331",
			"E332", "E333", "E334", "E335", "E336", "E337", "E338", "E339",
			"E340", "E341", "E342", "E343", "E344", "E345", "E346", "E347",
			"E348", "E349", "E350", "E351", "E352", "E353", "E354", "E355",
			"E356", "E357", "E358", "E359", "E360", "E361", "E362", "E363",
			"E364", "E365", "E366", "E367", "E368", "E369", "E370", "E371",
			"E372", "E373", "E374", "E375", "E376", "E377", "E378", "E379",
			"E380", "E381", "E382", "E383", "E384", "E385", "E386", "E387",
			"E388", "E389", "E390", "E391", "E392", "E393", "E394", "E395",
			"E396", "E397", "E398", "E399" };

	LinkedList<String> copyLevelTwo = levelTwo;
	LinkedList<String> copyLevelThree = levelThree;

	/* Konstruktor */
	public HardOpponent() {
		for (String s : bestShotsTwo)
			levelTwo.add(s);
		for (String s3 : bestShotsThree)
			levelThree.add(s3);
		for (String valid : validFields)
			validList.add(valid);
		for (String edge : edgeFields) {
			edgeList.add(edge);
		}
	}

	/**
	 * Fügt einen Treffer zur shotList damit ein erneutes schießen auf das selbe
	 * Feld verhindert wird
	 * 
	 * @return Koordinaten des Schusses
	 */
	private String calculateShotCoordinates() {
		boolean stop = false;
		String position = "";

		while (!stop) {

			/* Zufallszahl zwischen 0 und 9 */
			position = "E" + (int) (Math.random() * (4 - 1) + 1) + ""
					+ new Random().nextInt(10) + new Random().nextInt(10);
			LastShot = position;

			/* Bei Ebene 2 die level 2 SchussListe verwenden */
			if (position.charAt(1) == '2') {
				LinkedList<String> copyLevelTwo = levelTwo;
				Collections.shuffle(copyLevelTwo);
				position = copyLevelTwo.pollFirst();
			}

			/* Bei Ebene 3 die level 3 SchussListe verwenden */
			if (position.charAt(1) == '3') {
				LinkedList<String> copyLevelThree = levelThree;
				Collections.shuffle(copyLevelThree);
				position = copyLevelThree.pollFirst();
			}

			/* Schüssen die die shotList schreiben */
			if (!shotList.contains(position)) {
				shotList.add(position);
				stop = true;
			} else {
				calculateShotCoordinates();
			}
		}
//		System.out.println("calculateShotCoordinates() --> " + position );
		return position;
	}

	/* Schiessen mit Zufallskoordinaten auf das gegner Spielfeld */
	public boolean shot(Battlefield gegner) throws InterruptedException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {

		// /////////// abfrage von der vorherigen runde /////////////
		/*  */
		if (nextOtherSide) {
			shot(gegner, andereRichtung());
		}

		/* für die nächste runde: weiter schiessen in diese richtung: */
		if (forwardNorth || forwardEast || forwardSouth || forwardWest) {
			shot(gegner, weiterInDieRichtungKoordinate());
		}

		/* es wird an den 4 weiteren möglichkeiten weitergeschossen */
		if (nextRoundNorth || nextRoundEast || nextRoundSouth || nextRoundWest) {
			schiessenNachTreffer(gegner);
		}

		// /////////////////////////////////////////////////////////////

		String position = calculateShotCoordinates();
		boolean bool = false;

		// Abgleich mit allen gültigen Spielfeldern
		// --> shot ist möglich
		if (validFields.equals(position)) {
			bool = true;
		}

		LastShot = position;
//		System.out.println("shot(), LastShot --> " + LastShot);
		
		/* Falls der Schuss ein Treffer ist */
		if (gegner.isHitFast(position)) {

			/* Treffer speichern */
			FirstHit = position;
			LastHit = position;
//			System.out.println("shot(), FirstHit --> " + FirstHit);
			
			if (gegner.getSMap().get(position).isDestroyed()) {
				shot(gegner);
			}
			schiessenNachTreffer(gegner);
		}
		return bool;
	}

	/* Schiessen mit angegebenen Koordinaten */
	public boolean shot(Battlefield gegner, String position)
			throws InterruptedException, UnsupportedAudioFileException,
			IOException, LineUnavailableException {
		boolean bool = false;

		// Abgleich mit allen gültigen Spielfeldern
		if (validFields.equals(position)) {
			bool = true;
		}

		LastShot = position;
//		System.out.println("shot(posi), LastShot --> " + LastShot);
		
		/* Falls der Schuss ein Treffer ist */
		if (gegner.isHitFast(position)) {

			/* Treffer speichern */
			FirstHit = position;
			LastHit = position;
//			System.out.println("shot(posi), FirstHit --> " + FirstHit);
		
			if (gegner.getSMap().get(position).isDestroyed()) {
				shot(gegner);
			}
			schiessenNachTreffer(gegner);
		}
		return bool;
	}

	/**
	 * Felder die nach einem Treffer beschiessbar sind werden ermittelt nur
	 * felder innerhalb des spielfeldes
	 */
	public void felderErmittelnNachTreffer() {

		String start = LastHit;

		char e1 = start.charAt(0);
		char e2 = start.charAt(1);

		/* Positionen Norden Süden Westen Osten */
		int w = PositionsAbfrage.getX(start) - 1;
		int e = PositionsAbfrage.getX(start) + 1;
		int n = PositionsAbfrage.getY(start) - 1;
		int s = PositionsAbfrage.getY(start) + 1;

		/*
		 * felder außerhalb des spielfeldes abfangen extremfall: [X1 X2 X3 X4]|
		 * X3 wird beschossen ---> schiessenNachTreffer() X4 wird beschossen,
		 * wieder ein trefferm aber das nächste feld ist ein Randfeld if
		 * (aktuelles Feld == Randfeld && !SchiffVersenkt) --> in die andere
		 * Richtung schiessen --> andereRichtung()
		 */

		/* Ermittelten Koordinaten zwischenspeichern */
		String tmpNorth = e1 + "" + e2 + "" + n + ""
				+ PositionsAbfrage.getX(start);
		String tmpSouth = e1 + "" + e2 + "" + s + ""
				+ PositionsAbfrage.getX(start);
		String tmpEast = e1 + "" + e2 + "" + PositionsAbfrage.getY(start) + ""
				+ e;
		String tmpWest = e1 + "" + e2 + "" + PositionsAbfrage.getY(start) + ""
				+ w;

		/* Sind die Koordinaten innerhalb des Spielfeldes, in die Map schreiben */
		if (validList.contains(tmpNorth) && validList.contains(tmpSouth)
				&& validList.contains(tmpEast) && validList.contains(tmpWest)) {
			coordsMap.put("N", tmpNorth);
			coordsMap.put("S", tmpSouth);
			coordsMap.put("E", tmpEast);
			coordsMap.put("W", tmpWest);
		}

		if (validList.contains(tmpNorth) && validList.contains(tmpSouth)
				&& validList.contains(tmpEast)) {
			coordsMap.put("N", tmpNorth);
			coordsMap.put("S", tmpSouth);
			coordsMap.put("E", tmpEast);
		}

		if (validList.contains(tmpNorth) && validList.contains(tmpSouth)
				&& validList.contains(tmpWest)) {
			coordsMap.put("N", tmpNorth);
			coordsMap.put("S", tmpSouth);
			coordsMap.put("W", tmpWest);
		}

		if (validList.contains(tmpSouth) && validList.contains(tmpEast)
				&& validList.contains(tmpWest)) {
			coordsMap.put("S", tmpSouth);
			coordsMap.put("E", tmpEast);
			coordsMap.put("W", tmpWest);
		}

		if (validList.contains(tmpNorth) && validList.contains(tmpEast)
				&& validList.contains(tmpWest)) {
			coordsMap.put("N", tmpNorth);
			coordsMap.put("E", tmpEast);
			coordsMap.put("W", tmpWest);
		}

		if (validList.contains(tmpNorth) && validList.contains(tmpWest)) {
			coordsMap.put("N", tmpNorth);
			coordsMap.put("W", tmpWest);
		}

		if (validList.contains(tmpNorth) && validList.contains(tmpEast)) {
			coordsMap.put("N", tmpNorth);
			coordsMap.put("E", tmpEast);
		}

		if (validList.contains(tmpSouth) && validList.contains(tmpWest)) {
			coordsMap.put("S", tmpSouth);
			coordsMap.put("W", tmpWest);
		}

		if (validList.contains(tmpSouth) && validList.contains(tmpEast)) {
			coordsMap.put("S", tmpSouth);
			coordsMap.put("E", tmpEast);
		}
	}

	/**
	 * Testet die Koordinate *
	 * 
	 * @return true wenn das entsprechende Feld innerhalb des Spielfeldes ist
	 */
	public boolean isOnBattlefield(String coordinates) {
		boolean bool = false;
		if (validList.contains(coordinates)) {
			bool = true;
		}
		return bool;
	}

	/**
	 * Eines der möglichen Felder beschiessen
	 * 
	 * @throws InterruptedException
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	private void schiessenNachTreffer(Battlefield gegner)
			throws InterruptedException, UnsupportedAudioFileException,
			IOException, LineUnavailableException {

		boolean stop = false;

		while (!stop) {

			/* Liefert bis zu 4 mögliche Koordinaten in einer Map */
			felderErmittelnNachTreffer();

			/*
			 * Wird festgelegt, um später in die andere Richtung weiterschiessen
			 * zu können
			 */
			FirstHit = LastHit;

			if (coordsMap.containsKey("N")) {

				// das feld darf nicht bereits beschossen worden sein
				// falls doch, shot()
				if (!shotList.contains(coordsMap.get("N"))) {

					/* bei erfolgreichem Treffer */
					if (gegner.isHitFast(coordsMap.get("N"))) {

						LastHit = coordsMap.get("N");
						LastShot = LastHit;

//						System.out.println("schiessenNachTreffer(), N, LastHit --> " + LastHit);
						
						nextRoundNorth = false;
						shotList.add(coordsMap.get("N"));

						/*
						 * ist das schiff versenkt, koordinaten zurücksetzen und
						 * per zufall schiessen
						 */
						if (gegner.getSMap().get(LastHit).isDestroyed()) {
							resetForward();
							shot(gegner);
						}
						weiterInDieRichtungSchiessen(gegner);

					} // ~ isHit
					nextRoundEast = true;
					stop = true;
				}
				LastShot = coordsMap.get("N");
				shotList.add(coordsMap.get("N"));
				return;
			}

		
			if (coordsMap.containsKey("E")) {

				// das feld darf nicht bereits beschossen worden sein
				// falls doch, shot()
				if (!shotList.contains(coordsMap.get("E"))) {

					/* bei erfolgreichem Treffer */
					if (gegner.isHitFast(coordsMap.get("E"))) {

						LastHit = coordsMap.get("E");
						LastShot = LastHit;

//						System.out.println("schiessenNachTreffer(), E, LastHit --> " + LastHit);

						
						nextRoundEast = false;
						shotList.add(coordsMap.get("E"));

						/*
						 * ist das schiff versenkt, koordinaten zurücksetzen und
						 * per zufall schiessen
						 */
						if (gegner.getSMap().get(LastHit).isDestroyed()) {
							resetForward();
							shot(gegner);
						}
						weiterInDieRichtungSchiessen(gegner);

					} // ~ isHit
					nextRoundSouth = true;
					stop = true;
				}
				LastShot = coordsMap.get("E");
				shotList.add(coordsMap.get("E"));
				return;
			}

			if (coordsMap.containsKey("S")) {

				// das feld darf nicht bereits beschossen worden sein
				// falls doch, shot()
				if (!shotList.contains(coordsMap.get("S"))) {

					/* bei erfolgreichem Treffer */
					if (gegner.isHitFast(coordsMap.get("S"))) {

						LastHit = coordsMap.get("S");
						LastShot = LastHit;
						
//						System.out.println("schiessenNachTreffer(), S, LastHit --> " + LastHit);

						
						nextRoundSouth = false;
						shotList.add(coordsMap.get("S"));

						/*
						 * ist das schiff versenkt, koordinaten zurücksetzen und
						 * per zufall schiessen
						 */
						if (gegner.getSMap().get(LastHit).isDestroyed()) {
							resetForward();
							shot(gegner);
						}
						weiterInDieRichtungSchiessen(gegner);
					} // ~ isHit
					nextRoundWest = true;
					stop = true;
				}
				LastShot = coordsMap.get("W");
				shotList.add(coordsMap.get("W"));
				return;
			}

			if (coordsMap.containsKey("W")) {
				// das feld darf nicht bereits beschossen worden sein
				// falls doch, shot()
				if (!shotList.contains(coordsMap.get("W"))) {

					/* bei erfolgreichem Treffer */
					if (gegner.isHitFast(coordsMap.get("W"))) {

						LastHit = coordsMap.get("W");
						LastShot = LastHit;
						
//						System.out.println("schiessenNachTreffer(), W, LastHit --> " + LastHit);

						
						nextRoundWest = false;
						shotList.add(coordsMap.get("W"));

						/*
						 * ist das schiff versenkt, koordinaten zurücksetzen und
						 * per zufall schiessen
						 */
						if (gegner.getSMap().get(LastHit).isDestroyed()) {
							resetForward();
							shot(gegner);
						}

						weiterInDieRichtungSchiessen(gegner);
					} // ~ isHit
					stop = true;
				}
				LastShot = coordsMap.get("W");
				shotList.add(coordsMap.get("W"));
				return;
			}
		} // ~ stop

	}

	private void weiterInDieRichtungSchiessen(Battlefield gegner)
			throws InterruptedException, UnsupportedAudioFileException,
			IOException, LineUnavailableException {

		boolean stop = false;

		/* solange es ein treffer ist, schiessen */
		while (!stop) {

			/* darf nicht schon beschossen worden sein */
			if (!shotList.contains(weiterInDieRichtungKoordinate())) {

				/* bei einem treffer */
				if (gegner.isHitFast(weiterInDieRichtungKoordinate())) {

					LastHit = weiterInDieRichtungKoordinate();
					LastShot = LastHit;
					shotList.add(LastHit);
					
//					System.out.println("weiterInDieRichtungSchiessen(), LastHit --> " + LastHit);


					/* abfrage ob das schiff zerstört wurde */
					if (gegner.getSMap().get(LastHit).isDestroyed()) {
//						System.out
//								.println("schiff wurde versenkt, neu per zufall schiessen");
						resetForward();
						shot(gegner);
					} // ~ isDestroyed abfrage

				} // ~ isHit

				// wenn das weiterschiessen erfolglos ist oder ein randfeld
				nextOtherSide = true;

			} // ~ !shotList
			else

				stop = true;
			shot(gegner);

		} // ~ stop
	}

	private void resetForward() {
		forwardNorth = false;
		forwardEast = false;
		forwardSouth = false;
		forwardWest = false;
	}

	/** Bei einem Folgetreffer ist dies die weitere Koordinate */
	private String weiterInDieRichtungKoordinate() {

		String position = LastHit;

		int yFirst = PositionsAbfrage.getY(FirstHit);
		int xFirst = PositionsAbfrage.getX(FirstHit);

		int yLast = PositionsAbfrage.getY(LastHit);
		int xLast = PositionsAbfrage.getX(LastHit);

		/* bei Randfeldern die Mehtode andereRichtung() aufrufen */

		if (edgeList.contains(LastHit)) { // && !SchiffVersenkt) {
			position = andereRichtung();
		}

		/* x-Achse: start groesser West */
		if ((yFirst == yLast && xFirst < xLast)) {
			position = "E" + LastHit.charAt(1) + LastHit.charAt(2)
					+ (xLast + 1);
			// nächste runde nach westen schiessen
			forwardWest = true;

		}
		/* x-Achse: start kleiner Ost */
		if (yFirst == yLast && xFirst > xLast) {
			position = "E" + LastHit.charAt(1) + LastHit.charAt(2)
					+ (xLast - 1);
			// nächste runde nach osten schiessen
			forwardEast = true;
		}

		/* y-Achse start groesser Nord */
		if (xFirst == xLast && yFirst > yLast) {
			position = "E" + LastHit.charAt(1) + (yLast - 1) + xLast;
			// nächste runde nach norden schiessen
			forwardNorth = true;
		}
		/* y-Achse start kleiner Süd */
		if (xFirst == xLast && yFirst < yLast) {
			position = "E" + LastHit.charAt(1) + (yLast + 1) + xLast;

			// nächste runde nach süden schiessen
			forwardSouth = true;
		}

		if (!shotList.contains(position)) {
			shotList.add(position);
		} else
			position = calculateShotCoordinates();

		return position;
	}

	/**
	 * Ist das Schiff noch nicht versenkt und der Treffer ein Randfeld --> vom
	 * FirstHit in die andere Richtung schiessen
	 * 
	 * @return String der nächsten Koordinate
	 */
	public String andereRichtung() {
		String position = "";

		int yFirst = PositionsAbfrage.getY(FirstHit);
		int yLast = PositionsAbfrage.getY(LastHit);

		int xFirst = PositionsAbfrage.getX(FirstHit);
		int xLast = PositionsAbfrage.getX(LastHit);

		/* x-Achse, nach links: start groesser */
		if ((yFirst == yLast && xFirst < xLast)) {
			position = "E" + LastHit.charAt(1) + LastHit.charAt(2)
					+ (xFirst - 1);
//			System.out.println("+");
		}
		/* x-Achse, nach rechts: start kleiner */
		if (yFirst == yLast && xFirst > xLast) {
			position = "E" + LastHit.charAt(1) + LastHit.charAt(2)
					+ (xFirst + 1);
//			System.out.println("++");
		}

		/* y-Achse, nach oben: start groesser */
		if (xFirst == xLast && yFirst > yLast) {
			position = "E" + LastHit.charAt(1) + (yFirst + 1) + xLast;
//			System.out.println("+++");
		}
		/* y-Achse, nach unten: start kleiner */
		if (xFirst == xLast && yFirst < yLast) {
			position = "E" + LastHit.charAt(1) + (yFirst - 1) + xLast;
//			System.out.println("++++");
		}

		if (!shotList.contains(position)) {
			shotList.add(position);
		} else
			position = calculateShotCoordinates();

		return position;
	}

	// // KI3 muss das ja können? oder in die schiffe setzen methode? //////
	/** Ebene 1: Startpunkt per Zufall */
	public String calculateStartCoordsLevelOne() {
		String position;
		position = "E1" + "" + new Random().nextInt(10)
				+ new Random().nextInt(10);
		return position;
	}

	/** Ebene 2: Startpunkt per Zufall */
	public String calculateStartCoordsLevelTwo() {
		String position;
		position = "E2" + "" + new Random().nextInt(10)
				+ new Random().nextInt(10);
		return position;
	}

	/** Ebene 3: Startpunkt per Zufall */
	public String calculateStartCoordsLevelThree() {
		String position;
		position = "E3" + "" + new Random().nextInt(10)
				+ new Random().nextInt(10);
		return position;
	}

	// ////////////////////////////////////////////////////////////

	public void setShips(Battlefield feld) {
		/*
		 * In der HardOpponentSetShips werden alle Schiffe der KI 3 gesetzt und
		 * in eine Map geschrieben. Überschneidungen sind verboten
		 */

		HardOpponentSetShips hard = new HardOpponentSetShips();
		HashMap<String, Ship> kiMap = new HashMap<String, Ship>();

		kiMap = hard.getHardOpponentMap();

		// start, ende, schiff für setShip Methode benötigt
		for (String s : kiMap.keySet()) {
			feld.setShip(kiMap.get(s).getPartOne(), kiMap.get(s).getEnd(),
					kiMap.get(s));
		}

	}

}
