package linklist;

import java.util.LinkedList;
import java.util.List;

import common.ListNode;
import common.ListNodeUtil;

/**
 * 合并两个有序的单链表
 * 
 * @author fubaokui
 * @date 2018-12-11 11:12:49
 */
public class MergeKList {

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

	public ListNode mergeKList(List<ListNode> lists) {
		if (lists == null) {
			return null;
		}
		if (lists.size() == 1) {
			return lists.get(0);
		}
		if (lists.size() == 2) {
			return recursiveMerge(lists.get(0), lists.get(1));
		}

		ListNode result = lists.get(0);
		for (int i = 1; i < lists.size(); i++) {
			result = recursiveMerge(result, lists.get(i));
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode l1 = ListNodeUtil.generate(new int[] {1, 2, 3, 4, 5});
		ListNode l2 = ListNodeUtil.generate(new int[] {6, 8});
		ListNode l3 = ListNodeUtil.generate(new int[] {1, 4});
		ListNode l4 = ListNodeUtil.generate(new int[] {5, 7});
		List<ListNode> listNodes = new LinkedList<>();
		listNodes.add(l1);
		listNodes.add(l2);
		listNodes.add(l3);
		listNodes.add(l4);

		ListNode merged = new MergeKList().mergeKList(listNodes);
		ListNodeUtil.print(merged);
	}

}
