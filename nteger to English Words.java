PROBLEM LINK:

https://leetcode.com/problems/integer-to-english-words/description/?envType=daily-question&envId=2024-08-07


SOLUTION:

class Solution {
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        StringBuilder words = new StringBuilder();
        int i = 0;
        
        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder chunk = new StringBuilder();
                helper(num % 1000, chunk);
                words.insert(0, chunk.append(THOUSANDS[i]).append(" "));
            }
            num /= 1000;
            i++;
        }
        
        return words.toString().trim();
    }

    private void helper(int num, StringBuilder chunk) {
        if (num == 0) return;
        else if (num < 20) chunk.append(LESS_THAN_20[num]).append(" ");
        else if (num < 100) {
            chunk.append(TENS[num / 10]).append(" ");
            helper(num % 10, chunk);
        } else {
            chunk.append(LESS_THAN_20[num / 100]).append(" Hundred ");
            helper(num % 100, chunk);
        }
    }
}
