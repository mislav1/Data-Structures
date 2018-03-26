/*
* you can see the problem on this link https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
*/

/* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

static Node Insert(Node root,int value) {

       Node zapamti = root;
       Node newNode = new Node();
       newNode.data = value;
       newNode.right = null;
       newNode.left = null;
       if (root == null){
           zapamti = newNode;
       }
        while(root != null){
            if (value < root.data){
                if (root.left !=null){
                    root = root.left;
                }else{
                    root.left = newNode;
                    return zapamti;
                }
                
            }else if (value > root.data){
                if (root.right != null){
                    root = root.right;
                }else{
                    root.right = newNode;
                    return zapamti;
                }
                
            }
        }
        return zapamti;
    }

