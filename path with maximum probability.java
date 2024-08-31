PROBLEM LINK:
https://leetcode.com/problems/path-with-maximum-probability/?envType=daily-question&envId=2024-08-31


SOLUTION:
import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double prob = succProb[i];
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new double[]{edge[1], prob});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new double[]{edge[0], prob});
        }
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1.0});
        
        double[] maxProb = new double[n];
        Arrays.fill(maxProb, 0.0);
        maxProb[start] = 1.0;
        
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int node = (int) curr[0];
            double prob = curr[1];
            
            if (node == end) {
                return prob;
            }
            
            if (prob < maxProb[node]) {
                continue;
            }
            
            List<double[]> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for (double[] neighbor : neighbors) {
                int nextNode = (int) neighbor[0];
                double nextProb = neighbor[1];
                double newProb = prob * nextProb;
                
                if (newProb > maxProb[nextNode]) {
                    maxProb[nextNode] = newProb;
                    pq.offer(new double[]{nextNode, newProb});
                }
            }
        }
        
        return 0.0;
    }
}
