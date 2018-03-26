/*
  * you can see the problem on this link https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int FindMergeNode(Node headA, Node headB) {
    // Complete this function
    // Do not write the main method.
    Node coppy = new Node();
    while (headA!=null){
        coppy = headB;
        while(coppy!=null){
            if (coppy==headA){
                return coppy.data;
            }
            coppy = coppy.next;
        }
        headA=headA.next;
    }
    return 0;

}