import java.util.ArrayList;

public class Node {

    public String name;
    public String key;
    Node previous;
    public double latitude;
    public double longitude;

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

    public String getKey() { 
        return key; 
    }

    public ArrayList<Node> getNeighbours() { 
        return neighbours;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // Setters
    public void setKey(String key) {
        this.key = key;
    }

    public void addNeighbour(Node node) {
        neighbours.add(node);
    }

    public double calculateH (Node node) {
        return Utils.getDistance(latitude, longitude, node.latitude, node.longitude);
    }

    public double calculateG(Node startNode) {
        double G = 0;
        Node current = this;

        while (!(current == startNode)) {
            G = G + Utils.getDistance(current.latitude, current.latitude, previous.getLongitude(), previous.getLatitude());
            current = current.previous;
        }
        return G;
    }

    public double getF(double G, double H) {
        double F = G + H;
        return F;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
