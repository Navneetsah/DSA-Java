PROBLEM LINK:
https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/?envType=daily-question&envId=2024-09-03


SOLUTION:
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int num = c - 'a' + 1;
            sb.append(num);
        }
        
        String transformed = sb.toString();
        
        for (int i = 0; i < k; i++) {
            transformed = transform(transformed);
        }
        
        return Integer.parseInt(transformed);
    }
    
    private String transform(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        return String.valueOf(sum);
    }
}
