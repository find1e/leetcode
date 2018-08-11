package _86;

import common.ListNode;
import common.ListNodeUtil;

/**
 * @author fubaokui
 * @date 2018/08/09
 */
public class Main {



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = ListNodeUtil.generate(new int[] {3, 1, 2});
		ListNodeUtil.print(head);
		new Solution().partition(head, 3);
		ListNodeUtil.print(head);
	}

}


class Solution {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = head;
		ListNode lt = null;
		int geCount = 0;
		while (p != null) {
			if (p.val >= x) {
				geCount++;
			} else {
				if (geCount == 0) {
					lt = p;
				} else {
					// move
					ListNode q = null;
					if (lt != null) {
						q = lt.next;
					} else {
						q = head;
					}
					int ltNextValue = q.val;
					while (q != p) {
						int temp = q.next.val;
						q.next.val = ltNextValue;
						ltNextValue = temp;
						q = q.next;
					}
					if (lt != null) {
						lt.next.val = ltNextValue;
						lt = lt.next;
					} else {
						head.val = ltNextValue;
						lt = head;
					}

				}
			}
			p = p.next;
		}
		return head;
	}
}
