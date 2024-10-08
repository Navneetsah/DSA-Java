PROBLEM LINK:
https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/?envType=daily-question&envId=2024-10-08


SOLUTION:
class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int swaps = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                balance++;
            } else {
                balance--;
            }
            
            if (balance < 0) {
                swaps++; 
                balance = 1;
            }
        }
        
        return swaps;
    }
}
