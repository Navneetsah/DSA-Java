PROBLEM LINK:
https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/submissions/1419641885/?envType=daily-question&envId=2024-10-12


SOLUTION:
import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        Map<Integer, Integer> events = new TreeMap<>();
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1] + 1;
            
            events.put(start, events.getOrDefault(start, 0) + 1);
            events.put(end, events.getOrDefault(end, 0) - 1);
        }
        
        int active = 0;
        int maxGroups = 0;
        
        for (int count : events.values()) {
            active += count;
            maxGroups = Math.max(maxGroups, active);
        }
        
        return maxGroups;
    }
}
