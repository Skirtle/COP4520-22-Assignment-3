import java.util.concurrent.locks.*;

public class ConcLinkedList {
    private NewNode head;

    public ConcLinkedList() {
        head = new NewNode(Integer.MIN_VALUE);
        head.next = new NewNode(Integer.MAX_VALUE);
    }

    private boolean validate(NewNode pred, NewNode curr) {
        return !pred.marked && !curr.marked && pred.next == curr;
    }

    public boolean add(int item) {
        int key = item;
        while (true) {
            NewNode pred = head;
            NewNode curr = head.next;
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
                            NewNode NewNode = new NewNode(item);
                            NewNode.next = curr;
                            pred.next = NewNode;
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
            NewNode pred = head;
            NewNode curr = head.next;
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
        NewNode curr = head;
        while (curr.key < key)
            curr = curr.next;
        return curr.key == key && !curr.marked;
    }
}

class NewNode {
    int item;
    int key;
    NewNode next;
    boolean marked;
    Lock lock = new ReentrantLock();

    NewNode(int myItem) {
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