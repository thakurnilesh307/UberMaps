
public class Graph {
    public double[][] adjacencyMatrix;
    final int numVertices;


    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new double[numVertices][numVertices];
    }

    void addEdge(int i, int j, double weight) {
        if (i < 0 || i >= numVertices || j < 0 || j >= numVertices) {
            throw new IllegalArgumentException("Vertex indices are out of bounds.");
        }
        adjacencyMatrix[i][j] = weight;
        //links.add()
        adjacencyMatrix[j][i] = weight; //only use if both directions are equal.
    }

}



