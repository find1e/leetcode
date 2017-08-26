/**
 * 
 */
package _518;

import java.util.LinkedList;

import common.StringUtil;

/**
 * @author fubaokui
 * @date 2017年4月15日 下午10:26:04
 */
public class Sulotion {

	int sum = 0;
	LinkedList<String> p = new LinkedList<>();

	public int change(int amount, int[] coins) {
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] == amount) {
				System.out.println(coins[i]);
				sum++;
				break;
			} else {
				if (coins[i] < amount) {
					p.add(coins[i] + " ");
					match(amount - coins[i], coins);
				}
			}
		}
		return sum;
	}

	private void match(int amount, int[] coins) {
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] == amount) {
				System.out.println(StringUtil.printCollection(p, " ") + coins[i]);
				sum++;
				break;
			} else {
				if (coins[i] < amount) {
					p.add(coins[i] + " ");
					match(amount - coins[i], coins);
				}
			}
		}
		if (!p.isEmpty()) {
			p.removeLast();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Sulotion().change(12, new int[] {1,4,9,16}));
	}

}
