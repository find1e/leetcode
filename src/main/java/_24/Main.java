/**
 * 
 */
package _24;

import common.ListNode;

/**
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * 		Given 1->2->3->4, you should return the list as 2->1->4->3.
 * @author fubaokui
 * @date   2017年2月22日 下午5:40:18
 */
public class Main {

	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        while(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
            
            first = second.next;
            if(first != null){
                second = first.next;
            }
        }
        return head;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
//		node3.next = node4;
		
		System.out.println(node1.print());
		
		ListNode newNode = new Main().swapPairs(node1);
		
		System.out.println(newNode.print());
		
	}

}
