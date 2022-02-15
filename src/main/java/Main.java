import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Projekt 1 - ruttsökning med A*
 * <p>
 * Datastrukturer och algoritmer
 * <p>
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
        LinkedHashMap<String, Node> nodes = options.createGraph();
        System.out.println(" key     Name                               Neighbours");
        for (String key : nodes.keySet()) {
            String neighbours = "";
            for (Node neighbour : nodes.get(key).getNeighbours()) {
                neighbours += "[" + neighbour.getKey() + "] ";
            }
            System.out.printf("[%s] - %s     -->  %s \n",
                    key,
                    nodes.get(key).getName(),
                    neighbours);
        }

        System.out.println("\nPlease enter your start and destination!");
        System.out.print("Start: ");
        String start = scan.nextLine();
        System.out.print("Destination: ");
        String destination = scan.nextLine();
        double distance = 0;

        if (nodes.containsKey(start) && nodes.containsKey(destination)) {
            Node val1 = nodes.get(start);
            Node val2 = nodes.get(destination);
            distance = val1.calculateH(val2);
            System.out.println("\nDistance between nodes: " + distance);
        } else {
            System.out.println("Please input something else!");
        }

        /** Yet to be implemented **/

        /* System.out.println("Shortest routes: ");*/

        /** Formatting **/
		/*
		System.out.println(" key   Name                                 Neighbours\n" +
				"[gumt] Gumtäkts uni.bibliotek           -> [bole] [mejl]");  */
    }

}

