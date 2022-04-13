public class SequentialLinkedList {
	Node head = null;
	int size = 0;

	public SequentialLinkedList() {

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

	public void print() {
		Node curr = head;

		while (curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println();
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