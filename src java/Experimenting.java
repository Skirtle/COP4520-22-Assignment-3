import java.util.Random;

public class Experimenting {
    static final int THREADS = 4;
    static final int PRESENTS = 50000; // 5000000

    public static void main(String[] args) {
        LockFreeList lll = new LockFreeList();
        int successfulAdds = 0;
        int successfulRemoves = 0;

        for (int i = 0; i < PRESENTS; i++) {
            lll.add(i);
        }

        for (int i = 0; i < PRESENTS; i++) {
            if (lll.contains(i)) {
                successfulAdds++;
            }
        }

        for (int i = 0; i < PRESENTS; i++) {
            lll.remove(i);
        }

        for (int i = 0; i < PRESENTS; i++) {
            if (!lll.contains(i)) {
                successfulRemoves++;
            }
        }

        System.out.println(successfulAdds + " " + successfulRemoves);
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
