public class ConcurrentLinkedList {
	Node head;
	int size;

	public ConcurrentLinkedList() {
		head = new Node(5);
		size = 1;
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