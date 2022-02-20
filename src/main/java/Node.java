import java.util.ArrayList;

public class Node {

    public String name;
    public String key;
    public Node previous;
    public double latitude;
    public double longitude;
    public double F;
    
    public static ArrayList<Node> neighbours = new ArrayList<>();

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
        return Utils.getDistance(node.latitude, node.longitude, latitude, longitude);
    }

    public double calculateG(Node startNode) {
        double G = 0;
        Node current = this;

        while (current != startNode) {
            double diff = calculateH(current.previous);
            G = G + diff;
            current = current.previous;
        }
        return G;
    }

    static void getRoute(Node startNode, Node endNode) {
        ArrayList<Node> candidates = new ArrayList<>();
        ArrayList<Node> visited = new ArrayList<>();
        Node current = startNode;
        boolean done = false;

        while (done == false) {
            int minF = 0;
            Object next = null;
            while (current.neighbours) {
                if (neighbours != visited && neighbours != candidates) {
                    candidates.addAll(neighbours);
                    neighbours.previous = current;
                }
            }

            while () {
                if () {
                    done = true;
                    break;
                }
                else () {
                    if (minF == 0 || minF > F) {
                        minF = F;
                        next = 
                        if () {
                            candidates.previous = current;
                        }
                    }
                }
            }
            if (done == false) {
                current = next;
                visited.add(current);
                candidates.remove(current);
            }
        }
        ArrayList<Node> route = new ArrayList<>();
        current = endNode;

        while (current != startNode) {
            route.add(0, current);
            current = current.previous;
        }
        return route;
    }

    //current och previous strular
    //"loopa alla..." fattas
    
    public double getF(Node node) {
        return calculateH(node) + calculateG(node);
    }


}
