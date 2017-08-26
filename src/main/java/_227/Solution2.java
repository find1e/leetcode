/**
 * 
 */
package _227;

import java.util.Stack;

/**
 * Basic Calculator
 * 
 * @author fubaokui
 * @date   2017年8月20日 下午7:35:53
 */
public class Solution2 {
    
    public int doOp(char c,int a,int b){
        if(c == '+'){
            return a+b;
        }else if(c=='-'){
            return a-b;
        }else if (c=='*'){
            return a*b;
        }else{
            return a/b;
        }
        
    }
    
    private int i = 0;
    public int calculate(String s) {
    	if(s == null){
    		return 0;
    	}
    	s = s.trim().replaceAll("\\s+", "");
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        int length = s.length();
        int a = getInt(s);
        char op = getOp(s);
        if(op == 'x'){
        	return a;
        }
        int b = getInt(s);
        
        if(getPriority(op) == 2){
        	numStack.push(doOp(op, a, b));
        }else{
        	numStack.push(a);
        	numStack.push(b);
        	opStack.push(op);
        }
        while(i < length){
        	char currentOp = getOp(s);
        	if(getPriority(currentOp) == 2){
        		a = numStack.pop();
             	b =  getInt(s);
             	numStack.push(doOp(currentOp, a, b));
             }else{
            	 if(opStack.isEmpty()){
            		 opStack.push(currentOp);
            		 numStack.push(getInt(s));
            	 }else{
        			 b = numStack.pop();
        			 a = numStack.pop();
        			 char lastOp = opStack.pop();
        			 numStack.push(doOp(lastOp, a, b));
        			 opStack.push(currentOp);
        			 numStack.push(getInt(s));
            	 }
             }
        }
        if(numStack.size() == 1){
        	return numStack.pop();
        }else{
        	b = numStack.pop();
            op = opStack.pop();
            a = numStack.pop();
            return doOp(op, a, b);
        }
    }
    private char getOp(String s) {
    	if(i>=s.length()){
			return 'x';
		}
    	return s.charAt(i++);
	}

	private int getInt(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		while(i<s.length()){
			char c = s.charAt(i);
			if(isNumber(c)){
				stringBuilder.append(c);
				i++;
			}else{
				//运算符
				break;
			}
		}
		return Integer.parseInt(stringBuilder.toString());
	}

	public boolean checkPriority(char lastOp,char currentOp){
        int lastOpPriority = getPriority(lastOp);
        int currentOpPriority = getPriority(currentOp);
        return lastOpPriority >= currentOpPriority;
    }
    
    public int getPriority(char c){
        if(c == '+' || c == '-'){
            return 1;
        }else{
            return 2;
        }
    }
    
    public boolean isNumber(char c){
        return c >= 48 && c <= 57;
    }
   
    public static void main(String[] args) {
    	System.out.println(new Solution2().calculate(" 3 + 5 / 2"));
    	System.out.println(new Solution2().calculate(" 3    / 2 "));
    	System.out.println(new Solution2().calculate("3 + 2 * 2 "));
    	System.out.println(new Solution2().calculate(" 42 "));
		System.out.println(new Solution2().calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
	}
}