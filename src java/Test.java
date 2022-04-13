import java.util.Random;

public class Test {
    static final int THREADS = 4;
    static final int PRESENTS = 50000; // 5000000

    public static void main(String[] args) {
        long start, end, durr;
        LinkedList ll = new LinkedList();
        int[] randomArr = randomArray();
        int[] randomArr2 = randomArray();

        start = System.nanoTime();
        for (int i = 0; i < PRESENTS; i++) {
            ll.add(randomArr[i]);
        }
        end = System.nanoTime();
        durr = (end - start) / 1000000;
        System.out.println("Adding " + PRESENTS + " presents took " + durr + " ms");

        start = System.nanoTime();
        for (int i = 0; i < PRESENTS; i++) {
            ll.remove(randomArr2[i]);
        }
        end = System.nanoTime();
        durr = (end - start) / 1000000;
        System.out.println("Removing " + PRESENTS + " presents took " + durr + " ms");
        ll.print();

    }

    static int[] randomArray() {
        int[] arr = new int[PRESENTS];
        Random random = new Random();

        for (int i = 0; i < PRESENTS; i++) {
            arr[i] = i;
        }

        for (int i = PRESENTS - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // System.out.println(Arrays.toString(arr));

        return arr;
    }
}
