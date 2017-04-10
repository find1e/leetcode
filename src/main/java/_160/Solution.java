/**
 * 
 */
package _160;

import common.ListNode;

/**
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * @author fubaokui
 * @date   2017年4月5日 下午5:51:59
 */
public class Solution {

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) {
	    		return null;
	    }
	    ListNode a = headA;
	    ListNode b = headB;
	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	    		//for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next; 
	    }
	    
	    return a;
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        
        ListNode startA = headA;
        ListNode startB = headB;
        
        if(lengthA > lengthB){
            int move = lengthA - lengthB;
            startA = move(startA,move);
        } else if(lengthA < lengthB){
            int move = lengthB - lengthA;
            startB = move(startB,move);
        }
        
        while(startA != null && startB != null){
            if(startA == startB){
                return startA;
            }else{
               startA = startA.next;
               startB = startB.next;
            }
        }
        return null;
    }
    
    public int getLength(ListNode headA){
        if(headA == null){
            return 0;
        }
        ListNode p = headA.next;
        int count = 1;
        while(p != null){
            count ++;
            p = p.next;
        }
        return count;
    }
    
    public ListNode move(ListNode headA,int movement){
        while(movement > 0){
            headA = headA.next;
            movement--;
        }
        return headA;
    }
	
    public static void main(String[] args) {
		
    		ListNode headA = new ListNode(1);
    		ListNode headB = new ListNode(2);
    		
    		ListNode node1 = new ListNode(3);
    		ListNode node2 = new ListNode(4);
    		ListNode node3 = new ListNode(5);
    		ListNode node4 = new ListNode(6);
    		ListNode node5 = new ListNode(7);
    		
    		headA.next = node1;
    		headB.next = node2;
    		node2.next = node1;
    		
    		node1.next = node3;
    		node3.next = node4;
    		node4.next = node5;
    	
    		long start = System.currentTimeMillis();
    		System.out.println(new Solution().getIntersectionNode(headA, headB).print());
    		long end1 = System.currentTimeMillis();
    		System.out.println(new Solution().getIntersectionNode2(headA, headB).print());
    		long end2 = System.currentTimeMillis();
    		
    		System.out.println(" length " + (end1 - start));
//    		System.out.println(" length " + (end2 - end1));
	}
    
}
