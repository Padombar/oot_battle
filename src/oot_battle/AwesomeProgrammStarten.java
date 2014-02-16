package oot_battle;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioSystem.getClip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import oot_battle.ki.EasyOpponent;
import oot_battle.ki.HardOpponent;
import oot_battle.ki.MiddleOpponent;
import oot_battle.ships.ShipFive;
import oot_battle.ships.ShipFour;
import oot_battle.ships.ShipOne;
import oot_battle.ships.ShipThree;
import oot_battle.ships.ShipTwo;

public class AwesomeProgrammStarten {

	private static Battlefield SP1Feld = new Battlefield();
	private static Battlefield SP2Feld = new Battlefield();
	private static Human spieler1 = new Human();
	private static Human spieler2 = new Human();

	public static void main(String[] args) throws InterruptedException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		musikStartenloop();
		logo();

		boolean richtig = false;
		int auswahl = 0;
		int index = 1;
		Thread.sleep(300);

		System.out.print("\n    ");
		for (int zeichen = 0; zeichen <= 65; zeichen++) {
			System.out.print("|");
			Thread.sleep(15);

		}
		System.out.println("\n");
		Thread.sleep(300);

		while (auswahl != 5) {

			hauptMenue();

			while (!richtig) {

				Scanner in = new Scanner(System.in);
				String zahl = in.nextLine();

				if (zahl.equals("1") || zahl.equals("2") || zahl.equals("3")
						|| zahl.equals("4") || zahl.equals("5")
						|| zahl.equals("6") || zahl.equals("31415")) {
					richtig = true;
					index = 1;
					auswahl = Integer.parseInt(zahl);

				}

				else {

					if (index == 1) {
						System.out.println(zahl + " ist ungueltig \n");
					} else if (index == 2) {
						System.out.println(zahl + " ist auch ungueltig \n");
					} else if (index == 3) {
						System.out.println(zahl
								+ " ist immer noch ungueltig \n");
					} else if (index == 4) {
						System.out.println("wie zu erwarten ist auch " + zahl
								+ " ungueltig \n");
					} else if (index == 5) {
						System.out
								.println("Und der Herr sagte Unglueltig! und "
										+ zahl + " wurde ungueltig\n");
					} else if (index == 6) {
						System.out.println("und ungueltig! \n");
					} else if (index == 8) {
						System.out.println("das reicht! \n");
					} else {
						System.out.println("ungueltig! \n");
					}

					if (index == 1) {
						Thread.sleep(200);
						System.out
								.println("              Bitte waehlen sie eine Zahl zwischen 1 und 6");

						System.out.print("\n    ");
						for (int zeichen = 0; zeichen <= 65; zeichen++) {
							System.out.print("|");
							Thread.sleep(2);

						}
						System.out.println("\n");
						Thread.sleep(300);

						index++;
					} else if (index == 2) {
						Thread.sleep(200);
						System.out
								.println("                          ZWISCHEN 1 und 5 waehlen!");

						System.out.print("\n    ");
						for (int zeichen = 0; zeichen <= 65; zeichen++) {
							System.out.print("|");
							Thread.sleep(2);

						}
						System.out.println("\n");
						Thread.sleep(300);
						index++;
					} else if (index == 3) {
						Thread.sleep(200);
						System.out
								.println("                 Nur 1, 2, 3, 4 ODER 5 stehen zur Auswahl!");

						System.out.print("\n    ");
						for (int zeichen = 0; zeichen <= 65; zeichen++) {
							System.out.print("|");
							Thread.sleep(2);

						}
						System.out.println("\n");
						Thread.sleep(300);
						index++;
					} else if (index == 4) {
						Thread.sleep(200);
						System.out
								.println("                 Lassen sie jemand anderes an das Spiel");
						System.out.print("\n    ");
						for (int zeichen = 0; zeichen <= 65; zeichen++) {
							System.out.print("|");
							Thread.sleep(2);

						}
						System.out.println("\n");
						Thread.sleep(300);
						index++;
					} else if (index == 5) {
						Thread.sleep(200);
						System.out
								.println("           ... Sie wuerden das Spiel sowieso nicht verstehen");

						System.out.print("\n    ");
						for (int zeichen = 0; zeichen <= 65; zeichen++) {
							System.out.print("|");
							Thread.sleep(2);

						}
						System.out.println("\n");
						Thread.sleep(300);
						index++;
					} else if (index == 6) {
						Thread.sleep(200);
						System.out
								.println("      ... wie haben sie ueberhaupt es geschafft den PC zu starten");

						System.out.print("\n    ");
						for (int zeichen = 0; zeichen <= 65; zeichen++) {
							System.out.print("|");
							Thread.sleep(2);

						}
						System.out.println("\n");
						Thread.sleep(300);
						index++;
					} else if (index == 6) {
						Thread.sleep(200);
						System.out
								.println("                   Koennen sie ueberhaupt lesen?");

						System.out.print("\n    ");
						for (int zeichen = 0; zeichen <= 65; zeichen++) {
							System.out.print("|");
							Thread.sleep(2);

						}
						System.out.println("\n");
						Thread.sleep(300);
						index++;
					} else if (index == 7) {
						Thread.sleep(200);
						System.out
								.println("                       VER STEH HEN SIE MICH?");

						System.out.print("\n    ");
						for (int zeichen = 0; zeichen <= 65; zeichen++) {
							System.out.print("|");
							Thread.sleep(2);

						}
						System.out.println("\n");
						Thread.sleep(300);
						index++;
					} else if (index == 8) {
						Thread.sleep(200);
						System.out
								.println("                       gebe auf, bin raus hier");
						System.out.print("\n    ");
						for (int zeichen = 0; zeichen <= 65; zeichen++) {
							System.out.print("|");
							Thread.sleep(2);

						}
						System.out.println("\n\n");
						Thread.sleep(300);
						// Beenden
						auswahl = 5;
						richtig = true;
					}

				}

			}
			index = 1;
			richtig = false;

			switch (auswahl) {
			case 1:

				// spieler vs spieler
				int start = 0;

				verhandlungen();

				while (!richtig) {

					Scanner in = new Scanner(System.in);
					String wahl = in.nextLine();

					if (wahl.equals("1") || wahl.equals("2")
							|| wahl.equals("3")) {
						if (wahl.equals("1")) {
							start = 1;
						} else if (wahl.equals("2")) {
							start = 2;
						} else if (wahl.equals("3")) {
							start = muenzeWerfen();
						}

						richtig = true;

					} else {
						System.out.println(" 1, 2 oder 3 eingeben \n");
					}

				}
				switch (start) {

				// spieler first
				case 1:
					sp1Setzen();
					zugBeendet();
					sp2Setzen();
					zugBeendet();

					while (SP1Feld.isGameRunning() || SP2Feld.isGameRunning()) {
						System.out.println("");
						sp1Schiessen();
						if (!isRunning()) {
							break;
						}
						zugBeendet();
						sp2Schiessen();
						if (!isRunning()) {
							break;
						}
						zugBeendet();
					}
					if (!SP1Feld.isGameRunning()) {
						spielBeenden(2);
					} else if (!SP2Feld.isGameRunning()) {
						spielBeenden(1);
					}

					break;
				case 2:
					// Spieler 2 first
					sp2Setzen();
					zugBeendet();
					sp1Setzen();
					zugBeendet();
boolean halt= false;
while(!halt){
					while (SP1Feld.isGameRunning() && SP2Feld.isGameRunning()) {
						sp2Schiessen();
						if (!isRunning()) {
							
							break;
						}
						
					}
						zugBeendet();
						sp1Schiessen();
						if (!isRunning()) {
							break;
						}
						zugBeendet();
					}
					if (!SP1Feld.isGameRunning()) {
						spielBeenden(2);
					} else if (!SP2Feld.isGameRunning()) {
						spielBeenden(1);
					}
					break;
				}

				break;

			// KI AUSWAHL
			case 2:
				start = 0;
				kiAuswahl();

				while (!richtig) {

					Scanner in = new Scanner(System.in);
					String wahl = in.nextLine();

					if (wahl.equals("1") || wahl.equals("2")
							|| wahl.equals("3")) {
						if (wahl.equals("1")) {
							start = 1;
						} else if (wahl.equals("2")) {
							start = 2;
						} else if (wahl.equals("3")) {
							start = 3;
						}

						richtig = true;

					} else {
						System.out.println(" 1, 2 oder 3 eingeben \n");
					}

				}
				switch (start) {

				// Easy auswahl
				case 1:
					start = 0;
					EasyOpponent kI = new EasyOpponent();

					verhandlungen();

					richtig = false;

					System.out
							.println("                         KI = Spieler 2\n");
					while (!richtig) {

						Scanner in = new Scanner(System.in);
						String wahl = in.nextLine();

						if (wahl.equals("1") || wahl.equals("2")
								|| wahl.equals("3")) {
							if (wahl.equals("1")) {
								start = 1;
							} else if (wahl.equals("2")) {
								start = 2;
							} else if (wahl.equals("3")) {
								start = muenzeWerfen();
							}

							richtig = true;

						} else {
							System.out.println(" 1, 2 oder 3 eingeben \n");
						}

					}
					switch (start) {

					// PLAYER FIRST
					case 1:

						sp1Setzen();
						zugBeendetkI(2);
						kI.setShips(SP2Feld);
						zugBeendet();

						while (SP1Feld.isGameRunning()
								|| SP2Feld.isGameRunning()) {
							System.out.println("");
							sp1Schiessen();
							if (!isRunning()) {
								break;
							}
							zugBeendetkI(2);
							kI.shot(SP1Feld);
							if (!isRunning()) {
								break;
							}
							zugBeendet();
						}
						if (!SP1Feld.isGameRunning()) {
							spielBeenden(2);
						} else if (!SP2Feld.isGameRunning()) {
							spielBeendenkI();
						}

						break;

					// Ki FIRST
					case 2:
						kI.setShips(SP1Feld);
						zugBeendet();
						sp2Setzen();
						zugBeendetkI(1);

						while (SP1Feld.isGameRunning()
								|| SP2Feld.isGameRunning()) {
							System.out.println("");
							kI.shot(SP2Feld);
							if (!isRunning()) {
								break;
							}
							zugBeendet();
							sp2Schiessen();
							if (!isRunning()) {
								break;
							}
							zugBeendetkI(1);
						}
						if (!SP1Feld.isGameRunning()) {
							spielBeendenkI();
						} else if (!SP2Feld.isGameRunning()) {
							spielBeenden(1);
						}

						break;
					}

					break;

				// middle KI
				case 2:
					start = 0;
					MiddleOpponent kIM = new MiddleOpponent();

					verhandlungen();

					richtig = false;

					System.out
							.println("                         KI = Spieler 2\n");
					while (!richtig) {

						Scanner in = new Scanner(System.in);
						String wahl = in.nextLine();

						if (wahl.equals("1") || wahl.equals("2")
								|| wahl.equals("3")) {
							if (wahl.equals("1")) {
								start = 1;
							} else if (wahl.equals("2")) {
								start = 2;
							} else if (wahl.equals("3")) {
								start = muenzeWerfen();
							}

							richtig = true;

						} else {
							System.out.println(" 1, 2 oder 3 eingeben \n");
						}

					}
					switch (start) {

					// PLAYER FIRST
					case 1:

						sp1Setzen();
						zugBeendetkI(2);
						kIM.setShips(SP2Feld);
						zugBeendet();

						while (SP1Feld.isGameRunning()
								|| SP2Feld.isGameRunning()) {
							System.out.println("");
							sp1Schiessen();
							if (!isRunning()) {
								break;
							}
							zugBeendetkI(2);
							kIM.shot(SP1Feld);
							if (!isRunning()) {
								break;
							}
							zugBeendet();
						}
						if (!SP1Feld.isGameRunning()) {
							spielBeenden(2);
						} else if (!SP2Feld.isGameRunning()) {
							spielBeendenkI();
						}

						break;

					// Ki FIRST
					case 2:
						kIM.setShips(SP1Feld);
						zugBeendet();
						sp2Setzen();
						zugBeendetkI(1);

						while (SP1Feld.isGameRunning()
								|| SP2Feld.isGameRunning()) {
							System.out.println("");
							kIM.shot(SP2Feld);
							if (!isRunning()) {
								break;
							}
							zugBeendet();
							sp2Schiessen();
							if (!isRunning()) {
								break;
							}
							zugBeendetkI(1);
						}
						if (!SP1Feld.isGameRunning()) {
							spielBeendenkI();
						} else if (!SP2Feld.isGameRunning()) {
							spielBeenden(1);
						}

						break;
					}

					break;

				// hard KI
				case 3:
					start = 0;

					verhandlungen();

					while (!richtig) {

						Scanner in = new Scanner(System.in);
						String wahl = in.nextLine();

						if (wahl.equals("1") || wahl.equals("2")
								|| wahl.equals("3")) {
							if (wahl.equals("1")) {
								start = 1;
							} else if (wahl.equals("2")) {
								start = 2;
							} else if (wahl.equals("3")) {
								start = muenzeWerfen();
							}

							richtig = true;

						} else {
							System.out.println(" 1, 2 oder 3 eingeben \n");
						}

					}
					switch (start) {

					case 1:

						break;
					case 2:

						break;
					}

					break;
				}

				break;
			case 3:

				// KI vs KI

				start = 0;
				kiVkiAuswahl();

				while (!richtig) {

					Scanner in = new Scanner(System.in);
					String wahl = in.nextLine();

					if (wahl.equals("1") || wahl.equals("2")
							|| wahl.equals("3") || wahl.equals("4")|| wahl.equals("5")) {
						if (wahl.equals("1")) {
							start = 1;
						} else if (wahl.equals("2")) {
							start = 2;
						} else if (wahl.equals("3")) {
							start = 3;
						} else if (wahl.equals("4")) {
							start = 4;
						}else if (wahl.equals("5")) {
							start = 5;
						}

						richtig = true;

					} else {
						System.out.println(" 1, 2 oder 3 eingeben \n");
					}

				}
				switch (start) {

				// Easy auswahl ki vs ki

				case 1:
					System.out.println("Easy  KI vs Easy KI");
					EasyOpponent kI = new EasyOpponent();
					EasyOpponent kI2 = new EasyOpponent();

					kI.setShips(SP1Feld);
					zugBeendetkI(2);
					kI2.setShips(SP2Feld);
					zugBeendetkI(1);

					while (SP1Feld.isGameRunning() || SP2Feld.isGameRunning()) {
						System.out.println("");
						kI.shot(SP2Feld);
						if (!isRunning()) {
							break;
						}


						kI2.shot(SP1Feld);
						if (!isRunning()) {
							break;
						}


					}

					if (!SP1Feld.isGameRunning()) {

						spielBeendenkI();
					} else if (!SP2Feld.isGameRunning()) {

						spielBeendenkI();
					}
					break;

				// middle KI ki vs ki
				case 2:
					System.out.println("Middle KI vs Middle KI");
					MiddleOpponent kIM = new MiddleOpponent();
					MiddleOpponent kIM2 = new MiddleOpponent();

					kIM.setShips(SP1Feld);
					zugBeendetkI(2);
					kIM2.setShips(SP2Feld);
					zugBeendetkI(1);

					while (SP1Feld.isGameRunning() || SP2Feld.isGameRunning()) {
						System.out.println("");
						kIM.shot(SP2Feld);
						if (!isRunning()) {
							break;
						}


						kIM2.shot(SP1Feld);
						if (!isRunning()) {
							break;
						}


					}
					

					
					if (!SP1Feld.isGameRunning()) {

						spielBeendenkI();
					} else if (!SP2Feld.isGameRunning()) {

						spielBeendenkI();
					}
					break;

				// hard KI ki vs ki
				case 3:
					System.out.println("Hard KI vs Hard KI");
					HardOpponent kIH = new HardOpponent();
					HardOpponent kIH2 = new HardOpponent();

					kIH.setShips(SP1Feld);
					zugBeendetkI(2);
					kIH2.setShips(SP2Feld);
					zugBeendetkI(1);

					while (SP1Feld.isGameRunning() || SP2Feld.isGameRunning()) {
						System.out.println("");
						kIH.shot(SP2Feld);
						if (!isRunning()) {
							break;
						}



						kIH2.shot(SP1Feld);
						if (!isRunning()) {
							break;
						}



					}
					
					if (!SP1Feld.isGameRunning()) {
						spielBeendenkI();
					} else if (!SP2Feld.isGameRunning()) {
						spielBeendenkI();
					}
					break;

				case 4:
					// Fremd Ki
					// start = 0;
					// HardOpponent kI = new HardOpponent();
					//
					// verhandlungen();
					//
					// richtig = false;
					//
					// System.out
					// .println("                         Externe KI = Spieler 2\n");
					// while (!richtig) {
					//
					// Scanner in = new Scanner(System.in);
					// String wahl = in.nextLine();
					//
					// if (wahl.equals("1") || wahl.equals("2")
					// || wahl.equals("3")) {
					// if (wahl.equals("1")) {
					// start = 1;
					// } else if (wahl.equals("2")) {
					// start = 2;
					// } else if (wahl.equals("3")) {
					// start = muenzeWerfen();
					// }
					//
					// richtig = true;
					//
					// } else {
					// System.out.println(" 1, 2 oder 3 eingeben \n");
					// }
					//
					// }
					// switch (start) {
					//
					// // Ki FIRST
					// case 1:
					//
					// sp1Setzen();
					// zugBeendetkI(2);
					// kI.setShips(SP2Feld);
					// zugBeendet();
					//
					// while (SP1Feld.isGameRunning()
					// || SP2Feld.isGameRunning()) {
					// System.out.println("");
					// sp1Schiessen();
					// if (!isRunning()) {
					// break;
					// }
					// zugBeendetkI(2);
					// kI.shot(SP1Feld);
					// if (!isRunning()) {
					// break;
					// }
					// zugBeendet();
					// }
					// if (!SP1Feld.isGameRunning()) {
					// spielBeenden(2);

					// } else if (!SP2Feld.isGameRunning()) {
					// spielBeendenkI();

					// }
					//
					// break;
					//
					// // externe Ki FIRST
					// case 2:
					// Gruppe2.youAreFirst();
					// kI.setShips(SP1Feld);
					// zugBeendet();
					// sp2Setzen();
					// zugBeendetkI(1);
					//
					// while (SP1Feld.isGameRunning()
					// || SP2Feld.isGameRunning()) {
					// System.out.println("");
					// kI.shot(SP2Feld);
					// if (!isRunning()) {
					// break;
					// }
					// zugBeendet();
					// sp2Schiessen();
					// if (!isRunning()) {
					// break;
					// }
					// zugBeendetkI(1);
					// }
					// if (!SP1Feld.isGameRunning()) {
					// spielBeendenkI();
					// } else if (!SP2Feld.isGameRunning()) {
					// spielBeenden(1);
					// }
					//
					// break;
					// }
					//
					break;
					
				case 5:
					break;
				}
			case 4:
				credits();

				break;
			case 5:
				beenden();
				// um noch music zu stoppen
				System.exit(0);
				break;

			case 6:
				anleitung();
				break;

			// case 3141:
			// System.out.println("ki vs KI");
			// EasyOpponent kI = new EasyOpponent();
			// EasyOpponent kI2 = new EasyOpponent();
			//
			// kI2.setShips(SP1Feld);
			// zugBeendetkI(2);
			// kI.setShips(SP2Feld);
			// zugBeendetkI(1);
			//
			// while (SP1Feld.isGameRunning()
			// || SP2Feld.isGameRunning()) {
			// System.out.println("");
			// kI2.shot(SP2Feld);
			// if (!isRunning()) {
			// break;
			// }
			// SP2Feld.printFeld();
			// Thread.sleep(1000);
			// zugBeendetkI(2);
			// kI.shot(SP1Feld);
			// if (!isRunning()) {
			// break;
			// }
			// SP1Feld.printFeld();
			// Thread.sleep(1000);
			// zugBeendetkI(1);
			// }
			// if (!SP1Feld.isGameRunning()) {
			// spielBeenden(2);
			// } else if (!SP2Feld.isGameRunning()) {
			// spielBeenden(1);
			// }
			//
			// break;

//			case 31415:
//				System.out.println("ki vs KI Wrapper");
//				MiddleOpponent kIM = new MiddleOpponent();
//				WrapperTestKi wKI= new WrapperTestKi();
//
//				kIM.setShips(SP1Feld);
//				zugBeendetkI(2);
//				wKI.setShips();
//				zugBeendetkI(1);
//
//				while (SP1Feld.isGameRunning() || SP2Feld.isGameRunning()) {
//					System.out.println("");
//					kIM.shot(SP2Feld);
//					if (!isRunning()) {
//						break;
//					}
//					SP2Feld.printFeld();
//					Thread.sleep(1000);
//					zugBeendetkI(2);
//					wKI.shot();
//					if (!isRunning()) {
//						break;
//					}
//					SP1Feld.printFeld();
//					Thread.sleep(1000);
//					zugBeendetkI(1);
//				}
//				if (!SP1Feld.isGameRunning()) {
//					spielBeenden(2);
//				} else if (!SP2Feld.isGameRunning()) {
//					spielBeenden(1);
//				}
//
//				break;
			}

		}
	}

	private static void feldAnzeigen(Battlefield feld)
			throws InterruptedException {
		feld.printFeld();
		Thread.sleep(1000);

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

	// private static int coordScannerEbene() {
	//
	// boolean richtig = false;
	// int auswahl = 0;
	//
	// while (!richtig) {
	//
	// Scanner in = new Scanner(System.in);
	// String zahl = in.nextLine();
	//
	// if (zahl.equals("1") || zahl.equals("2") || zahl.equals("3")) {
	// richtig = true;
	// auswahl = Integer.parseInt(zahl);
	// richtig = true;
	//
	// } else
	// System.out
	// .println("\n                    ungueltige Eingabe bitte nur zahlen zwischen 1-3 verwenden\n\n");
	// }
	//
	// return auswahl;
	//
	// }

	private static void credits() throws InterruptedException {

		int hierHastDuDeineKonstante = 15;
		int timer = 20;

		System.out.println("Credits werden angezeigt\n");
		System.out.println("                            __________________");
		System.out.println("                           |  CODE EVOLUTION  |");
		System.out.println("                           |__________________|");
		System.out.print("\n    ");
		for (int zeichen = 0; zeichen <= 65; zeichen++) {
			System.out.print("|");
			Thread.sleep(10);

		}
		System.out.println("\n\n");
		Thread.sleep(500);
		System.out.print("                         T");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("a");
		Thread.sleep(timer);
		System.out.print("m");
		Thread.sleep(timer);
		System.out.print("l");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("i");
		Thread.sleep(timer);
		System.out.print("t");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("r");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("/");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("G");
		Thread.sleep(timer);
		System.out.print("r");
		Thread.sleep(timer);
		System.out.print("u");
		Thread.sleep(timer);
		System.out.print("p");
		Thread.sleep(timer);
		System.out.print("p");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("n");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("M");
		Thread.sleep(timer);
		System.out.print("o");
		Thread.sleep(timer);
		System.out.print("t");
		Thread.sleep(timer);
		System.out.print("i");
		Thread.sleep(timer);
		System.out.print("v");
		Thread.sleep(timer);
		System.out.print("a");
		Thread.sleep(timer);
		System.out.print("t");
		Thread.sleep(timer);
		System.out.print("o");
		Thread.sleep(timer);
		System.out.print("r\n\n");
		Thread.sleep(500);
		System.out.print("\n                             P");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("h");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("l");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("p");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("D");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(".");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("T");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("h");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("l");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e\n\n\n");
		Thread.sleep(500);
		System.out.print("                         A");
		Thread.sleep(timer);
		System.out.print("n");
		Thread.sleep(timer);
		System.out.print("a");
		Thread.sleep(timer);
		System.out.print("l");
		Thread.sleep(timer);
		System.out.print("y");
		Thread.sleep(timer);
		System.out.print("s");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("&");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("D");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("s");
		Thread.sleep(timer);
		System.out.print("i");
		Thread.sleep(timer);
		System.out.print("g");
		Thread.sleep(timer);
		System.out.print("n");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("/");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("H");
		Thread.sleep(timer);
		System.out.print("u");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("t");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("r");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("a");
		Thread.sleep(timer);
		System.out.print("l");
		Thread.sleep(timer);
		System.out.print("l");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("r");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("D");
		Thread.sleep(timer);
		System.out.print("i");
		Thread.sleep(timer);
		System.out.print("a");
		Thread.sleep(timer);
		System.out.print("g");
		Thread.sleep(timer);
		System.out.print("r");
		Thread.sleep(timer);
		System.out.print("a");
		Thread.sleep(timer);
		System.out.print("m");
		Thread.sleep(timer);
		System.out.print("m");
		Thread.sleep(timer);
		System.out.print("e\n\n");
		Thread.sleep(timer);
		System.out.print("                             N");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("u");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("c");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("a");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("z\n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("                             I");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("s");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("K");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("h");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("l");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r\n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("                             N");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("a");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("g");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("S");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("u");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("v");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("a");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("a");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("v");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("g\n\n\n");
		Thread.sleep(500);

		System.out.print("                         P");
		Thread.sleep(timer);
		System.out.print("r");
		Thread.sleep(timer);
		System.out.print("o");
		Thread.sleep(timer);
		System.out.print("g");
		Thread.sleep(timer);
		System.out.print("r");
		Thread.sleep(timer);
		System.out.print("a");
		Thread.sleep(timer);
		System.out.print("m");
		Thread.sleep(timer);
		System.out.print("m");
		Thread.sleep(timer);
		System.out.print("i");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("r");
		Thread.sleep(timer);
		System.out.print("u");
		Thread.sleep(timer);
		System.out.print("n");
		Thread.sleep(timer);
		System.out.print("g");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("/");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("B");
		Thread.sleep(timer);
		System.out.print("u");
		Thread.sleep(timer);
		System.out.print("c");
		Thread.sleep(timer);
		System.out.print("h");
		Thread.sleep(timer);
		System.out.print("s");
		Thread.sleep(timer);
		System.out.print("t");
		Thread.sleep(timer);
		System.out.print("a");
		Thread.sleep(timer);
		System.out.print("b");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("n");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("z");
		Thread.sleep(timer);
		System.out.print("u");
		Thread.sleep(timer);
		System.out.print("o");
		Thread.sleep(timer);
		System.out.print("r");
		Thread.sleep(timer);
		System.out.print("d");
		Thread.sleep(timer);
		System.out.print("n");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("r\n\n");
		Thread.sleep(timer);
		System.out.print("                             E");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("u");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("g");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("J");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("a");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("s");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("t");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("m");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("s");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("k");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("j\n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("                             M");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("a");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("k");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("u");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("s");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("F");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("d");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("t\n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("                             M");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("h");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("S");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("T");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("u");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("g\n\n\n");
		Thread.sleep(timer);
		System.out.print("                         T");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("s");
		Thread.sleep(timer);
		System.out.print("t");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("r");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("/");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("B");
		Thread.sleep(timer);
		System.out.print("u");
		Thread.sleep(timer);
		System.out.print("g");
		Thread.sleep(timer);
		System.out.print("h");
		Thread.sleep(timer);
		System.out.print("u");
		Thread.sleep(timer);
		System.out.print("n");
		Thread.sleep(timer);
		System.out.print("t");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("r\n\n");
		Thread.sleep(timer);
		System.out.print("                             M");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("a");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("D");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("t");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("c");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("h\n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("                             J");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("u");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("l");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("W");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("l");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("b");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("a");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("c");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("h\n\n\n");
		Thread.sleep(500);

		System.out.print("                         S");
		Thread.sleep(timer);
		System.out.print("p");
		Thread.sleep(timer);
		System.out.print("e");
		Thread.sleep(timer);
		System.out.print("c");
		Thread.sleep(timer);
		System.out.print("i");
		Thread.sleep(timer);
		System.out.print("a");
		Thread.sleep(timer);
		System.out.print("l");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("t");
		Thread.sleep(timer);
		System.out.print("h");
		Thread.sleep(timer);
		System.out.print("a");
		Thread.sleep(timer);
		System.out.print("n");
		Thread.sleep(timer);
		System.out.print("k");
		Thread.sleep(timer);
		System.out.print("s");
		Thread.sleep(timer);
		System.out.print(" ");
		Thread.sleep(timer);
		System.out.print("t");
		Thread.sleep(timer);
		System.out.print("o\n\n");
		Thread.sleep(timer);
		System.out.print("                             M");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("a");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("c");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("S");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("t");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("p");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("p\n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("                             f");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("b");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("g");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("M");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("a");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("c");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("S");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("t");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("p");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("p\n\n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("                             G");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("l");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("u");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("h");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("w");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n\n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("                             f");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("o");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("r");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("b");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("g");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print(" ");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("G");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("l");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("u");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("h");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("w");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("e");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("i");
		Thread.sleep(hierHastDuDeineKonstante);
		System.out.print("n\n\n\n");
		Thread.sleep(1000);
		Thread.sleep(90);
		System.out.print("                        i");
		Thread.sleep(90);
		System.out.print("n");
		Thread.sleep(90);
		System.out.print(" ");
		Thread.sleep(90);
		System.out.print("m");
		Thread.sleep(90);
		System.out.print("e");
		Thread.sleep(90);
		System.out.print("m");
		Thread.sleep(90);
		System.out.print("o");
		Thread.sleep(90);
		System.out.print("r");
		Thread.sleep(90);
		System.out.print("y");
		Thread.sleep(90);
		System.out.print(" ");
		Thread.sleep(90);
		System.out.print("o");
		Thread.sleep(90);
		System.out.print("f");
		Thread.sleep(90);
		System.out.print(" ");
		Thread.sleep(90);
		System.out.print("G");
		Thread.sleep(90);
		System.out.print("l");
		Thread.sleep(90);
		System.out.print("u");
		Thread.sleep(90);
		System.out.print("e");
		Thread.sleep(90);
		System.out.print("h");
		Thread.sleep(90);
		System.out.print("w");
		Thread.sleep(90);
		System.out.print("e");
		Thread.sleep(90);
		System.out.print("i");
		Thread.sleep(90);
		System.out.print("n\n");
		Thread.sleep(1000);
		System.out.print("                             R");
		Thread.sleep(200);
		System.out.print("e");
		Thread.sleep(80);
		System.out.print("s");
		Thread.sleep(80);
		System.out.print("t");
		Thread.sleep(80);
		System.out.print(" ");
		Thread.sleep(80);
		System.out.print("i");
		Thread.sleep(200);
		System.out.print("n");
		Thread.sleep(80);
		System.out.print(" ");
		Thread.sleep(80);
		System.out.print("p");
		Thread.sleep(200);
		System.out.print("e");
		Thread.sleep(80);
		System.out.print("a");
		Thread.sleep(80);
		System.out.print("c");
		Thread.sleep(80);
		System.out.print("e\n\n");
		Thread.sleep(1500);

		System.out
				.println("   ____________________________________________________________________\n\n\n\n\n");

		Thread.sleep(800);

		System.out.print("\n    ");
		for (int zeichen = 0; zeichen <= 65; zeichen++) {
			System.out.print("|");
			Thread.sleep(10);

		}
		System.out.println("\n\n");
		Thread.sleep(800);

	}

	private static void beenden() throws InterruptedException {

		System.out.println("Programm wird beendet");
		Thread.sleep(100);
		System.out.println("\nwird nicht gespeichert, bitte warten\n");
		Thread.sleep(1500);
		System.out.print("0% ");
		Thread.sleep(1000);
		System.out.print("1% ");
		Thread.sleep(280);
		System.out.print("4% ");
		Thread.sleep(100);
		System.out.print("5% ");
		Thread.sleep(10);
		System.out.print("6% ");
		Thread.sleep(80);
		System.out.print("8% ");
		Thread.sleep(30);
		System.out.print("10% ");
		Thread.sleep(100);
		System.out.print("14% ");
		Thread.sleep(50);
		System.out.print("18% ");
		Thread.sleep(80);
		System.out.print("20% ");
		Thread.sleep(800);
		System.out.print("36% ");
		Thread.sleep(400);
		System.out.print("48% ");
		Thread.sleep(800);
		System.out.print("61% ");
		Thread.sleep(800);
		System.out.print("66% ");
		Thread.sleep(1500);
		System.out.print("73% ");
		Thread.sleep(500);
		System.out.print("79% ");
		Thread.sleep(300);
		System.out.print("81% ");
		Thread.sleep(400);
		System.out.print("94% ");
		Thread.sleep(200);
		System.out.print("99% ");
		Thread.sleep(2800);
		System.out.print("54% ");
		Thread.sleep(2000);
		System.out.print("28% ");
		Thread.sleep(500);
		System.out.print("46% ");
		Thread.sleep(300);
		System.out.print("13%\n\n");
		Thread.sleep(1000);
		System.out.println("436f64652045766f6c7574696f6e21 %\n");
		Thread.sleep(1800);

		System.out.println("nicht speichern erfolgreich\n");
		Thread.sleep(500);
		System.out.println("Programm beendet");

	}

	private static void spielBeenden(int gewinner) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		int win = gewinner;
		System.out.print("\n    ");
		for (int zeichen = 0; zeichen <= 60; zeichen++) {
			System.out.print("|");
			Thread.sleep(15);
		}
		System.out
				.println("\n\n            ____________________________________________________");
		System.out
				.println("           |     Spiel Beende! wuuhuuhuuuhuuhuuhuuhuu...        |");
		System.out.println("           |          Spieler " + win
				+ " hat geonnen                 |");
		System.out
				.println("           | Drucken sie die Beliebige Taste, aber keine andere |");
		System.out
				.println("           |____________________________________________________|\n");
		musikSieg();
		Scanner enter = new Scanner(System.in);
		String zahl = enter.nextLine();

	}

	private static void spielBeendenkI() throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		SP1Feld.printFeld();
		SP2Feld.printFeld();
		
		System.out.print("\n    ");
		for (int zeichen = 0; zeichen <= 60; zeichen++) {
			System.out.print("|");
			Thread.sleep(15);
		}
		System.out
				.println("\n\n            ____________________________________________________");
		System.out
				.println("           |     Spiel Beende! wuuhuuhuuuhuuhuuhuuhuu...        |");
		System.out
				.println("           |                     KI hat geonnen                    |");
		System.out
				.println("           | Drucken sie die Beliebige Taste, aber keine andere |");
		System.out
				.println("           |____________________________________________________|\n");
		musikSieg();
		Scanner enter = new Scanner(System.in);
		String zahl = enter.nextLine();

	}

	private static int muenzeWerfen() throws InterruptedException {
		System.out
				.println("                         Spieler 1 Kopf oder Zahl? \n");
		Thread.sleep(100);
		int sp1 = 0;

		int win = 0;
		boolean richtig = false;
		while (!richtig) {

			System.out.println("                         1) kopf \n"
					+ "                         2) zahl \n ");

			Scanner in = new Scanner(System.in);
			String wahl = in.nextLine();

			if (wahl.equals("1") || wahl.equals("2")) {
				if (wahl.equals("1")) {
					sp1 = 1;
				} else if (wahl.equals("2")) {
					sp1 = 2;
				}
				richtig = true;

			} else {
				System.out.println("1 oder 2 eingeben");
			}

		}
		int zahl = (int) ((Math.random() * (3 - 1)) + 1);

		System.out.println("                         Muenze wird geworfen\n"
				+ "                          (#) = Kopf\n"
				+ "                          (1) = Zahl\n");
		Thread.sleep(1500);

		System.out.print("\n    ");
		for (int zeichen = 0; zeichen <= 60; zeichen++) {
			System.out.print("|");
			Thread.sleep(15);
		}
		System.out.println("\n");

		int speed = 200;
		for (int fall = 1; fall <= 3; fall++) {

			System.out.print("  (1)");
			Thread.sleep(speed);
			System.out.print("  ()");
			Thread.sleep(speed);
			speed = speed - 10;
			System.out.print("  O");
			Thread.sleep(speed);
			System.out.print("  ()");
			Thread.sleep(speed);
			System.out.print("  (Û)");
			Thread.sleep(speed);
			speed = speed - 10;
			System.out.print("  ()");
			Thread.sleep(speed);
			System.out.print("  O");
			Thread.sleep(speed);
			speed = speed - 10;
			System.out.print("  ()");
			speed = speed - 20;
		}
		Thread.sleep(50);

		if (zahl == 1) {
			System.out.print("  (1)");
			Thread.sleep(speed);
			System.out.print("  ()");
			Thread.sleep(speed);
			System.out.print("  O");
			speed = speed - 10;
			Thread.sleep(speed);
			System.out.print("  ()");
			Thread.sleep(speed);
			System.out.print("  (Û) <--");
			Thread.sleep(800);

			System.out.println("\n\n                             (#)  Kopf!");
			if (zahl == sp1) {
				System.out
						.println("\n                         Spieler 1 gewinnt!\n");
				Thread.sleep(1500);
				win = 1;
			} else {
				System.out
						.println("\n                         Spieler 2 gewinnt!\n");
				Thread.sleep(1500);
				win = 2;
			}

		} else if (zahl == 2) {
			System.out.print("  (1) <--");
			Thread.sleep(800);
			System.out.println("\n\n                             (1)  Zahl");

			if (zahl == sp1) {
				System.out
						.println("\n                         Spieler 1 gewinnt!\n");
				Thread.sleep(1500);
				win = 1;
			} else {
				System.out
						.println("\n                         Spieler 2 gewinnt!\n");
				Thread.sleep(1500);
				win = 2;
			}

		}
		return win;
	}

	private static void sp1Setzen() throws InterruptedException {

		boolean stop = false;

		System.out.print("\n    ");
		for (int zeichen = 0; zeichen <= 65; zeichen++) {
			System.out.print("|");
			Thread.sleep(10);

		}
		System.out.println("\n\n");
		Thread.sleep(300);

		System.out.println("                           ________________");
		System.out.println("                          |    Spieler 1   |");
		System.out.println("                          | Schiffe setzen |");
		System.out.println("                          |________________|\n\n");
		Thread.sleep(800);
		System.out.println("                            _________");
		System.out.println("                         0 | Ebene 1 |");
		System.out.println("                         1 |_________|");
		System.out.println("                        ... 0 1 2 3 ...\n\n");
		Thread.sleep(500);

		int xA;
		int yA;
		String startKoord = "";
		String endKoord = "";
		while (!stop) {
			System.out
					.println("                    Start Koordinate des\n"
							+ "                    Schiff der laenge 5 [5][5][5][5][5]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: Y-Achse:");

			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			yA = coordScanner();

			System.out
					.println("                    Schiff der laenge 5 [5][5][5][5][5]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: X-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			xA = coordScanner();

			// Koord wird erstellt

			startKoord = "E1" + yA + xA;

			// berechnung der endCoord

			// HIIIIIEEEEERRRRRR
			endKoord = HumanShipCalculation.calculateEndCoordinates(startKoord,
					5, SP1Feld);

			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
					SP1Feld)) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");

			} else if (endKoord.equals("banane")) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");
			} else {
				stop = true;
			}
		}
		stop = false;

		System.out.println("Startpunkt: " + startKoord + " Endpunkt: "
				+ endKoord);

		Thread.sleep(100);

		System.out.println("Schiff wird gesetzt \n");

		ShipFive banane1 = new ShipFive(startKoord, endKoord);

		spieler1.setShip(startKoord, endKoord, SP1Feld, banane1);

		// SP1Feld.setShip(startKoord, endKoord, banane1);

		feldAnzeigen(SP1Feld);

		while (!stop) {

			System.out
					.println("                    Start Koordinate des\n"
							+ "                    Schiff der laenge 4 [4][4][4][4]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: Y-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			yA = coordScanner();

			System.out
					.println("                    Schiff der laenge 4 [4][4][4][4]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: X-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			xA = coordScanner();

			startKoord = "E1" + yA + xA;
			// HHHHHHIIIIIIIEEEEEERRRRRRR
			endKoord = HumanShipCalculation.calculateEndCoordinates(startKoord,
					4, SP1Feld);
			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
					SP1Feld)) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");

			} else if (endKoord.equals("banane")) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");
			} else {
				stop = true;
			}
		}
		stop = false;

		// Bis hier ge while

		System.out.println("Startpunkt: " + startKoord + " Endpunkt: "
				+ endKoord);
		Thread.sleep(100);
		System.out.println("Schiff wird gesetzt \n");

		ShipFour banane5 = new ShipFour(startKoord, endKoord);

		spieler1.setShip(startKoord, endKoord, SP1Feld, banane5);
		// SP1Feld.setShip(startKoord, endKoord, banane5);

		feldAnzeigen(SP1Feld);

		// Schiff 2
		while (!stop) {
			System.out.println("                    Start Koordinate des\n"
					+ "                    Schiff der laenge 2 [2][2]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: Y-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			yA = coordScanner();

			System.out
					.println("                    Schiff der laenge 4 [2][2]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: X-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			xA = coordScanner();

			startKoord = "E1" + yA + xA;

			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
					SP1Feld)) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");

			} else if (endKoord.equals("banane")) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");
			} else {
				stop = true;
			}
		}

		stop = false;

		// HHHIIIIEEERRRRR
		endKoord = HumanShipCalculation.calculateEndCoordinates(startKoord, 2,
				SP1Feld);

		// hier
		System.out.println("Startpunkt: " + startKoord + " Endpunkt: "
				+ endKoord);
		Thread.sleep(100);
		System.out.println("Schiff wird gesetzt \n");

		ShipTwo banane3 = new ShipTwo(startKoord, endKoord);

		spieler1.setShip(startKoord, endKoord, SP1Feld, banane3);
		// SP1Feld.setShip(startKoord, endKoord, banane3);

		feldAnzeigen(SP1Feld);

		// Schiff 1
		while (!stop) {
			System.out.println("\n                    Start Koordinate des\n"
					+ "                    Schiff der laenge 1 [1]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: Y-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			yA = coordScanner();
			// ABFANGEN!!!!!!!!!!!!!!!!!!!!!
			System.out
					.println("                    Schiff der laenge 1 [1]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: X-Achse:");

			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");

			xA = coordScanner();

			startKoord = "E1" + yA + xA;

			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
					SP1Feld)) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");

			} else {
				stop = true;
			}
		}

		stop = false;
		endKoord = startKoord;
		System.out.println("Schiff 1 Koord : " + startKoord);
		Thread.sleep(100);
		System.out.println("Schiff wird gesetzt \n");
		ShipOne banane4 = new ShipOne(startKoord, endKoord);

		spieler1.setShip(startKoord, endKoord, SP1Feld, banane4);
		// SP1Feld.setShip(startKoord, endKoord, banane4);

		feldAnzeigen(SP1Feld);

		// EBENE 2

		System.out.println("                            _________");
		System.out.println("                         0 | Ebene 2 |");
		System.out.println("                         1 |_________|");
		System.out.println("                        ... 0 1 2 3 ...\n\n");
		Thread.sleep(500);

		for (int i = 1; i <= 4; i++) {
			while (!stop) {
				System.out
						.println("                    Start Koordinate des "
								+ i
								+ ". \n"
								+ "                    Schiff der laenge 3 [3][3][3]\n\n");
				Thread.sleep(100);
				System.out.println("                    Eingabe: Y-Achse:");

				System.out.print("\n    ");
				for (int zeichen = 0; zeichen <= 65; zeichen++) {
					System.out.print("|");
					Thread.sleep(2);

				}
				System.out.println("\n\n");
				Thread.sleep(300);

				yA = coordScanner();

				System.out
						.println("                    Schiff der laenge 3 [3][3][3]\n\n");
				Thread.sleep(100);
				System.out.println("                    Eingabe: X-Achse:");

				System.out.print("\n    ");
				for (int zeichen = 0; zeichen <= 65; zeichen++) {
					System.out.print("|");
					Thread.sleep(2);

				}
				System.out.println("\n\n");
				Thread.sleep(300);

				xA = coordScanner();

				// Koord wird erstellt

				startKoord = "E2" + yA + xA;

				// berechnung der endCoord

				// HHHHHHIIIIIEEEERRRRR
				endKoord = HumanShipCalculation.calculateEndCoordinates(
						startKoord, 3, SP1Feld);
				if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
						SP1Feld)) {
					System.out
							.println("                    Setzen hier nicht moeglich neu eingeben");

				} else if (endKoord.equals("banane")) {
					System.out
							.println("                    Setzen hier nicht moeglich neu eingeben");
				} else {
					stop = true;
				}
			}
			stop = false;

			System.out.println("Startpunkt: " + startKoord + " Endpunkt: "
					+ endKoord);

			Thread.sleep(100);

			System.out.println("Schiff wird gesetzt \n");

			ShipThree banane6 = new ShipThree(startKoord, endKoord);

			spieler1.setShip(startKoord, endKoord, SP1Feld, banane6);
			// SP1Feld.setShip(startKoord, endKoord, banane1);

			feldAnzeigen(SP1Feld);
		}

		// EBENE 3
		System.out.println("                            _________");
		System.out.println("                         0 | Ebene 3 |");
		System.out.println("                         1 |_________|");
		System.out.println("                        ... 0 1 2 3 ...\n\n");
		Thread.sleep(500);

		for (int z = 1; z <= 4; z++) {
			while (!stop) {
				System.out
						.println("                    Start Koordinate des "
								+ z
								+ ". \n"
								+ "                    Schiff der laenge 3 [3][3][3]\n\n");
				Thread.sleep(100);
				System.out.println("                    Eingabe: Y-Achse:");

				System.out.print("\n    ");
				for (int zeichen = 0; zeichen <= 65; zeichen++) {
					System.out.print("|");
					Thread.sleep(2);

				}
				System.out.println("\n\n");
				Thread.sleep(300);

				yA = coordScanner();

				System.out
						.println("                    Schiff der laenge 3 [3][3][3]\n\n");
				Thread.sleep(100);
				System.out.println("                    Eingabe: X-Achse:");

				System.out.print("\n    ");

				for (int zeichen = 0; zeichen <= 65; zeichen++) {
					System.out.print("|");
					Thread.sleep(2);

				}
				System.out.println("\n\n");
				Thread.sleep(300);

				xA = coordScanner();

				// Koord wird erstellt

				startKoord = "E3" + yA + xA;

				// berechnung der endCoord
				// HIIIIEEEEIERRRRR
				endKoord = HumanShipCalculation.calculateEndCoordinates(
						startKoord, 3, SP1Feld);
				if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
						SP1Feld)) {
					System.out
							.println("                    Setzen hier nicht moeglich neu eingeben");

				} else if (endKoord.equals("banane")) {
					System.out
							.println("                    Setzen hier nicht moeglich neu eingeben");
				} else {
					stop = true;
				}
			}

			stop = false;

			System.out.println("Startpunkt: " + startKoord + " Endpunkt: "
					+ endKoord);

			Thread.sleep(100);

			System.out.println("Schiff wird gesetzt \n");

			ShipThree banane7 = new ShipThree(startKoord, endKoord);

			spieler1.setShip(startKoord, endKoord, SP1Feld, banane7);
			// SP1Feld.setShip(startKoord, endKoord, banane1);

			feldAnzeigen(SP1Feld);
		}

	}

	private static void sp2Setzen() throws InterruptedException {

		boolean stop = false;

		System.out.print("\n    ");
		for (int zeichen = 0; zeichen <= 65; zeichen++) {
			System.out.print("|");
			Thread.sleep(10);

		}
		System.out.println("\n\n");
		Thread.sleep(300);

		System.out.println("                           ________________");
		System.out.println("                          |    Spieler 2   |");
		System.out.println("                          | Schiffe setzen |");
		System.out.println("                          |________________|\n\n");
		Thread.sleep(800);
		System.out.println("                            _________");
		System.out.println("                         0 | Ebene 1 |");
		System.out.println("                         1 |_________|");
		System.out.println("                        ... 0 1 2 3 ...\n\n");
		Thread.sleep(500);

		int xA;
		int yA;
		String startKoord = "";
		String endKoord = "";
		while (!stop) {
			System.out
					.println("                    Start Koordinate des\n"
							+ "                    Schiff der laenge 5 [5][5][5][5][5]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: Y-Achse:");

			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			yA = coordScanner();

			System.out
					.println("                    Schiff der laenge 5 [5][5][5][5][5]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: X-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			xA = coordScanner();

			// Koord wird erstellt

			startKoord = "E1" + yA + xA;

			// berechnung der endCoord

			// HIIIIIEEEEERRRRRR
			endKoord = HumanShipCalculation.calculateEndCoordinates(startKoord,
					5, SP2Feld);

			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
					SP2Feld)) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");

			} else if (endKoord.equals("banane")) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");
			} else {
				stop = true;
			}
		}
		stop = false;

		System.out.println("Startpunkt: " + startKoord + " Endpunkt: "
				+ endKoord);

		Thread.sleep(100);

		System.out.println("Schiff wird gesetzt \n");

		ShipFive banane1 = new ShipFive(startKoord, endKoord);

		spieler2.setShip(startKoord, endKoord, SP2Feld, banane1);
		// SP1Feld.setShip(startKoord, endKoord, banane1);

		feldAnzeigen(SP2Feld);

		while (!stop) {

			System.out
					.println("                    Start Koordinate des\n"
							+ "                    Schiff der laenge 4 [4][4][4][4]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: Y-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			yA = coordScanner();

			System.out
					.println("                    Schiff der laenge 4 [4][4][4][4]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: X-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			xA = coordScanner();

			startKoord = "E1" + yA + xA;
			// HHHHHHIIIIIIIEEEEEERRRRRRR
			endKoord = HumanShipCalculation.calculateEndCoordinates(startKoord,
					4, SP2Feld);
			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
					SP2Feld)) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");

			} else if (endKoord.equals("banane")) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");
			} else {
				stop = true;
			}
		}
		stop = false;

		// Bis hier ge while

		System.out.println("Startpunkt: " + startKoord + " Endpunkt: "
				+ endKoord);
		Thread.sleep(100);
		System.out.println("Schiff wird gesetzt \n");

		ShipFour banane5 = new ShipFour(startKoord, endKoord);

		spieler2.setShip(startKoord, endKoord, SP2Feld, banane5);
		// SP1Feld.setShip(startKoord, endKoord, banane5);

		feldAnzeigen(SP2Feld);

		// Schiff 2
		while (!stop) {
			System.out.println("                    Start Koordinate des\n"
					+ "                    Schiff der laenge 2 [2][2]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: Y-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			yA = coordScanner();

			System.out
					.println("                    Schiff der laenge 4 [2][2]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: X-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			xA = coordScanner();

			startKoord = "E1" + yA + xA;

			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
					SP2Feld)) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");

			} else if (endKoord.equals("banane")) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");
			} else {
				stop = true;
			}
		}

		stop = false;

		// HHHIIIIEEERRRRR
		endKoord = HumanShipCalculation.calculateEndCoordinates(startKoord, 2,
				SP2Feld);

		// hier
		System.out.println("Startpunkt: " + startKoord + " Endpunkt: "
				+ endKoord);
		Thread.sleep(100);
		System.out.println("Schiff wird gesetzt \n");

		ShipTwo banane3 = new ShipTwo(startKoord, endKoord);

		spieler2.setShip(startKoord, endKoord, SP2Feld, banane3);
		// SP1Feld.setShip(startKoord, endKoord, banane3);

		feldAnzeigen(SP2Feld);

		// Schiff 1
		while (!stop) {
			System.out.println("                    Start Koordinate des\n"
					+ "                    Schiff der laenge 1 [1]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: Y-Achse:");
			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");
			Thread.sleep(300);

			yA = coordScanner();
			// ABFANGEN!!!!!!!!!!!!!!!!!!!!!
			System.out
					.println("                    Schiff der laenge 1 [1]\n\n");
			Thread.sleep(100);
			System.out.println("                    Eingabe: X-Achse:");

			System.out.print("\n    ");
			for (int zeichen = 0; zeichen <= 65; zeichen++) {
				System.out.print("|");
				Thread.sleep(2);

			}
			System.out.println("\n\n");

			xA = coordScanner();

			startKoord = "E1" + yA + xA;
			if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
					SP2Feld)) {
				System.out
						.println("                    Setzen hier nicht moeglich neu eingeben");

			} else {
				stop = true;
			}
		}

		stop = false;
		endKoord = startKoord;
		System.out.println("Schiff 1 Koord : " + startKoord);
		Thread.sleep(100);
		System.out.println("Schiff wird gesetzt \n");
		ShipOne banane4 = new ShipOne(startKoord, endKoord);

		spieler2.setShip(startKoord, endKoord, SP2Feld, banane4);
		// SP1Feld.setShip(startKoord, endKoord, banane4);

		feldAnzeigen(SP2Feld);

		// EBENE 2

		System.out.println("                            _________");
		System.out.println("                         0 | Ebene 2 |");
		System.out.println("                         1 |_________|");
		System.out.println("                        ... 0 1 2 3 ...\n\n");
		Thread.sleep(500);

		for (int i = 1; i <= 4; i++) {
			while (!stop) {
				System.out
						.println("                    Start Koordinate des "
								+ i
								+ ". \n"
								+ "                    Schiff der laenge 3 [3][3][3]\n\n");
				Thread.sleep(100);
				System.out.println("                    Eingabe: Y-Achse:");

				System.out.print("\n    ");
				for (int zeichen = 0; zeichen <= 65; zeichen++) {
					System.out.print("|");
					Thread.sleep(2);

				}
				System.out.println("\n\n");
				Thread.sleep(300);

				yA = coordScanner();

				System.out
						.println("                    Schiff der laenge 3 [3][3][3]\n\n");
				Thread.sleep(100);
				System.out.println("                    Eingabe: X-Achse:");

				System.out.print("\n    ");
				for (int zeichen = 0; zeichen <= 65; zeichen++) {
					System.out.print("|");
					Thread.sleep(2);

				}
				System.out.println("\n\n");
				Thread.sleep(300);

				xA = coordScanner();

				// Koord wird erstellt

				startKoord = "E2" + yA + xA;

				// berechnung der endCoord

				// HHHHHHIIIIIEEEERRRRR
				endKoord = HumanShipCalculation.calculateEndCoordinates(
						startKoord, 3, SP2Feld);
				if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
						SP2Feld)) {
					System.out
							.println("                    Setzen hier nicht moeglich neu eingeben");

				} else if (endKoord.equals("banane")) {
					System.out
							.println("                    Setzen hier nicht moeglich neu eingeben");
				} else {
					stop = true;
				}
			}

			stop = false;

			System.out.println("Startpunkt: " + startKoord + " Endpunkt: "
					+ endKoord);

			Thread.sleep(100);

			System.out.println("Schiff wird gesetzt \n");

			ShipThree banane6 = new ShipThree(startKoord, endKoord);

			spieler2.setShip(startKoord, endKoord, SP2Feld, banane6);
			// SP1Feld.setShip(startKoord, endKoord, banane1);

			feldAnzeigen(SP2Feld);
		}

		// EBENE 3
		System.out.println("                            _________");
		System.out.println("                         0 | Ebene 3 |");
		System.out.println("                         1 |_________|");
		System.out.println("                        ... 0 1 2 3 ...\n\n");
		Thread.sleep(500);

		for (int z = 1; z <= 4; z++) {
			while (!stop) {
				System.out
						.println("                    Start Koordinate des "
								+ z
								+ ". \n"
								+ "                    Schiff der laenge 3 [3][3][3]\n\n");
				Thread.sleep(100);
				System.out.println("                    Eingabe: Y-Achse:");

				System.out.print("\n    ");
				for (int zeichen = 0; zeichen <= 65; zeichen++) {
					System.out.print("|");
					Thread.sleep(2);

				}
				System.out.println("\n\n");
				Thread.sleep(300);

				yA = coordScanner();

				System.out
						.println("                    Schiff der laenge 3 [3][3][3]\n\n");
				Thread.sleep(100);
				System.out.println("                    Eingabe: X-Achse:");

				System.out.print("\n    ");

				for (int zeichen = 0; zeichen <= 65; zeichen++) {
					System.out.print("|");
					Thread.sleep(2);

				}
				System.out.println("\n\n");
				Thread.sleep(300);

				xA = coordScanner();

				// Koord wird erstellt

				startKoord = "E3" + yA + xA;

				// berechnung der endCoord
				// HIIIIEEEEIERRRRR
				endKoord = HumanShipCalculation.calculateEndCoordinates(
						startKoord, 3, SP2Feld);
				if (!PositionsAbfrage.isCoordinateValidAndNotSet(startKoord,
						SP2Feld)) {
					System.out
							.println("                    Setzen hier nicht moeglich neu eingeben");

				} else if (endKoord.equals("banane")) {
					System.out
							.println("                    Setzen hier nicht moeglich neu eingeben");
				} else {
					stop = true;
				}
			}

			stop = false;

			System.out.println("Startpunkt: " + startKoord + " Endpunkt: "
					+ endKoord);

			Thread.sleep(100);

			System.out.println("Schiff wird gesetzt \n");

			ShipThree banane7 = new ShipThree(startKoord, endKoord);

			spieler2.setShip(startKoord, endKoord, SP2Feld, banane7);
			// SP1Feld.setShip(startKoord, endKoord, banane1);

			feldAnzeigen(SP2Feld);
		}

	}

	private static void sp1Schiessen() throws InterruptedException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {

		System.out.println("\n                           ________________");
		System.out.println("                          |    Spieler 1   |");
		System.out.println("                          |    schiessen   |");
		System.out.println("                          |________________|\n\n");
		System.out.println("\n                                bereit?     ");
		Scanner in = new Scanner(System.in);
		String zahl = in.nextLine();
		System.out.println("\n");
		feldAnzeigen(SP1Feld);
		Thread.sleep(300);
		System.out.println("\n\n");

		spieler1.shot(SP2Feld);
	}

	private static void sp2Schiessen() throws InterruptedException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {

		System.out.println("\n                           ________________");
		System.out.println("                          |    Spieler 2   |");
		System.out.println("                          |    schiessen   |");
		System.out.println("                          |________________|\n\n");
		System.out.println("\n                                bereit?     ");
		Scanner in = new Scanner(System.in);
		String zahl = in.nextLine();
		System.out.println("\n");
		feldAnzeigen(SP2Feld);
		Thread.sleep(300);
		System.out.println("\n\n");

		spieler2.shot(SP1Feld);

	}

	private static void logo() throws InterruptedException {
		System.out.println("");
		System.out
				.println("   _____________________________________________________________________");
		Thread.sleep(20);
		System.out
				.println("  /___________________________________________________________________/ |");
		Thread.sleep(20);
		System.out
				.println("  | _________________________________________________________________ | |");
		Thread.sleep(20);
		System.out
				.println("  || ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~?? ??~~~ || |");
		Thread.sleep(20);
		System.out
				.println("  || ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~[3][x][x]~~~ ||A|");
		Thread.sleep(20);
		System.out
				.println("  || ~~[1]~~~~[4][4][4][4]~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ||W|");
		Thread.sleep(20);
		System.out
				.println("  || ~~~~~  __   __  ___  ___   __  ___ ___      __  ~~~~~~~~~~~~~~~ ||E|");
		Thread.sleep(20);
		System.out
				.println("  || ~~~~  |  | |  |  |   |  | |  |  |   |  |   |     ~~~~~[3][3][3]~||S|");
		Thread.sleep(20);
		System.out
				.println("  || ~~~   |  | |  |  |   |--| |--|  |   |  |   |-   ~~~~~~~~~~~~~~~ ||O|");
		Thread.sleep(20);
		System.out
				.println("  || ~~~~~ |__| |__|  |   |__| |  |  |   |  |__ |__   ~~[2][2]~~~~~~ ||M|");
		Thread.sleep(20);
		System.out
				.println("  || ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ||E|");
		Thread.sleep(20);
		System.out
				.println("  || ~~~~~~~~~~~~~~~~~~~~~~~~[5][5][5][5][5]~~~~~~~~~~~~~~~~~~??~~~~ ||!|");
		Thread.sleep(20);
		System.out
				.println("  || ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~[x]~~~~ || |");
		Thread.sleep(20);
		System.out
				.println("  ||________[3][3][3]________________________________________________|| |");
		Thread.sleep(20);
		System.out
				.println("  |___________________________________________________________________|/");
		Thread.sleep(800);
		System.out
				.println("                                                       __________________");
		Thread.sleep(30);
		System.out
				.println("                                                      |Version 1.0       |");
		Thread.sleep(30);
		System.out
				.println("                                                      |   CODE EVOLUTION |");
		Thread.sleep(30);
		System.out
				.println("                                                      |__________________|\n");
		Thread.sleep(30);

	}

	private static void verhandlungen() throws InterruptedException {

		System.out.println("Spieler  vs  Spieler wird gestartet\n\n");

		System.out.println("                           ________________");
		Thread.sleep(50);
		System.out.println("                          |   Verhandlung  |");
		Thread.sleep(50);
		System.out.println("                          |  wer faengt an |");
		Thread.sleep(50);
		System.out.println("                          |________________|\n\n");
		Thread.sleep(500);

		System.out.println("                         1) Spieler1\n"
				+ "                         2) Spieler2\n"
				+ "                         3) Muenze werfen\n\n");
		Thread.sleep(50);

	}

	private static void kiAuswahl() throws InterruptedException {

		System.out.println("Spieler  vs  Computer wird gestartet\n\n");

		System.out.println("                           ________________");
		Thread.sleep(50);
		System.out.println("                          |   Verhandlung  |");
		Thread.sleep(50);
		System.out.println("                          |   KI waehlen   |");
		Thread.sleep(50);
		System.out.println("                          |________________|\n\n");
		Thread.sleep(500);

		System.out.println("                         1) Easy\n"
				+ "                         2) Middle\n"
				+ "                         3) Hard\n\n");
		Thread.sleep(50);

	}

	private static void kiVkiAuswahl() throws InterruptedException {

		System.out.println("Computer  vs  Computer wird gestartet\n\n");

		System.out.println("                           ________________");
		Thread.sleep(50);
		System.out.println("                          |   Verhandlung  |");
		Thread.sleep(50);
		System.out.println("                          |   KI waehlen   |");
		Thread.sleep(50);
		System.out.println("                          |________________|\n\n");
		Thread.sleep(500);

		System.out.println("                         1) Easy\n"
				+ "                         2) Middle\n"
				+ "                         3) Hard\n"
				+ "                         4) Extern KI\n"
				+ "	\n");
		Thread.sleep(50);

	}

	private static void hauptMenue() throws InterruptedException {

		System.out
				.println("                []________________________________________[]    ");
		Thread.sleep(30);
		System.out
				.println("                 || Hauptmenue:                          ||");
		Thread.sleep(30);
		System.out
				.println("                 ||   Modus :                            ||");
		Thread.sleep(30);
		System.out
				.println("                 ||                                      ||");
		Thread.sleep(30);
		System.out
				.println("                 ||   1)  Spieler  vs  Spieler           ||");
		Thread.sleep(30);
		System.out
				.println("                 ||   2)  Spieler  vs  Computer          ||");
		Thread.sleep(30);
		System.out
				.println("                 ||   3)  Computer vs  Computer          ||");
		Thread.sleep(30);
		System.out
				.println("                 ||   4)         Credits                 ||");
		Thread.sleep(30);
		System.out
				.println("                 ||   5)         Beenden                 ||");
		Thread.sleep(30);
		System.out
				.println("                 ||                                      ||");
		Thread.sleep(30);
		System.out
				.println("                 ||   6)      Dein erstes mal?           ||");
		Thread.sleep(30);
		System.out
				.println("                 ||______________________________________|| ");
		Thread.sleep(30);
		System.out
				.println("                []                                        []\n");
		Thread.sleep(100);
		System.out.println("                      Bitte waehlen: ");
		System.out.print("    ");
		for (int zeichen = 0; zeichen <= 65; zeichen++) {
			System.out.print("|");
			Thread.sleep(10);

		}
		System.out.println("\n");
		Thread.sleep(300);

	}

	private static void zugBeendet() throws InterruptedException {
		for (int weiter = 0; weiter <= 50000; weiter++) {
			System.out.println("\n");
		}
		System.out.print("\n    ");
		for (int zeichen = 0; zeichen <= 65; zeichen++) {
			System.out.print("|");
			Thread.sleep(15);

		}

		System.out
				.println("\n\n            ____________________________________________________");
		System.out
				.println("           |     Zug beendet, naechster Spieler Bereit?         |");
		System.out
				.println("           |          vorheriger Spieler vertrieben?            |");
		System.out
				.println("           |Druecken sie die Beliebige Taste, aber keine andere |");
		System.out
				.println("           |____________________________________________________|\n");

		Scanner enter = new Scanner(System.in);
		String zahl = enter.nextLine();
	}

	private static void zugBeendetkI(int n) throws InterruptedException {
	
		System.out.print("\n\n    ");
		for (int zeichen = 0; zeichen <= 65; zeichen++) {
			System.out.print("|");
			Thread.sleep(3);

		}
		

		System.out
				.println("\n\n            ____________________________________________________");
		System.out
				.println("           |                   Zug Beendet                      |");
		System.out.println("           |                 KI " + n
				+ " an der Reihe                  |");

		System.out
				.println("           |____________________________________________________|\n");

		Thread.sleep(200);
	}

	public static Battlefield getFeld2(){
		return SP2Feld;
	}
	
	public static Battlefield getFeld1(){
		return SP1Feld;
	}
	
	private static void musikStartenloop() throws InterruptedException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		File audioFile = new File("Pirates of the caribbean 8-bitloop.wav");

		AudioInputStream audioInputStream = getAudioInputStream(audioFile);
		Clip clip = getClip();
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
		Thread.sleep(1700);

	}

	static void musikTreffer() throws InterruptedException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		File audioFile = new File("Explosion sound effect.wav");

		AudioInputStream audioInputStream = getAudioInputStream(audioFile);
		Clip clip = getClip();
		clip.open(audioInputStream);
		clip.start();
		Thread.sleep(300);

	}

	static void musikSieg() throws InterruptedException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		File audioFile = new File("Victory Fanfare 8 Bit.wav");

		AudioInputStream audioInputStream = getAudioInputStream(audioFile);
		Clip clip = getClip();
		clip.open(audioInputStream);
		clip.start();
		Thread.sleep(1700);

	}

	static void musikDaneben() throws InterruptedException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		File audioFile = new File("Splash Hard 02.wav");

		AudioInputStream audioInputStream = getAudioInputStream(audioFile);
		Clip clip = getClip();
		clip.open(audioInputStream);
		clip.start();
		Thread.sleep(300);

	}

	static void musikVersenkt() throws InterruptedException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		File audioFile = new File("ship-sinking.wav");

		AudioInputStream audioInputStream = getAudioInputStream(audioFile);
		Clip clip = getClip();
		clip.open(audioInputStream);
		clip.start();
		Thread.sleep(500);

	}

	//
	// String fileName = "muss you.wav";
	// InputStream in = null;
	//
	// try {
	// in = new FileInputStream(fileName);
	//
	// } catch (FileNotFoundException e) {
	//
	// System.out.println("nicht gefunden");
	//
	// e.printStackTrace();
	// }
	//
	// AudioStream as = null;
	// try {
	//
	// as = new AudioStream(in);
	//
	//
	// } catch (IOException e) {
	//
	// e.printStackTrace();
	// }
	// AudioPlayer.player.start(as);
	//
	// Thread.sleep(1000);

	private static void anleitung() throws InterruptedException {

		System.out
				.println("\n\n            ____________________________________________________");
		System.out
				.println("           |     Echt noch nie Schife versenken gespielt        |");
		System.out
				.println("           |  oder wolltest du nur mal die Taste 6 druecken     |");
		System.out
				.println("           |               also gut die Anleitung               |");
		System.out
				.println("           |____________________________________________________|\n\n");
		Thread.sleep(800);
		System.out
				.println("\n         Zunaechst wir entschieden welcher Spieler anfangen soll. \n"
						+ "         Kommt es zur keiner Einigung, aus welchen Freundschaftlichen \n"
						+ "         Gruenden auch immer, kann die Muenze Ÿbernehmen. Nach der schweren \n"
						+ "         bedeutungsvollen Entscheidung, darf der gewaehlte Spieler, \n"
						+ "         anfangen seine Schiffe zu setzen. \n"
						+ "         WŠhrend der andere Spielermoeglich aus dem Fenster schauen sollte. \n"
						+ "         Falls kein Fenster vorhanden bleiben noch die Moeglichkeiten, \n"
						+ "         den Raum zu verlassen, sich um zu drehen, sich Bier zu holen oder \n"
						+ "         mit einem imaginaeren Hund spazieren zu gehen. Das setzten sollte \n"
						+ "         selbst erklaerend sein, wie auch im Menue kšnnen sie nichts falsches \n"
						+ "         eingeben (easter Egg im Menue finden :D). Wenn der setzende Spieler, \n"
						+ "         seine noch nicht, in sitzen, gesetzten Schiffe, die er bereits gesetzt\n"
						+ "         haben sollte, gesetzt hat bzw. sich setzend, alle ungesetzten Schiffe \n"
						+ "         gesetzt hat, hat er somit seinen Zug beendet. Dies ist der Moment, \n"
						+ "         an dem sie den anderen Spieler suchen / rufen / aufwecken / beschwoeren \n"
						+ "         sollte, da er an der reihe sein. Darauf wird deutlich hingewiesen,\n "
						+ "         zeigen sie Ihn bei bedarf die wo die beliebige Taste zu finden ist. \n"
						+ "         Und erzaehlen sie ihn Ÿber den Ablauf den sie bisher ausgefŸhrt haben. \n"
						+ "         Wenn alle Spieler ihre Schiffe gesetzt haben beginnt der spa§ des Spieles, \n"
						+ "         sollte ... moeglicherweise, evtl. wahrscheinlich... \n"
						+ "         Das Ziel ist es alle gesetzten Schiffe des Gegners zu versenken. \n"
						+ "         Um ein Schiff zu versenken sollte man es beschie§en, \n"
						+ "         Ausnahme das Schiff liegt in der Wueste von Nevada ... \n"
						+ "         da kann es schlecht sinken.\n"
						+ "         Beide Spieler schie§en abwechselnd auf ihre jeweiligen gesetzten Schiffe. \n"
						+ "         Wird ein Treffer zurueck gegeben darf, der Glueckliche ein einmal schie§en. \n"
						+ "         Das Spiel endet wenn alle Schiffe eines Spieler versenkt wurde oder ein Spieler, \n"
						+ "         verzweifelt, ausrastet, einen Zusammenbruch auf Grund des Spieles erleidet, \n"
						+ "         keine Lust mehr hat, die Freundschaft beendet, \n"
						+ "         ausversehen ein Nuklearsprengkopf zuendet, \n"
						+ "         Katzen die Weltherrschaft an sich rei§en oder \n"
						+ "         einer nie wieder von der Toilette zurueckkehrt..... ");
		Thread.sleep(1000);
		System.out
				.println("\n          Scrollen koennen sie da ----------------------------------------------------------->\n\n\n");

		System.out
				.println("\n\n            _____________________________________________________");
		System.out
				.println("           | Druecken sie die Beliebige Taste, aber keine andere |");
		System.out
				.println("           |_____________________________________________________|\n");

		Scanner enter = new Scanner(System.in);
		String zahl = enter.nextLine();

		System.out.print("    ");
		for (int zeichen = 0; zeichen <= 65; zeichen++) {
			System.out.print("|");
			Thread.sleep(15);

		}
		System.out.println("\n\n\n");
	}

	private static boolean isRunning() throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (!SP1Feld.isGameRunning()) {
			spielBeenden(2);
			return false;
		} else if (!SP2Feld.isGameRunning()) {
			spielBeenden(1);

			return false;
		} else {
			return true;
		}
	}

}
