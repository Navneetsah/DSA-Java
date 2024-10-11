PROBLEM LINK:
https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/submissions/1418760896/?envType=daily-question&envId=2024-10-11


SOLUTION:
import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(new int[]{times[i][0], i, 1});
            events.add(new int[]{times[i][1], i, -1});
        }
        
        events.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[2] - b[2];
        });
        
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.offer(i);
        }
        
        Map<Integer, Integer> chairMap = new HashMap<>();
        
        for (int[] event : events) {
            int time = event[0];
            int friendIdx = event[1];
            int type = event[2];
            
            if (type == 1) {
                int chair = availableChairs.poll();
                chairMap.put(friendIdx, chair);
                if (friendIdx == targetFriend) {
                    return chair;
                }
            } else {
                int chair = chairMap.get(friendIdx);
                availableChairs.offer(chair);
            }
        }
        
        return -1;
    }
}
