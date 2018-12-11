package linklist;

import common.ListNode;
import common.ListNodeUtil;

/**
 * 单链表反转
 * 
 * @author fubaokui
 * @date 2018-12-11 11:12:41
 */
public class ReverseList {

	public ListNode reverse(ListNode list) {
		ListNode newList = null;
		while (list != null) {
			ListNode next = list.next;
			list.next = newList;
			newList = list;
			list = next;
		}
		return newList;
	}

	public static void main(String[] args) {
		ListNode listNode = ListNodeUtil.generate(new int[] {5, 4, 3, 2, 1});
		ListNodeUtil.print(listNode);
		listNode = new ReverseList().reverse(listNode);
		ListNodeUtil.print(listNode);
	}



}
