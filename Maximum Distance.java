PROBLEM LINK:
https://leetcode.com/problems/maximum-distance-in-arrays/?envType=daily-question&envId=2024-08-16


SOLUTION:
import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        if (n < 2) return 0;
        
        int maxDistance = 0;
        int minValue = arrays.get(0).get(0);
        int maxValue = arrays.get(0).get(arrays.get(0).size() - 1);
        
        for (int i = 1; i < n; i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);
            
            int distance1 = Math.abs(currentMax - minValue);
            int distance2 = Math.abs(currentMin - maxValue);
            
            maxDistance = Math.max(maxDistance, distance1);
            maxDistance = Math.max(maxDistance, distance2);
            
            minValue = Math.min(minValue, currentMin);
            maxValue = Math.max(maxValue, currentMax);
        }
        
        return maxDistance;
    }
}
