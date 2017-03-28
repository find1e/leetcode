/**
 * 
 */
package common;

/**
 * @author fubaokui
 * @date   2017年2月23日 下午4:23:27
 */
public class ListNodeUtil {

	public static ListNode generate(int[] arrays){
		if(arrays == null || arrays.length == 0){
			return null;
		}
		ListNode head = new ListNode(arrays[0]);
		ListNode next = head;
		for(int i =1;i<arrays.length;i++){
			next.next = new ListNode(arrays[i]);
			next = next.next;
		}
		return head;
	}
	
	public static ListNode getTailNode(ListNode head){
		if(head == null || head.next == null){
			return null;
		}
		ListNode tail = head.next;
		while(tail.next != null){
			tail = tail.next;
		}
		return tail;
	}
	
	public static int getListNodeLength(ListNode head){
		if(head == null){
			return 0;
		}
		int count = 0;
		while(head != null){
			count ++;
			head = head.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		ListNode head = ListNodeUtil.generate(new int[]{1,2,3,4});
		ListNode tail = ListNodeUtil.getTailNode(head);
		System.out.println(ListNodeUtil.getListNodeLength(head));
	}
	
}
