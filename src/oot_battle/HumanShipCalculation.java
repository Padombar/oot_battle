package oot_battle;

// rueckschritte !! bei fehler!!! 
// wenn keine endkoordinate moeglich!!!

import java.util.LinkedList;
import java.util.Scanner;

// klasse umbenennen !!!!!  humanShipCalculation
public class HumanShipCalculation {
	
	// Battlefeild zugriff !!
//	public static LinkedList<String> filledSpots = new LinkedList();
	/**
	 * 
	 * @param startCoord
	 * @param shiplength
	 */
	public static String calculateEndCoordinates(String startCoord, int shiplength, Battlefield feld) {
		LinkedList<String> possibleEndpoints = new LinkedList();
		int options = 0; 
		
		// berechnung der Möglichen Endpunkte, für jede richtung 
		if (shiplength>1){
		// endpunkt auf der X-Achse wird geprueft (Osten)
		if(PositionsAbfrage.getX(startCoord)+shiplength-1 <=9){
			int coord = PositionsAbfrage.getX(startCoord)+shiplength-1;
			String endpoint =""+ startCoord.charAt(0) + startCoord.charAt(1) + startCoord.charAt(2)+coord;
			int shipPlaces = 0;
			if (!feld.getSMap().containsKey(endpoint)){
				if(startCoord.charAt(3)!=endpoint.charAt(3)){
					if(startCoord.charAt(3)<endpoint.charAt(3)){
						int i=0;
						
						while (i<shiplength){
							String taken=""+startCoord.charAt(0)+startCoord.charAt(1)+startCoord.charAt(2);
							int xposition = PositionsAbfrage.getX(startCoord)+i;
							taken += xposition;
							i++;
							if(!feld.getSMap().containsKey(taken)){
								shipPlaces++;
							}
						}
					}
				}
			}
			if(shipPlaces==shiplength){
				options++;
				possibleEndpoints.add(endpoint);
				System.out.print(options+". "+endpoint+"\n[Start]"+"--"+"[Ende ]\n\n");
			}
		}
		
		//endpunkt aud der X-Achse wird geprueft (West)
		if (PositionsAbfrage.getX(startCoord)-shiplength+1 >= 0){
			int coord = PositionsAbfrage.getX(startCoord)-shiplength+1;
			String endpoint =""+ startCoord.charAt(0) + startCoord.charAt(1) + startCoord.charAt(2)+coord;
			int shipPlaces = 0;
			if(!feld.getSMap().containsKey(endpoint)){
				if(startCoord.charAt(3)!=endpoint.charAt(3)){
					if(startCoord.charAt(3)>endpoint.charAt(3)){
						int i = 0;
						
						while (i<shiplength){
							String taken=""+startCoord.charAt(0)+startCoord.charAt(1)+startCoord.charAt(2);
							int xposition = PositionsAbfrage.getX(startCoord)-i;
							taken += xposition;
							i++;
							if(!feld.getSMap().containsKey(taken)){
								shipPlaces++;
							}
						}
					}
				}
			
			}
			if(shipPlaces==shiplength){
				options++;
				possibleEndpoints.add(endpoint);
				System.out.print(options+". "+endpoint+"\n[Ende ]"+"--"+"[Start]\n\n");
			}
		}
		
		// endpunkt auf der Y-Achse wird geprueft (Sued)
		if (PositionsAbfrage.getY(startCoord)+shiplength-1<=9){
			int coord = PositionsAbfrage.getY(startCoord)+shiplength-1;
			String endpoint = ""+startCoord.charAt(0) + startCoord.charAt(1) + coord + startCoord.charAt(3);
			int shipPlaces = 0;
			if (!feld.getSMap().containsKey(endpoint)){
				if (startCoord.charAt(2)!=endpoint.charAt(2)){
					if (startCoord.charAt(2)<endpoint.charAt(2)){
						int i = 0;						
						while(i<shiplength){
							String taken =""+startCoord.charAt(0)+startCoord.charAt(1);
							int yposition= PositionsAbfrage.getY(endpoint)-i;
							taken += yposition;
							taken += startCoord.charAt(3);
							i++;
							if(!feld.getSMap().containsKey(taken)){
								shipPlaces++;
							}
						}
					}
				}
				
			}
			if(shipPlaces==shiplength){
				options++; 
				possibleEndpoints.add(endpoint);
				System.out.print(options+". "+endpoint+"\n[Start]\n"+"  I"+"\n"+"  I"+"\n[Ende ]\n\n");
			}
			

		}
		
		// endpunkt aud der Y-Achse wird geprueft (Nord)
		if (PositionsAbfrage.getY(startCoord)-shiplength+1>=0){
			int coord = PositionsAbfrage.getY(startCoord)-shiplength+1;
			String endpoint = ""+startCoord.charAt(0) + startCoord.charAt(1) + coord + startCoord.charAt(3); 
			int shipPlaces = 0;
			if(!feld.getSMap().containsKey(endpoint)){
				if (startCoord.charAt(2)!=endpoint.charAt(2)){
					if (startCoord.charAt(2)>endpoint.charAt(2)){
						int i = 0;
						while(i<shiplength){
							String taken =""+startCoord.charAt(0)+startCoord.charAt(1);
							int yposition= PositionsAbfrage.getY(endpoint)+i;
							taken += yposition;
							taken += startCoord.charAt(3);
							i++;
							if(!feld.getSMap().containsKey(taken)){
								shipPlaces++;
							}
						}
					}
				}

			}
			if(shipPlaces==shiplength){
				options++; 
				possibleEndpoints.add(endpoint);
				System.out.print(options+". "+endpoint+"\n[Ende ]\n"+"  I"+"\n"+"  I"+"\n[Start]\n\n");
			}
		  }
		}

		if(options>0){
			System.out.println("Bitte Waehlen sie eine der "+options+" moeglichgkeiten");
			int i= 1; 
			int j=0;
			while(i<=options){
				System.out.print(i+". "+possibleEndpoints.get(j)+"  ");
				i++;
				j++;
			}
			return chooseEndcoordinate(possibleEndpoints, startCoord, options, shiplength,feld);
		}else{
			System.out.println("Keine moeglichkeit das Schiff zu platzieren bitte neuen Startpunkt waehlen!");
			return "banane";
		}
	}

