/*Return an edge that can be removed so that the resulting graph is a tree of N nodes. 
If there are multiple answers, return the answer that occurs last in the given 2D-array. 
The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]

Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
*/

//https://leetcode.com/problems/redundant-connection/

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFinder uf = new UnionFinder(edges.length + 1);
        
        for(int[] edge : edges) {
            if(!uf.union(edge[0], edge[1])) return edge;
        }
        return new int[2];
    }
}

class UnionFinder {
    int[] parent;
    int[] rank;
    
    UnionFinder(int n) {
        //create and initialize parent
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            //initially every node's parent is that node itself
            parent[i] = i;
        }
        //create and initialize rank (priority)
        //initially every node has same rank i.e. 0
        rank = new int[n];
    }
    
    public int findParent(int node) {
        //if parent of a node is itself return that node
        if(parent[node] == node) return node;
        
        //if a node is not itself's parent then 
        //find parent of its parent
        if(parent[node] != node) parent[node] = findParent(parent[node]);
        return parent[node];
    }
    
    public boolean union(int x, int y) {
        //find and store parent of x and y
        int xParent = findParent(x);
        int yParent = findParent(y);
        
        //if x and y's parent are same, return false
        if(xParent == yParent) return false;
        
        // if xParent has higher rank then
        //yParent's parent will be xParent
        else if(rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        }
        //and vice versa here
        else if(rank[yParent] > rank[xParent]) {
            parent[xParent] = yParent;
        }
        // if x and y's parent are different but have same rank
        else {
            //make any one of them the parent of the other 
            //and increase it's rank
            parent[xParent] = yParent;
            rank[yParent]++;
        }
        
        return true;
    }
}