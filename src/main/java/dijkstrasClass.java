import java.util.Arrays;

public class dijkstrasClass {

    public static boolean testPassed = false;
    public static int numPassedNumerator = 0;
    public static int numPassedDenominator = 0;

    static double[] findBestPath(double[][] adjacencyMatrix, int numVertices) {
        boolean[] visited = new boolean[numVertices];
        double[] shortestDistances = new double[numVertices];

        Arrays.fill(shortestDistances, Double.POSITIVE_INFINITY);
        shortestDistances[0] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int currentNode = findShortestDistance(shortestDistances, visited);
            visited[currentNode] = true;

            for (int nextNode = 0; nextNode < numVertices; nextNode++) {
                if (!visited[nextNode]
                        && adjacencyMatrix[currentNode][nextNode] != 0
                        && adjacencyMatrix[currentNode][nextNode] != Double.POSITIVE_INFINITY
                        && shortestDistances[currentNode] + adjacencyMatrix[currentNode][nextNode] < shortestDistances[nextNode]) {
                    shortestDistances[nextNode] = shortestDistances[currentNode] + adjacencyMatrix[currentNode][nextNode];
                }
            }
        }
        return shortestDistances;
    }

    static int findShortestDistance(double[] distances, boolean[] visited) {
        double min = Double.POSITIVE_INFINITY;
        int index = 0;
        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < min) {
                min = distances[i];
                index = i;
            }
        }
        return index;
    }

    static void runAllTests() {
        caseOne();
        caseTwo();
        caseThree();
        caseFour();
        caseFive();
    }

    public static void main(String[] args) {
        runAllTests();
        if (testPassed) {
            System.out.println("\nAll tests passed.");
        } else {
            System.out.println("\n" + numPassedNumerator + " out of " + numPassedDenominator + " passed.");
        }

    }

    //test cases

    private static void caseOne() {
        int caseNum = 1;
        numPassedDenominator += 1;
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 1); // 0 -> 1
        graph.addEdge(0, 2, 3); // 0 -> 2
        graph.addEdge(1, 3, 4); // 1 -> 3
        graph.addEdge(2, 3, 1); // 2 -> 3
        graph.addEdge(3, 4, 5); // 3 -> 4

        double[] expected = {0, 1, 3, 4, 9};
        assertEquals(graph.adjacencyMatrix, graph.numVertices, expected, caseNum);
    }


    private static void caseTwo() {
        int caseNum = 2;
        numPassedDenominator += 1;

        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 3, 3);

        double[] expected = {0, 2, 3, 6};
        assertEquals(graph.adjacencyMatrix, graph.numVertices, expected, caseNum);
    }

    private static void caseThree() {
        int caseNum = 3;
        numPassedDenominator += 1;
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 6);

        double[] expected = {0.0, 1.0, 3.0, 7.0};
        assertEquals(graph.adjacencyMatrix, graph.numVertices, expected, caseNum);
    }

    private static void caseFour() {
        int caseNum = 4;
        numPassedDenominator += 1;
        Graph graph = new Graph(3);
        graph.addEdge(0, 1, 5);
        graph.addEdge(1, 2, 10);

        double[] expected = {0.0, 5.0, 15.0};
        assertEquals(graph.adjacencyMatrix, graph.numVertices, expected, caseNum);
    }

    private static void caseFive() {
        int caseNum = 5;
        numPassedDenominator += 1;
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);

        double[] expected = {0.0, 1.0, 2.0, Double.POSITIVE_INFINITY};
        assertEquals(graph.adjacencyMatrix, graph.numVertices, expected, caseNum);
    }

    private static void assertEquals(double[][] adjacencyMatrix, int numVertices, double[] expected, int caseNum) {
        double[] actual = dijkstrasClass.findBestPath(adjacencyMatrix, numVertices);

        if (Arrays.equals(expected, actual)) {
            testPassed = true;
            numPassedNumerator += 1;
        } else {
            testPassed = false;
            System.out.println("\nFor case " + caseNum + ":");
            System.out.println("Expected " + Arrays.toString(expected) + " but got " + Arrays.toString(actual));
        }

    }


}
