/**
 * 
 */
package _83;

import common.ListNode;

/**
 * @author fubaokui
 * @date   2017年2月23日 上午10:08:03
 */
public class Solution {

	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode index = p.next;
        while(index != null){
            if(p.val == index.val){
                p.next = index.next;
                index = index.next;
                if(p != null){
                	index = p.next;
                }
            }else{
                p = p.next;
                if(p != null){
                	index = p.next;
                }
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
		ListNode node4 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		System.out.println(node1.print());
		new Solution().deleteDuplicates(node1);
		System.out.println(node1.print());
		
	}

}
