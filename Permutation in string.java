PROBLEM LINK:
https://leetcode.com/problems/permutation-in-string/submissions/1412291558/?envType=daily-question&envId=2024-10-05


SOLUTION:
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] countS1 = new int[26];
        int[] countWindow = new int[26];
        
        for (char c : s1.toCharArray()) {
            countS1[c - 'a']++;
        }
        
        for (int i = 0; i < s1.length(); i++) {
            countWindow[s2.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (matches(countS1, countWindow)) {
                return true;
            }
            
            if (i + s1.length() < s2.length()) {
                countWindow[s2.charAt(i) - 'a']--;
                countWindow[s2.charAt(i + s1.length()) - 'a']++;
            }
        }
        
        return false;
    }
    
    private boolean matches(int[] countS1, int[] countWindow) {
        for (int i = 0; i < 26; i++) {
            if (countS1[i] != countWindow[i]) {
                return false;
            }
        }
        return true;
    }
}
