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

	public void addInOrder(int val) {
		if (head == null) {
			head = new Node(val);
			size++;
			return;
		}

		// Find biggest node less than new value
		Node curr = head;
		Node newNode = new Node(val);
		if (curr.data > val) {
			newNode.next = curr;
			head = newNode;
			size++;
			return;
		}

		while (true) {
			if (curr.next == null) {
				curr.next = new Node(val);
				size++;
				return;
			} else if (curr.next.data > val) {
				newNode.next = curr.next;
				curr.next = newNode;
				size++;
				return;
			} else {
				curr = curr.next;
			}
		}
	}

}