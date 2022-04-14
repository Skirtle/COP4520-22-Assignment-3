import java.util.concurrent.locks.*;

public class ConcLinkedList {
    private Node head;
    public int size;

    public ConcLinkedList() {
        head = new Node(Integer.MIN_VALUE);
        head.next = new Node(Integer.MAX_VALUE);
    }

    private boolean validate(Node pred, Node curr) {
        return !pred.marked && !curr.marked && pred.next == curr;
    }

    public boolean add(int item) {
        int key = item;
        while (true) {
            Node pred = head;
            Node curr = head.next;
            while (curr.key < key) {
                pred = curr;
                curr = curr.next;
            }
            pred.lock();
            try {
                curr.lock();
                try {
                    if (validate(pred, curr)) {
                        if (curr.key == key) {
                            return false;
                        } else {
                            Node NewNode = new Node(item);
                            NewNode.next = curr;
                            pred.next = NewNode;
                            size++;
                            return true;
                        }
                    }
                } finally {
                    curr.unlock();
                }
            } finally {
                pred.unlock();
            }
        }
    }

    public boolean remove(int item) {
        int key = item;
        while (true) {
            Node pred = head;
            Node curr = head.next;
            while (curr.key < key) {
                pred = curr;
                curr = curr.next;
            }
            pred.lock();
            try {
                curr.lock();
                try {
                    if (validate(pred, curr)) {
                        if (curr.key != key) {
                            return false;
                        } else {
                            curr.marked = true;
                            pred.next = curr.next;
                            size--;
                            return true;
                        }
                    }
                } finally {
                    curr.unlock();
                }
            } finally {
                pred.unlock();
            }
        }
    }

    public boolean contains(int item) {
        int key = item;
        Node curr = head;
        while (curr.key < key)
            curr = curr.next;
        return curr.key == key && !curr.marked;
    }
}

class Node {
    int item;
    int key;
    Node next;
    boolean marked;
    Lock lock = new ReentrantLock();

    Node(int myItem) {
        item = myItem;
        key = myItem;
        next = null;
        marked = false;
    }

    void lock() {
        lock.lock();
    }

    void unlock() {
        lock.unlock();
    }

}