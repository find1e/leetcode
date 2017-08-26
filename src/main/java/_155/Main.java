/**
 * 
 */
package _155;

/**
 * @author fubaokui
 * @date   2017年8月12日 下午3:14:12
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
		minStack.push(2147483646);
		minStack.push(2147483646);
		minStack.push(2147483647);
		minStack.top();
		minStack.pop();
		minStack.getMin();
		minStack.pop();
		minStack.getMin();
		minStack.pop();
		minStack.push(2147483647);
		minStack.top();
		System.out.println(minStack.getMin());
		minStack.push(-2147483648);
		minStack.top();
		minStack.getMin();
		minStack.pop();
		minStack.getMin();
	}

}
