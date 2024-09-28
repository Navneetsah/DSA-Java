PROBLEM LINK:
https://leetcode.com/problems/my-calendar-ii/submissions/1404545104/?envType=daily-question&envId=2024-09-27


SOLUTION:
import java.util.*;

class MyCalendarTwo {
    List<int[]> singleBookings;
    List<int[]> doubleBookings;

    public MyCalendarTwo() {
        singleBookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] db : doubleBookings) {
            if (Math.max(start, db[0]) < Math.min(end, db[1])) {
                return false;
            }
        }
        
        for (int[] sb : singleBookings) {
            int overlapStart = Math.max(start, sb[0]);
            int overlapEnd = Math.min(end, sb[1]);
            if (overlapStart < overlapEnd) {
                doubleBookings.add(new int[]{overlapStart, overlapEnd});
            }
        }
        
        singleBookings.add(new int[]{start, end});
        return true;
    }
}
