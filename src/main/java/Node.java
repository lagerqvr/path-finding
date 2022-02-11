import java.util.ArrayList;

public class Node {

    public String name;
    public String key;
    public double latitude;
    public double longitude;
    public ArrayList<Node> neighbours= new ArrayList<>();

    public Node(String name, double latitude, double longitude) {
        this.key = key;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        
    }

    // Getters
    public String getName() {
        return name;
    }

    // Setters
    public String setKey(String key) {
        return this.key;
    }

    public void addNeighbor(Node node) {
    }
}