	private static String chooseEndcoordinate(LinkedList<String> endCoords, String startCoord, int options, int shipLength, Battlefield feld){
		
		String coord = "";
		int selection = 0; 
		boolean valid = false; 
		
		Scanner in = new Scanner(System.in);
		String number = in.nextLine();
		
	
		if (number.equals("1") || number.equals("2")|| number.equals("3")||number.equals("4")){	
			selection = Integer.parseInt(number);
		if(selection>options){
			System.out.println("Ungueltige Eingebe bitte erneut versuchen");
			System.out.println("Bitte geben sie waehlen sie eine Moeglichkeit");
			return chooseEndcoordinate(endCoords, startCoord, options, shipLength,feld);
		}
			if (selection<=options && selection >0){
				valid = true;
			}
			
		}else {
			System.err.println("Captain! Wo zum Henker soll das sein? Bleiben sie im Kriegsbebiet!");
			return chooseEndcoordinate(endCoords, startCoord, options, shipLength,feld);
		}
		if (options==4){
			
			switch(selection){
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
		} else if (options==3){
			
			switch(selection){
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
		} else if (options == 2){
			switch(selection){
			case 1:
				coord = endCoords.get(0);
				break;
			case 2: 
				coord = endCoords.get(1);
				break;
			}	
		} else if (options == 1){
			switch(selection){
			case 1:
				coord = endCoords.get(0);
				break;
			}
		} 
		System.out.println("Sie haben folgenden Endpunkt gewaehlt: "+ coord);
		if (!feld.getSMap().containsKey(coord)){
			System.out.println("Captain! Schiff wurde Platziert!");
			return coord;
		}else{
			System.err.println("Captain da ist schon ein Schiff!");
			System.out.println("Bitte wählen sie eine andere Koordinate");
			return chooseEndcoordinate(endCoords, startCoord, options, shipLength,feld);	
		}
	}
			
}

