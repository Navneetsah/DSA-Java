PROBLEM LINK:
https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/submissions/1433308244/?envType=daily-question&envId=2024-10-25


SOLUTION:
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        
        List<String> result = new ArrayList<>();
        String lastFolder = "";
        
        for (String f : folder) {
            if (lastFolder.isEmpty() || !f.startsWith(lastFolder + "/")) {
                result.add(f);
                lastFolder = f;
            }
        }
        
        return result;
    }
}
