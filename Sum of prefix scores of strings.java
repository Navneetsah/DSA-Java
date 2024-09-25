PROBLEM LINK:
https://leetcode.com/problems/sum-of-prefix-scores-of-strings/?envType=daily-question&envId=2024-09-25


SOLUTION:
class Solution {
    class TrieNode {
        TrieNode[] children;
        int count;
        
        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }
    
    class Trie {
        TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
                current.count++;
            }
        }
        
        int getPrefixScore(String word) {
            TrieNode current = root;
            int score = 0;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                current = current.children[index];
                score += current.count;
            }
            return score;
        }
    }
    
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        
        for (String word : words) {
            trie.insert(word);
        }
        
        int[] answer = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            answer[i] = trie.getPrefixScore(words[i]);
        }
        
        return answer;
    }
}
