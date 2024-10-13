PROBLEM LINK:
https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/submissions/1420795943/?envType=daily-question&envId=2024-10-13


SOLUTION:
import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> nums.get(a[0]).get(a[1])));
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            minHeap.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        
        int[] result = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        int currentRange = Integer.MAX_VALUE;
        
        while (true) {
            int[] minElement = minHeap.poll();
            int listIndex = minElement[0];
            int elementIndex = minElement[1];
            int currentMin = nums.get(listIndex).get(elementIndex);
            
            if (max - currentMin < currentRange) {
                currentRange = max - currentMin;
                result[0] = currentMin;
                result[1] = max;
            }
            
            elementIndex++;
            if (elementIndex >= nums.get(listIndex).size()) {
                break;
            }
            
            int nextElement = nums.get(listIndex).get(elementIndex);
            if (nextElement > max) {
                max = nextElement;
            }
            
            minHeap.offer(new int[]{listIndex, elementIndex});
        }
        
        return result;
    }
}
