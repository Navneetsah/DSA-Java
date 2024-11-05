PROBLEM LINK:
https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/submissions/1443445054/?envType=daily-question&envId=2024-11-05


SOLUTION:
class Solution {
    public int minChanges(String s) {
        int res = 0;

        for (int i = 1; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res++;
            }
        }


        return res;
    }
}
