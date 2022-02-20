import java.util.InputMismatchException;
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

        UI.outPrint();

        GraphData options = new GraphData();
        LinkedHashMap<String, Node> nodes = options.createGraph();

        Utils.listNodesAndLinks(nodes);
        Utils.outputLogic(nodes);
    }
}

