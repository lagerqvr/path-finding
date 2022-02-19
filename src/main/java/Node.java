import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.graalvm.compiler.nodes.StartNode;

public class Node {

    public String name;
    public String key;
    public double latitude;
    public double longitude;
    public double F;
    
    public ArrayList<Node> neighbours = new ArrayList<>();

    public Node(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getLatitude(Node node) {
        return node.latitude;
    }

    public double getLongitude(Node node) {
        return node.latitude;
    }

    public String getKey() { 
        return key; 
    }

    public ArrayList<Node> getNeighbours() { 
        return neighbours;
    }

    public double getF() {
        return F;
    }

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

    public double calculateH (Node node) {
        double distance = Utils.getDistance(node.latitude, node.longitude, latitude, longitude);
        return distance;
    }

    public void previous (Node node) {

    }

    public double calculateG(String startNode) {
        double G = 0;
        Node current(this.node);

        while (current != startNode) {
            double dist = current + current.previous(node);
            G = G + dist;
            current = current.previous(node);
        }
        return G;
    }

    
    
}
