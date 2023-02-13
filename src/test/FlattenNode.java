package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/28
 * Description:
 */
public class FlattenNode {
	/**
	 * 1 null
	 * 2 null
	 * 3 null
	 *
	 * @param head
	 * @return
	 */
	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		Node child = flatten(head.child);
		Node next = flatten(head.next);
		head.child = null;
		if (child != null) {
			if (next == null) {
				head.next = child;
				child.prev = head;
			} else {
				head.next = child;
				child.prev = head;
				while (child.next != null) {
					child = child.next;
				}
				child.next = next;
				next.prev = child;
			}
		}
		return head;
	}
}
