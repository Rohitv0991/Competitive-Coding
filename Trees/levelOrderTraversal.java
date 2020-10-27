/*Given a pointer to the root of a binary tree, you need to print the level order traversal of this tree. 
In level-order traversal, nodes are visited level by level from left to right. 
Complete the function and print the values in a single line separated by a space.*/

/*    
class Node 
  int data;
  Node left;
  Node right;
*/

//https://www.hackerrank.com/challenges/tree-level-order-traversal/problem?isFullScreen=false

public static void levelOrder(Node root) {
      if(root == null) return;

      Queue<Node> store = new LinkedList<>();

      store.add(root);

      while(!store.isEmpty()) {
          Node temp = store.poll();
          System.out.print(temp.data+" ");

          if(temp.left != null) {
              store.add(temp.left);
          }
          if(temp.right != null) {
              store.add(temp.right);
          }
      } 
  }
