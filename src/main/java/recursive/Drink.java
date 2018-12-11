package recursive;

/**
 * @author fubaokui
 * @date 2018/09/01
 */
public class Drink {

	private int money;

	private int bottleCap;

	private int bottle;

	public int doDrink(int money, int bottleCap, int bottle) {
		boolean flag = false;
		if (money >= 2) {
			money -= 2;
			flag = true;
		} else if (bottleCap >= 4) {
			bottleCap -= 4;
			flag = true;
		} else if (bottle >= 2) {
			bottle -= 2;
			flag = true;
		}
		if (flag) {
			bottleCap++;
			bottle++;
			return 1 + doDrink(money, bottleCap, bottle);
		} else {
			return 0;
		}
	}

	public void doDrink(int money) {
		this.money = money;
		int count = 0;
		while (buyOrExchange()) {
			bottleCap++;
			bottle++;
			count++;
		}
		System.out.printf("count:%d,bottleCap:%d,bottle:%d", count, bottleCap, bottle);
	}

	private boolean buyOrExchange() {
		if (money >= 2) {
			money -= 2;
			return true;
		} else if (bottleCap >= 4) {
			bottleCap -= 4;
			return true;
		} else if (bottle >= 2) {
			bottle -= 2;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(new Drink().doDrink(10, 0, 0));
		new Drink().doDrink(10);
	}

}
