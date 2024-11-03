PROBLEM LINK:
https://leetcode.com/problems/rotate-string/submissions/1441542728/?envType=daily-question&envId=2024-11-03


SOlUTION:
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String doubledS = s + s;
        return doubledS.contains(goal);
    }
}
