PROBLEM LINK:
https://leetcode.com/problems/maximal-score-after-applying-k-operations/submissions/1422083714/?envType=daily-question&envId=2024-10-14


SOLUTION:
import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        long score = 0;
        
        for (int i = 0; i < k; i++) {
            int maxVal = maxHeap.poll();
            score += maxVal;
            int newVal = (int) Math.ceil(maxVal / 3.0);
            maxHeap.add(newVal);
        }
        
        return score;
    }
}
