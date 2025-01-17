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
        ArrayList<int[]> orderedRuns = new ArrayList<int[]>();
        int[] runPair = new int[2];
        runPair[0] = temperatures[0];
        runPair[1] = 1;
        orderedRuns.add(runPair);
        int[] info = new int[temperatures.length];
        int maxRun;
        for(int i = 0; i < temperatures.length; i++) {
            runPair = new int[2];
            runPair[0] = temperatures[i];
            maxRun = 0;
//            for (int j = 0; j < i; j++) {
//                if(temperatures[j] < temperatures[i] && info[j] > maxRun) {
//                    maxRun = info[j];
//                }
//            }
            int j = 0;
            while(orderedRuns.get(j)[0] < temperatures[i] && j < i){
                if(orderedRuns.get(j)[0] < temperatures[i] && orderedRuns.get(j)[1] > maxRun) {
                    maxRun = orderedRuns.get(j)[1];
                }
                j++;
            }
            runPair[1] = maxRun + 1;
            orderedRuns.add(j, runPair);
        }
        int max = 0;
        for(int i = 0; i < info.length; i++){
            if(info[i] > max){
                maxRun = info[i];
            }
        }
        return max;
    }
}
