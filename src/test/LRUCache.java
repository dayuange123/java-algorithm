package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/28
 * Description:
 */

public class LRUCache {


	Map<Integer, ListNode> map;
	ListNode head;
	ListNode last;
	private int size;

	public LRUCache(int capacity) {

		size = capacity;
		map = new HashMap<>();
	}

	public int get(int key) {
		ListNode orDefault = map.getOrDefault(key, null);
		if (orDefault != null && head != orDefault) {
			if (orDefault == last) {
				last = orDefault.prev;
				last.next = null;
			} else {
				orDefault.prev.next = orDefault.next;
				orDefault.next.prev = orDefault.prev;
			}
			orDefault.next = head;
			head.prev = orDefault;
			head = orDefault;
		}
		return orDefault == null ? -1 : orDefault.val;
	}

	public void put(int key, int value) {
		ListNode listNode = new ListNode(key, value);
		ListNode originNode = map.get(key);
		map.put(key, listNode);
		if (head == null) {
			head = last = listNode;
		} else {
			listNode.next = head;
			head.prev = listNode;
			head = listNode;
		}
		if (originNode != null) {
			originNode.prev.next = originNode.next;
			if (originNode.next != null) {
				originNode.next.prev = originNode.prev;
			} else {
				last = originNode.prev;
			}
		}
		if (map.size() > size) {
			map.remove(last.key);
			last = last.prev;
			last.next = null;
		}
	}

	public class ListNode {
		int key;
		int val;
		ListNode next;
		ListNode prev;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
