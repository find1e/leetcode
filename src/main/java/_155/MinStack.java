/**
 * 
 */
package _155;

import java.util.LinkedList;

/**
 * @author fubaokui
 * @date 2017年8月12日 下午3:14:28
 */
public class MinStack {

	LinkedList<Integer> store = null;

	private int min = Integer.MAX_VALUE;
	
	/** initialize your data structure here. */
	public MinStack() {
		store = new LinkedList<Integer>();
	}

	public void push(int x) {
		if(x < min || store.isEmpty()){
			min = x;
		}
		store.add(x);
	}

	public void pop() {
		if (store == null || store.isEmpty()) {
			return;
		}
		int removed = store.removeLast();
		if(removed == min){
			min = findMin();
		}
	}

	public int top() {
		return store.getLast();
	}

	public int findMin(){
		if(store.isEmpty()){
			return min;
		}
		int min = store.getFirst();
		for (Integer value : store) {
			if (min > value) {
				min = value;
			}
		}
		return min;
	}
	
	public int getMin() {
		return min;
	}

}
