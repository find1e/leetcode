package _146;

import java.util.HashMap;

/**
 * @author fubaokui
 * @date 2018-12-11 03:12:20
 */
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


class LRUCache {
	Node head;
	Node tail;
	int capacity;
	int length = 0;
	HashMap<Integer, Node> map = new HashMap<>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node != null) {
			removeNode(node);
			setNewHead(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node != null) {
			node.value = value;
			removeNode(node);
			setNewHead(node);
		} else {
			Node newNode = new Node(key, value);
			if (length < capacity) {
				setNewHead(newNode);
				map.put(key, newNode);
				length++;
			} else {
				map.remove(tail.key);
				tail = tail.prev;
				if (tail != null) {
					tail.next = null;
				}
				setNewHead(newNode);
				map.put(key, newNode);
			}
		}

	}

	public void setNewHead(Node node) {
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
}
