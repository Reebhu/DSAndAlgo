import java.time.ZoneId;

public class ReverseLinkList {
	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Node head = null;
		Node tail = head;
		for (int i : arr) {
			if (head == null) {
				head = new Node(i, tail);
				tail = head;
			}
			else {
				Node temp = new Node(i, null);
				tail.next = temp;
				tail = temp;
			}
		}
		Node tempHead = head;
		while (tempHead != null) {
			System.out.println(tempHead.data);
			tempHead = tempHead.next;
		}
		reverseLinkedList(head);

		System.out.println(ZoneId.of("America/Cayman"));
	}

	public static void reverseLinkedList(Node head) {
		Node prev = null;
		Node current = head;
		Node next = head.next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}
