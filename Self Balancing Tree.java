/*
* you can see the problem on this link https://www.hackerrank.com/challenges/self-balancing-tree/problem
*/
/* Class node is defined as :
    class Node 
       int val;   //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;   //Right child

   */

   private static int height(Node root) {
       if(root == null)
           return -1;
       else 
           return root.ht;
   }

   private static int setHeight(Node root) {
       if(root == null) {
           return -1;
       } 
       else {
           return 1 + Math.max(height(root.left), height(root.right));
       }
   }

    private static Node rotateRight(Node root){
        Node newRoot = root.left;
        root.left=newRoot.right;
        newRoot.right=root;
        root.ht=setHeight(root);
        newRoot.ht=setHeight(newRoot);
        return newRoot;
    }

    private static Node rotateLeft(Node root){
        Node newRoot = root.right;
        root.right=newRoot.left;
        newRoot.left=root;
        root.ht=setHeight(root);
        newRoot.ht=setHeight(newRoot);
        return newRoot;
    }

    
   static Node insert(Node root,int val)
    {
       if(root == null) {
           root = new Node();
           root.val = val;
           root.ht = setHeight(root);
           return root;
       }
       if(val <= root.val ) {
           root.left = insert(root.left, val);
       }
       else if (val > root.val) {
           root.right = insert(root.right, val);
       }
       
       int balance=height(root.left)-height(root.right);
       if(balance>=-1 && balance<=1){
           root.ht=setHeight(root);
       }else if(balance<-1){
           if(height(root.right.right) >= height(root.right.left)){
               root=rotateLeft(root);
           }else{
               root.right=rotateRight(root.right);
               root=rotateLeft(root);
           }
       }else {
           if(height(root.left.left) >= height(root.left.right)){
               root=rotateRight(root);
           }else{
               root.left=rotateLeft(root.left);
               root=rotateRight(root);
           }
       }
       
       return root;
    }