package LeetCode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LogSystem {
    private static class Log {
        int id;
        String timestamp;

        Log(int id, String timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    private final List<Log> logs;
    private final Map<String, Integer> granularityIndex;

    public LogSystem() {
        logs = new ArrayList<>();
        granularityIndex = new HashMap<>();
        granularityIndex.put("Year", 4);
        granularityIndex.put("Month", 7);
        granularityIndex.put("Day", 10);
        granularityIndex.put("Hour", 13);
        granularityIndex.put("Minute", 16);
        granularityIndex.put("Second", 19);
    }

    public void put(int id, String timestamp) {
        logs.add(new Log(id, timestamp));
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> result = new ArrayList<>();
        int idx = granularityIndex.get(granularity);

        String startPrefix = start.substring(0, idx);
        String endPrefix = end.substring(0, idx);

        for (Log log : logs) {
            String logPrefix = log.timestamp.substring(0, idx);
            if (logPrefix.compareTo(startPrefix) >= 0 &&
                    logPrefix.compareTo(endPrefix) <= 0) {
                result.add(log.id);
            }
        }
        return result;
    }
}


public class DesignLogStorageSystem {
}

