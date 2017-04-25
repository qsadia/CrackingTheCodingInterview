package Moderate;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private Node head;
	private Node tail;
	private int capacity;
	private int size;
	private Map<Integer, Node> map;

	class Node {
		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public LRUCache(int capacity) {
		head = null;
		tail = null;
		this.capacity = capacity;
		this.size = 0;
		map = new HashMap<Integer, Node>();
	}

	public void insert(int key, int value) {
		if (size == capacity) {
			remove(tail);
		}

		Node node = new Node(key, value);
		map.put(key, node);
		setHead(node);
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node != head) {
			remove(node);
			setHead(node);
		}

		return node.value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = head;

		while (node != null) {
			sb.append("(" + node.key + "," + node.value + ") <-> ");
			node = node.next;
		}
		sb.append("null");

		return sb.toString();
	}

	private void setHead(Node node) {
		node.next = head;

		if (head != null) {
			head.prev = node;
		}

		head = node;

		if (tail == null) {
			tail = head;
		}

		size++;
	}

	private void remove(Node node) {
		if (node == head  && node == tail) {
			head = null;
			tail = null;
		}
		else if (node == head) {
			head = head.next;
		}
		else if (node == tail) {
			tail = tail.prev;
			tail.next = null;
		}
		else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		size--;
	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(5);
		lru.insert(5, 5);
		lru.insert(4, 4);
		lru.insert(3, 3);
		lru.insert(2, 2);
		lru.insert(1, 1);
		System.out.println(lru.toString());
		lru.get(2);
		lru.get(5);
		System.out.println(lru.toString());
		lru.insert(6, 6);
		System.out.println(lru.toString());
		lru.get(2);
		System.out.println(lru.toString());
	}

}
