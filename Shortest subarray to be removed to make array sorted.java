PROBLEM LINK:
https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/submissions/1453140828/?envType=daily-question&envId=2024-11-15


SOLUTION:
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;
        while (l + 1 < n && arr[l] <= arr[l + 1]) ++l;
        if (l == n - 1) return 0;
        while (r > l && arr[r - 1] <= arr[r]) --r;
        int res = Math.min(n - l - 1, r);
        for (int i = 0, j = r; i <= l && j < n; ) 
            if (arr[i] <= arr[j]) res = Math.min(res, j - i++ - 1);
            else ++j;
        return res;
    }
}
