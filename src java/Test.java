public class Test {
    static final int THREADS = 4;
    static final int PRESENTS = 500000;

    public static void main(String[] args) {
        ConcurrentLinkedList ll = new ConcurrentLinkedList();
        ll.head.data = 69;
        System.out.println(ll.head.data);
    }
}
