package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerformanceMetrics {
    private static Map<String, List<Long>> timings = new HashMap<>();
    
    public static void startTimer(String operation) {
        timings.putIfAbsent(operation, new ArrayList<>());
        timings.get(operation).add(System.currentTimeMillis());
    }
    
    public static void stopTimer(String operation) {
        long duration = System.currentTimeMillis() - timings.get(operation).get(timings.get(operation).size()-1);
        timings.get(operation).set(timings.get(operation).size()-1, duration);
    }
}
