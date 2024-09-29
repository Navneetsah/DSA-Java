PROBLEM LINK:
https://leetcode.com/problems/all-oone-data-structure/submissions/1406032600/?envType=daily-question&envId=2024-09-29


SOLUTION:
import java.util.*;

class AllOne {

    private class Node {
        String key;
        int count;

        public Node(String key, int count) {
            this.key = key;
            this.count = count;
        }
    }

    private class Bucket {
        int count;
        Set<String> keys;

        public Bucket(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Integer> map;
    private TreeMap<Integer, Set<String>> countMap;

    public AllOne() {
        map = new HashMap<>();
        countMap = new TreeMap<>();
    }

    public void inc(String key) {
        int count = map.getOrDefault(key, 0);
        map.put(key, count + 1);

        if (count > 0) {
            countMap.get(count).remove(key);
            if (countMap.get(count).isEmpty()) {
                countMap.remove(count);
            }
        }

        countMap.computeIfAbsent(count + 1, k -> new HashSet<>()).add(key);
    }

    public void dec(String key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }

        countMap.get(count).remove(key);
        if (countMap.get(count).isEmpty()) {
            countMap.remove(count);
        }

        if (count > 1) {
            countMap.computeIfAbsent(count - 1, k -> new HashSet<>()).add(key);
        }
    }

    public String getMaxKey() {
        if (countMap.isEmpty()) return "";
        return countMap.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        if (countMap.isEmpty()) return "";
        return countMap.firstEntry().getValue().iterator().next();
    }
}
