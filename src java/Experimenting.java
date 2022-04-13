import java.util.Random;

public class Experimenting {
    static final int THREADS = 4;
    static final int PRESENTS = 50000; // 5000000

    public static void main(String[] args) {
        singleThreadExperiment();
        multiThreadExperiment();
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

    public static void singleExperimentRandomAdding() {
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
        System.out.println("Current size of linked list: " + ll.size);

        start = System.nanoTime();
        for (int i = 0; i < PRESENTS; i++) {
            ll.remove(randomArr2[i]);
        }
        end = System.nanoTime();
        durr = (end - start) / 1000000;
        System.out.println("Removing " + PRESENTS + " presents took " + durr + " ms");
        System.out.println("Current size of linked list: " + ll.size);
        System.out.println();

    }

    public static void singleExperimentInOrderAdding() {
        long start, end, durr;
        LinkedList ll = new LinkedList();
        int[] randomArr = randomArray();
        int[] randomArr2 = randomArray();

        // Add presents
        start = System.nanoTime();
        for (int i = 0; i < PRESENTS; i++) {
            ll.addInOrder(randomArr[i]);
        }
        end = System.nanoTime();
        durr = (end - start) / 1000000;
        System.out.println("Adding " + PRESENTS + " presents took " + durr + " ms");
        System.out.println("Current size of linked list: " + ll.size);

        // Remove presents
        start = System.nanoTime();
        for (int i = 0; i < PRESENTS; i++) {
            ll.remove(randomArr2[i]);
        }
        end = System.nanoTime();
        durr = (end - start) / 1000000;
        System.out.println("Removing " + PRESENTS + " presents took " + durr + " ms");
        System.out.println("Current size of linked list: " + ll.size);
        System.out.println();
    }

    public static void singleExperimentRandomAddAndRemove() {
        long start, end, durr;
        LinkedList ll = new LinkedList();
        int[] randomArr = randomArray();

        start = System.nanoTime();
        for (int i = 0; i < PRESENTS; i++) {
            ll.add(randomArr[i]);
            ll.remove(randomArr[i]);
        }
        end = System.nanoTime();
        durr = (end - start) / 1000000;
        System.out.println("Adding and removing " + PRESENTS + " presents took " + durr + " ms");
        System.out.println("Current size of linked list: " + ll.size);
        System.out.println();
    }

    public static void singleExperimentInOrderAddAndRemove() {
        long start, end, durr;
        LinkedList ll = new LinkedList();
        int[] randomArr = randomArray();

        start = System.nanoTime();
        for (int i = 0; i < PRESENTS; i++) {
            ll.addInOrder(randomArr[i]);
            ll.remove(randomArr[i]);
        }
        end = System.nanoTime();
        durr = (end - start) / 1000000;
        System.out.println("Adding and removing " + PRESENTS + " presents took " + durr + " ms");
        System.out.println("Current size of linked list: " + ll.size);
        System.out.println();
    }

    public static void singleThreadExperiment() {
        System.out.println("Random adding: ");
        singleExperimentRandomAdding();
        System.out.println("In order adding: ");
        singleExperimentInOrderAdding();
        System.out.println("Random adding and removing: ");
        singleExperimentRandomAddAndRemove();
        System.out.println("In order adding and removing: ");
        singleExperimentInOrderAddAndRemove();
    }

    public static void multiThreadExperiment() {

    }
}
