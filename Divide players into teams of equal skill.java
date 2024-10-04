PROBLEM LINK:
https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/submissions/1411547707/?envType=daily-question&envId=2024-10-04


SOLUTION:
class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        
        int n = skill.length;
        int totalSkill = skill[0] + skill[n - 1];
        long chemistrySum = 0;
        
        for (int i = 0; i < n / 2; i++) {
            if (skill[i] + skill[n - 1 - i] != totalSkill) {
                return -1;
            }
            chemistrySum += (long) skill[i] * skill[n - 1 - i];
        }
        
        return chemistrySum;
    }
}
