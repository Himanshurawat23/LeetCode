import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int numberOfCities, int[][] queries) {
        CityGraph cityGraph = new CityGraph(numberOfCities);
        return cityGraph.findShortestPaths(queries);
    }
    
    public class CityGraph {
        private int numberOfCities;
        private List<List<Integer>> adjacencyList;
        private int[] distances;

        public CityGraph(int numberOfCities) {
            this.numberOfCities = numberOfCities;
            this.adjacencyList = new ArrayList<>();
            for (int i = 0; i < numberOfCities; i++) {
                this.adjacencyList.add(new ArrayList<>());
            }
            for (int i = 0; i < numberOfCities - 1; i++) {
                this.adjacencyList.get(i).add(i + 1); // Initial roads from city i to city i + 1
            }
            this.distances = new int[numberOfCities];
            Arrays.fill(distances, Integer.MAX_VALUE);
        }

        public int[] findShortestPaths(int[][] queries) {
            int[] result = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int fromCity = queries[i][0];
                int toCity = queries[i][1];
                this.adjacencyList.get(fromCity).add(toCity);
                result[i] = calculateShortestPath();
            }
            return result;
        }

        private int calculateShortestPath() {
            Arrays.fill(distances, Integer.MAX_VALUE);
            Queue<Integer> queue = new LinkedList<>();
            distances[0] = 0;
            queue.offer(0);

            while (!queue.isEmpty()) {
                int currentCity = queue.poll();
                for (int neighborCity : adjacencyList.get(currentCity)) {
                    if (distances[currentCity] + 1 < distances[neighborCity]) {
                        distances[neighborCity] = distances[currentCity] + 1;
                        queue.offer(neighborCity);
                    }
                }
            }
            return distances[numberOfCities - 1] == Integer.MAX_VALUE ? -1 : distances[numberOfCities - 1];
        }
    }
}
