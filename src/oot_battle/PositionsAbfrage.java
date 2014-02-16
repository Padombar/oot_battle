package oot_battle;

import java.util.Scanner;

public class PositionsAbfrage {

	private static int ebene;
	private static int y;
	private static int x;

	public static int getEbene(String position) {
		// Ascii umwandlung
		ebene = (int) position.charAt(1) - 49;
		return ebene;

	}

	public static int getY(String position) {
		y = (position.charAt(2)) - 48;
		return y;

	}

	public static int getX(String position) {
		x = (position.charAt(3)) - 48;
		return x;
	}

	public static boolean isCoordinateValid(String position) {
		if (position.length() != 4) {
			return false;
		}
		if (PositionsAbfrage.getX(position) <= 9
				&& PositionsAbfrage.getX(position) >= 0
				&& PositionsAbfrage.getY(position) <= 9
				&& PositionsAbfrage.getY(position) >= 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isCoordinateValidAndNotSet(String position,Battlefield feld) {
		if (position.length() != 4) {
			return false;
		}if (PositionsAbfrage.getX(position) <= 9
				&& PositionsAbfrage.getX(position) >= 0
				&& PositionsAbfrage.getY(position) <= 9
				&& PositionsAbfrage.getY(position) >= 0) {

		} if(!feld.getSMap().containsKey(position)){
			return true;
		}else {
			return false;
		}

	}
}
