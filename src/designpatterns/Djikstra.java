package designpatterns;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Djikstra {

    List<String> processed = new ArrayList<>();


    public static void main(String[] args) {

        Djikstra dj = new Djikstra();
        Hashtable<String, Integer> costs = new Hashtable<>();
        Hashtable<String, String> parents = new Hashtable<>();
        Hashtable<String, Hashtable<String,Integer>> graph = dj.populateGraph();


        // Populate Starting Costs for all nodes
        int infinity = (int)Double.POSITIVE_INFINITY;

        costs.put("A",4);
        costs.put("B",infinity);
        costs.put("C",10);
        costs.put("D",infinity);
        costs.put("E",infinity);
        costs.put("Finish",infinity);

        // Populate Starting Parents for all nodes
        parents.put("A","Start");
        parents.put("B","None");
        parents.put("C","Start");
        parents.put("D","None");
        parents.put("E","None");
        parents.put("Finish","None");


        /// Find costs to each neighbor of all nodes in Costs (starting with lowest cost node) ///

        for (String key : costs.keySet()) {

            // Find Lowest Code node
            String keyToProcess = dj.findLowestCostNode(costs);
            int costOfKeyToProcess = costs.get(keyToProcess);

            // Neighbors of this node
            Hashtable<String, Integer> nodeNeighbors = graph.get(keyToProcess);

            // Calculate cost to each neighbor from this node (and update Costs & Parents if new cost is less)
            if (null != nodeNeighbors) {
                for (String s : nodeNeighbors.keySet()) {
                    // Cost to neighbor (from lowest cost node)
                    int newCost = costOfKeyToProcess + nodeNeighbors.get(s);

                    // Compare with cost in Costs table
                    if (newCost < costs.get(s)) {

                        // Update Costs table
                        costs.put(s, newCost);

                        // Update Parents table
                        parents.put(s, keyToProcess);
                    }
                }
            }

            // Mark this node as processed
            dj.processed.add(keyToProcess);

        }

        System.out.println();

        }

    private String findLowestCostNode(Hashtable<String, Integer> costs) {
        String lowestKey = null;
        int lowestValue = (int) Double.POSITIVE_INFINITY;

        for (String key : costs.keySet()) {
            if (!processed.contains(key) && costs.get(key) < lowestValue) {
                lowestValue = costs.get(key);
                lowestKey = key;
            }
        }
        return lowestKey;
    }

    private Hashtable<String, Hashtable<String, Integer>> populateGraph() {
        Hashtable<String, Hashtable<String,Integer>> graph = new Hashtable<>();
        Hashtable<String, Integer> neighborsOfStart = new Hashtable<>();
        Hashtable<String, Integer> neighborsOfA = new Hashtable<>();
        Hashtable<String, Integer> neighborsOfB = new Hashtable<>();
        Hashtable<String, Integer> neighborsOfC = new Hashtable<>();
        Hashtable<String, Integer> neighborsOfD = new Hashtable<>();
        Hashtable<String, Integer> neighborsOfE = new Hashtable<>();

        // Neighbors of Start
        neighborsOfStart.put("A",4);
        neighborsOfStart.put("C",10);

        // Neighbors of A
        neighborsOfA.put("B",21);

        // Neighbors of B
        neighborsOfB.put("Finish",4);

        // Neighbors of C
        neighborsOfC.put("D",5);
        neighborsOfC.put("E",8);

        // Neighbors of D
        neighborsOfD.put("B",5);

        // Neighbors of E
        neighborsOfE.put("B",12);


        // Add all nodes and its neighbors to Graph
        graph.put("Start",neighborsOfStart);
        graph.put("A",neighborsOfA);
        graph.put("B",neighborsOfB);
        graph.put("C",neighborsOfC);
        graph.put("D",neighborsOfD);
        graph.put("E",neighborsOfE);

        return graph;
    }
}
