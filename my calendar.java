PROBLEM LINK:
https://leetcode.com/problems/my-calendar-i/submissions/1402773530/?envType=daily-question&envId=2024-09-26


SOLUTION:
import java.util.*;

class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorEntry = calendar.floorEntry(start);
        if (floorEntry != null && floorEntry.getValue() > start) {
            return false;
        }
        
        Map.Entry<Integer, Integer> ceilingEntry = calendar.ceilingEntry(start);
        if (ceilingEntry != null && ceilingEntry.getKey() < end) {
            return false;
        }
        
        calendar.put(start, end);
        return true;
    }
}
