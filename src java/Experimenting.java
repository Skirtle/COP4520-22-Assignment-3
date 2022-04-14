import java.util.Random;

public class Experimenting {
    static final int THREADS = 4;
    static final int PRESENTS = 50000; // 5000000

    public static void main(String[] args) throws InterruptedException {

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

class Servant implements Runnable {
    int id, max;
    static ConcLinkedList cll = new ConcLinkedList(); // All servants use the same list

    Servant(int id, int max) {
        this.id = id;
        this.max = max;
    }

    public void run() {

    }
}