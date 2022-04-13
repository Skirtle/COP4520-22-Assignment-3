public class Test {
    static final int THREADS = 4;
    static final int PRESENTS = 10; // 5000000

    public static void main(String[] args) {
        ConcurrentLinkedList ll = new ConcurrentLinkedList();

        for (int i = 0; i < PRESENTS; i++) {
            ll.add(i);
        }

        ll.print();
    }
}
