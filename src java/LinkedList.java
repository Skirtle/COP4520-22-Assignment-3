public class LinkedList {
	Node head = null;
	int size = 0;

	public LinkedList() {

	}

	public void add(int val) {
		if (head == null) {
			head = new Node(val);
			size++;
			return;
		}

		Node temp = new Node(val);
		Node curr = head;
		if (curr != null) {
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = temp;
		}
		size++;
	}

	public void remove(int val) {
		if (head == null)
			return;
		if (head.data == val) {
			head = head.next;
			size--;
			return;
		}
		Node curr = head;

		while (curr.next != null) {
			if (curr.next.data == val) {
				if (curr.next.next != null) {
					Node next = curr.next.next;
					curr.next = next;
				} else {
					curr.next = null;
				}
				size--;
				break;
			}
			curr = curr.next;
		}

	}

	public void print() {
		Node curr = head;

		while (curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println();
	}

	public void randomize(int[] arr, int len) {
		head = null;
		for (int i = 0; i < len; i++) {
			add(arr[i]);
		}
	}
}

class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

}