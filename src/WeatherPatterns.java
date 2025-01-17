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
        int[] info = new int[temperatures.length];
        int maxRun;
        for(int i = 0; i < temperatures.length; i++) {
            maxRun = 0;
            for (int j = 0; j < i; j++) {
                if(temperatures[j] < temperatures[i] && info[j] > maxRun) {
                    maxRun = info[j];
                }
            }
            info[i] = maxRun + 1;
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
