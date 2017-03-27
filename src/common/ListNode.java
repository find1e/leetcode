package common;

public class ListNode {
	 public int val;
	 public ListNode next;
	 
	 public ListNode(int x) { val = x; }
	 
	 public String print(){
		 StringBuilder builder = new StringBuilder();
		 builder.append(val);
		 ListNode p = next;
		 while(p != null){
			 builder.append("->").append(p.val);
			 p = p.next;
		 }
		 return builder.toString();
	 }
}
