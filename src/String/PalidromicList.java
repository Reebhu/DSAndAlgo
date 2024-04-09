package String;

public class PalidromicList {

	static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		Node(int data) {
			this.data = data;
		}
	}

	static boolean isPallidrome(Node head) {
		Node slow = head, fast = head;
		Node prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = reverseList(slow.next, slow);
		}
		else {
			slow = reverseList(slow, prev);
		}
		return pallidromicCheck(head, slow);
	}

	private static boolean pallidromicCheck(Node head, Node mid) {
		while (mid != null && head.data == mid.data) {
			head = head.next;
			mid = mid.next;
		}
		return mid == null;
	}

	private static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	private static Node createList(int... arr) {
		Node head = null;
		Node tail = null;
		for (int i : arr) {
			if (head != null) {
				Node temp = new Node(i);
				tail.next = temp;
				tail = temp;
			}
			else {
				head = new Node(i);
				tail = head;
			}
		}
		printList(head);
		return head;
	}

	static Node reverseList(Node head, Node prev) {
		Node current, next;
		current = next = head;
		Node temp = prev;
		prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		temp.next = prev;
		return prev;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 6, 2, 1};

		Node head = createList(arr);
		boolean isPallidrome = isPallidrome(head);
		System.out.println(isPallidrome);
	}
}
