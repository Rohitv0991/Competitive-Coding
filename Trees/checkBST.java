// Given the root node of a binary tree, can you determine if it's a binary search tree?

/*
The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

// https://www.hackerrank.com/challenges/is-binary-search-tree/problem

    boolean checkBST(Node root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        
        for(int i = 0; i < list.size()-1; i++) {
            if (list.get(i) < list.get(i+1)) continue;
            else return false;
        }
        return true;
    }

    void inorder(Node root, ArrayList<Integer> list) {
        if(root == null) return;
        
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
        
        return;
    }
