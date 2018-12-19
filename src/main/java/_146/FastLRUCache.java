package _146;

import java.util.HashMap;

/**
 * @author fubaokui
 * @date 2018-12-11 03:12:20
 */
class FastLRUCache {
	Node head;
	Node tail;
	int capacity;
	int length = 0;
	HashMap<Integer, Node> map = new HashMap<>();

	public FastLRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			removeNode(node);
			setNewHead(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			removeNode(node);
			setNewHead(node);
		} else {
			Node node = new Node(key, value);
			if (length < capacity) {
				setNewHead(node);
				map.put(key, node);
				length++;
			} else {
				map.remove(tail.key);
				tail = tail.prev;
				if (tail != null) {
					tail.next = null;
				}
				setNewHead(node);
				map.put(key, node);
			}
		}

	}

	public void setNewHead(Node node) {
		if (node == null) {
			return;
		}

		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		if (tail == null) {
			tail = node;
		}
	}

	public void removeNode(Node node) {
		if (node == null) {
			return;
		}

		Node cur = node;
		Node pre = cur.prev;
		Node next = cur.next;

		if (pre != null) {
			pre.next = next;
		} else {
			head = next;
		}

		if (next != null) {
			next.prev = pre;
		} else {
			tail = pre;
		}
	}

	class Node {
		Node prev;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	public static void main(String[] args) {
		FastLRUCache cache = new FastLRUCache(2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(1, 3);
		System.out.println(cache.get(2)); // returns 2
		System.out.println(cache.get(1)); // returns 3
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2));// returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3));// returns 3
		System.out.println(cache.get(4));// returns 4
	}
}
