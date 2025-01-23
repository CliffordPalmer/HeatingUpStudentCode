import java.util.ArrayList;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author YOUR NAME HERE
 */

public class WeatherPatterns {


    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        // Arrays to hold the length of runs and the visited status of temperatures
        int[] runs = new int[temperatures.length];
        boolean[] visited = new boolean[temperatures.length];
        // Adjacency list: an array of ArrayLists which records each node's leading connections
        ArrayList<Integer>[] adjacencyList= new ArrayList[temperatures.length];
        // Initialize adjacency list with ArrayList objects
        for(int i = 0; i < temperatures.length; i++){
            adjacencyList[i] = new ArrayList<>();
        }
        // Build adjacency list
        for(int i = 0; i < temperatures.length; i++) {
            for (int j = 0; j < i; j++) {
                // Add temperatures lower than the current temperature
                if(temperatures[j] < temperatures[i]) {
                    adjacencyList[i].add(j);
                }
            }
        }
        // For each temperature, call a recursive calculation of the run
        for(int i = 0; i < temperatures.length; i++){
            runs[i] = LongestPathTo(i, visited, runs, adjacencyList);
            visited[i] = true;
        }
        // Find the longest run
        int max = 0;
        for(int i = 0; i < runs.length; i++){
            if(runs[i] > max){
                max = runs[i];
            }
        }
        // Return the longest run
        return max;
    }
    // Recursive function which calculates the run length for a specific temperature
    public static int LongestPathTo(int index, boolean[] visited, int[] runs, ArrayList<Integer>[] adjacencyList){
        // Base case: skip the recursive calls if the index has been visited
        if(visited[index] == true){
            return runs[index];
        }
        int len = 0;
        // Check every temperature in the adjacency list for the longest run so far
        for(int i = 0; i < adjacencyList[index].size(); i++){
            len = Math.max(len, LongestPathTo(adjacencyList[index].get(i), visited, runs, adjacencyList));
        }
        // Add the current temperature to the run and return the run length
        return 1 + len;
    }
}


