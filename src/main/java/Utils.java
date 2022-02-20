import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Utils {

    /**
     * Metod för att beräkna distansen mellan två geografiska koordinater
     */
    public static double getDistance(double lat1, double lon1, double lat2, double lon2) {

        // Konvertera grader till radians
        lat1 = lat1 * Math.PI / 180.0;
        lon1 = lon1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        lon2 = lon2 * Math.PI / 180.0;

        // Räkna ut distansen med haversinformeln
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1)
                * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));

        // Jordens radie i km
        double r = 6371;
        // returnera resultatet i km
        return (c * r);

    }

    public static void listNodesAndLinks(LinkedHashMap<String, Node> nodes) {
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
    }

    public static void outputLogic(LinkedHashMap<String, Node> nodes) {

        Scanner scan = new Scanner(System.in);
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        boolean correctValues = false;

        while (!correctValues) {

            System.out.println("\nPlease enter your start and destination!");
            System.out.print("Start: ");
            try {
                String start = scan.nextLine();
                System.out.print("Destination: ");
                String destination = scan.nextLine();

                if (nodes.containsKey(start) && nodes.containsKey(destination)) {
                    System.out.println("");

                    Utils.getRoute(nodes.get(start), nodes.get(destination));

                    correctValues = true;
                } else {
                    System.out.println(ANSI_RED + "\nPlease enter a valid starting point and destination!" + ANSI_RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println("");
                scan.next();
            } catch (Exception e) {
                scan.next();
            }
        }
    }

    public static ArrayList<Node> getRoute(Node startNode, Node endNode) {
        ArrayList<Node> candidates = new ArrayList<>();
        ArrayList<Node> visited = new ArrayList<>();
        Node current = startNode;
        boolean done = false;

        while (!done) {
            double minF = 0;
            Node next = null;

            for (int i = 0; i < current.getNeighbours().size(); i++) {
                Node neighbour = current.getNeighbours().get(i);
                if (!candidates.contains(neighbour) && !visited.contains(neighbour)) {
                    candidates.add(current.getNeighbours().get(i));
                    neighbour.setPrevious(current);
                }
            }

            for (int i = 0; i < candidates.size(); i++) {
                if (candidates.get(i) != endNode) {
                    done = true;
                    break;
                } else {
                    double G = candidates.get(i).calculateG(startNode); // current?
                    double H = candidates.get(i).calculateH(endNode);
                    double F = candidates.get(i).getF(H, G);
                    if (minF == 0 || minF > F) {
                        minF = F;
                        next = candidates.get(i);
                        if (candidates.get(i) == current.getNeighbours().get(i)) {
                            candidates.get(i).setPrevious(current);
                        }
                    }
                }
            }
            if (!done) {
                current = next;
                visited.add(current);
                candidates.remove(current);
            }
        }

        ArrayList<Node> route = new ArrayList<>();
        current = endNode;

        while (!(current == startNode)) {
            route.add(current); // 0, current?
            current = current.previous;
        }

        // Formatting

        int order = 1;
        System.out.println("\nShortest route: \n" +
                order + ". " + current.getName());
        for (int i = route.size() - 1; i >= 0; i--) {
            order++;
            System.out.print(order + ". " + route.get(i).getName());

        }
        System.out.println("\n");
        return route;
    }

}
