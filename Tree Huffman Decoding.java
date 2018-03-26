/*
* you can see the problem on this link https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
*/
/*  
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;
    
*/ 

void decode(String S ,Node root)
    {
        String curr = "";
        String ispis = "";
        Node coppy = root;
        int counter = 0;
        
        while(counter < S.length()){
            while (root.left != null || root.right != null){
                curr = String.valueOf(S.charAt(counter));
                counter++;
                if (curr.equals("0")){
                  root = root.left;
               }else{
                  root = root.right;
               }
            }
            
            ispis+=String.valueOf(root.data);
            root = coppy;
            curr = "";
        }
        
        System.out.println(ispis);
       
    }