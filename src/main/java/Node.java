import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Node {

    public String name;
    public String key;
    public double latitude;
    public double longitude;
    public ArrayList<Node> neighbours= new ArrayList<>();

    public Node(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getKey() { return key; }

    public ArrayList<Node> getNeighbours() { return neighbours;}

    // Setters
    public void setKey(String key) {
        this.key = key;
    }

    public void addNeighbor(Node node) {
        neighbours.add(node);
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
