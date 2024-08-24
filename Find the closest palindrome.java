PROBLEM LINK:
https://leetcode.com/problems/find-the-closest-palindrome/?envType=daily-question&envId=2024-08-24


SOLUTION:
class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();

        if (num == 1) return "0";

        List<Long> candidates = new ArrayList<>();
        candidates.add((long)Math.pow(10, len) + 1);
        candidates.add((long)Math.pow(10, len - 1) - 1);

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = -1; i <= 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(prefix + i);

            String firstHalf = sb.toString();
            String secondHalf = new StringBuilder(firstHalf).reverse().toString();
            String palindrome;
            if (len % 2 == 0) {
                palindrome = firstHalf + secondHalf;
            } else {
                palindrome = firstHalf + secondHalf.substring(1);
            }
            candidates.add(Long.parseLong(palindrome));
        }

        long closest = -1;
        for (long candidate : candidates) {
            if (candidate != num) {
                if (closest == -1 ||
                    Math.abs(candidate - num) < Math.abs(closest - num) ||
                    (Math.abs(candidate - num) == Math.abs(closest - num) && candidate < closest)) {
                    closest = candidate;
                }
            }
        }

        return String.valueOf(closest);
    }
}
