import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Projekt 1 - ruttsökning med A*
 *
 * Datastrukturer och algoritmer
 *
 * Programmeringsteam:
 * Rasmus Lagerqvist & Patrik Nordman
 */
public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("DDRC - Drone Delivery Route Calculator (Helsinki) v1.1");
		System.out.println("Copyright Oy Drone Delivery Ab, All rights reserved.\n");

		GraphData options = new GraphData();
		System.out.println(" key     Name                               Neighbours");
		for (String key: options.createGraph().keySet()) {
		            System.out.printf("%s - %s\n", ("[" + key + "]"), options.createGraph().get(key).getName() + "      -->");
		        }

		System.out.println("\nPlease enter your start and destination!");
		System.out.print("Start: ");
		String start = scan.nextLine();
		System.out.print("Destination: ");
		String destination = scan.nextLine();

		System.out.println("\nShortest routes: ");
		/** Formatting **/
		/*
		System.out.println(" key   Name                                 Neighbours\n" +
				"[gumt] Gumtäkts uni.bibliotek           -> [bole] [mejl]");  */

	}

}

