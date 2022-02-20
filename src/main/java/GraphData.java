import java.util.HashMap;
import java.util.LinkedHashMap;

public class GraphData {

    public static LinkedHashMap<String,Node> createGraph() {

        /**
         * Noderna instansieras med namn och koordinater i en
         * HashMap med en kortare sträng som nyckel (ID)
         *
         * LinkedHashMap används på samma sätt som HashMap, men dess element
         * lagras i en länkad lista och behåller därför sin ursprungliga ordning
         * (inte nödvändigt för funktionaliteten, men mer användarvänligt)
         */
        LinkedHashMap<String,Node> nodes = new LinkedHashMap<>();

        /** Temporär lista för nodernas grannar */
        HashMap<String, String[]> neighbours = new HashMap<>();

        //         key              name                        lat      lon
        nodes.put("gumt", new Node("Gumtäkts uni.bibliotek   ", 60.2039, 24.9638));
        nodes.put("lill", new Node("Lillhoplax bibliotek     ", 60.2008, 24.8954));
        nodes.put("bole", new Node("Böle bibliotek           ", 60.2008, 24.9355));
        nodes.put("arca", new Node("Arcadas bibliotek        ", 60.2007, 24.9662));
        nodes.put("diak", new Node("Diaks bibliotek          ", 60.1983, 24.9707));
        nodes.put("vall", new Node("Vallgårds bibliotek      ", 60.1923, 24.9626));
        nodes.put("mejl", new Node("Mejlans uni.bibliotek    ", 60.1901, 24.9072));
        nodes.put("berg", new Node("Berghälls bibliotek      ", 60.1837, 24.9536));
        nodes.put("tolo", new Node("Tölö bibliotek           ", 60.1833, 24.9175));
        nodes.put("sorn", new Node("Sörnäs uni.bibliotek     ", 60.1802, 24.9592));
        nodes.put("oodi", new Node("Centrumbiblioteket Ode   ", 60.1741, 24.9382));
        nodes.put("hels", new Node("Helsingfors uni.bibliotek", 60.1709, 24.9493));
        nodes.put("hank", new Node("Hankens bibliotek        ", 60.1707, 24.9241));
        nodes.put("rich", new Node("Richardsgatans bibliotek ", 60.1663, 24.9468));
        nodes.put("bush", new Node("Busholmens bibliotek     ", 60.1593, 24.9207));

        /**
         * Data för nodernas grannar enligt linjerna på kartan. HashMap med ID
         * och en enkel String[]-array för grannarnas ID.
         */
        neighbours.put("gumt", new String[]{"bole", "arca"});
        neighbours.put("lill", new String[]{"bole", "mejl"});
        neighbours.put("bole", new String[]{"lill", "tolo", "gumt"});
        neighbours.put("arca", new String[]{"gumt", "diak"});
        neighbours.put("diak", new String[]{"arca", "vall"});
        neighbours.put("vall", new String[]{"diak", "berg"});
        neighbours.put("mejl", new String[]{"lill", "tolo"});
        neighbours.put("berg", new String[]{"vall", "tolo", "sorn"});
        neighbours.put("tolo", new String[]{"bole", "mejl", "berg", "oodi", "hank"});
        neighbours.put("sorn", new String[]{"berg"});
        neighbours.put("oodi", new String[]{"tolo", "berg", "hank", "hels"});
        neighbours.put("hels", new String[]{"oodi", "rich"});
        neighbours.put("hank", new String[]{"tolo", "oodi", "bush"});
        neighbours.put("rich", new String[]{"hels", "bush"});
        neighbours.put("bush", new String[]{"hank", "rich"});


        /**
         * Iterera noderna enligt ID och lägg till grannarna
         */
        for (String key : nodes.keySet()) {

            /* Ange nyckeln (t.ex. "bole") som ID åt noden, kan vara bra att ha för UI  */
            nodes.get(key).setKey(key);

            /* Iterera nodens grannar och lägg till dem till noden */
            for (String neighbour : neighbours.get(key)) {
                nodes.get(key).addNeighbour(nodes.get(neighbour));
            }

        }

        return nodes;
    }

}
