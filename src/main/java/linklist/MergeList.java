package linklist;

import common.ListNode;
import common.ListNodeUtil;

/**
 * 合并两个有序的单链表
 * 
 * @author fubaokui
 * @date 2018-12-11 11:12:49
 */
public class MergeList {

	public ListNode recursiveMerge(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = recursiveMerge(l1.next, l2);
			return l1;
		} else {
			l2.next = recursiveMerge(l1, l2.next);
			return l2;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = ListNodeUtil.generate(new int[] {1, 2, 3, 4, 5});
		ListNode l2 = ListNodeUtil.generate(new int[] {1, 4, 4, 6, 8});
		ListNode merged = new MergeList().recursiveMerge(l1, l2);
		ListNodeUtil.print(merged);
	}

}
