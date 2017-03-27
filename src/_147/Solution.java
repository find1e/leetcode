/**
 * 
 */
package _147;

import common.ListNode;
import common.ListNodeUtil;

/**
 * 
 * Sort a linked list using insertion sort.
 * 
 * @author fubaokui
 * @date   2017年2月24日 下午5:30:11
 */
public class Solution {

	 public ListNode insertionSortList(ListNode head) {
	        if(head == null || head.next == null){
	            return head;
	        }
	        ListNode sortedHead = head;
	        ListNode index = head.next;
	        head.next = null;
	        while(index != null){
	            ListNode p = sortedHead;
	            while(p != null){
	                if(index.val < p.val){
	                    //先交换val,再交换指针
	                   int val = p.val;
	                   p.val = index.val;
	                   index.val = val;
	                   
	                   ListNode temp = index.next;
	                   index.next = p.next;
	                   p.next = index;
	                   index = temp;
	                   break ;
	                }else{
	                    if(p.next == null){
	                    	ListNode temp = index.next;
	                    	p.next = index;
	                    	index.next = null;
	                    	index = temp;
	                    	break;
	                    }else{
	                    	p = p.next;
	                    }
	                }
	            }
	        }
	        return sortedHead;
	    }
	
	 public static void main(String[] args) {
		
		 ListNode source = ListNodeUtil.generate(new int[]{10,23,3,9,13,4,2,7,5});
		 System.out.println(source.print());
		 ListNode sorted = new Solution().insertionSortList(source);
		 System.out.println(sorted.print());
	}
	 
}
