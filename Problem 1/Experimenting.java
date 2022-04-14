import java.util.ArrayList;
import java.util.Random;

public class Experimenting {
    static final int THREADS = 4;
    static final int PRESENTS = 50000; // 5000000

    public static void main(String[] args) throws InterruptedException {
        Servant[] servants = new Servant[THREADS];
        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            servants[i] = new Servant(i, PRESENTS);
            threads[i] = new Thread(servants[i]);
        }

        for (int i = 0; i < THREADS; i++) {
            threads[i].start();
        }

        for (int i = 0; i < THREADS; i++) {
            threads[i].join();
        }
    }

    public static int[] randomArray(int max) {
        int[] arr = new int[max];
        Random random = new Random();

        for (int i = 0; i < max; i++) {
            arr[i] = i;
        }

        for (int i = max - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }
}

class Servant implements Runnable {
    int id;
    static int max;
    static ConcLinkedList cll = new ConcLinkedList(); // All servants use the same list
    static ArrayList<Integer> bag;

    Servant(int id, int maxNum) {
        this.id = id;
        max = maxNum;
        generateBag();
    }

    public void run() {
        System.out.println("Thread " + id + " started");
        Random random = new Random();
        while (bag.size() > 0) {
            int rand = bag.get(random.nextInt(bag.size()));
            bag.remove(rand);
            cll.add(rand);
            cll.remove(rand);
        }
    }

    private void generateBag() {
        if (bag == null) {
            bag = new ArrayList<Integer>();
            int[] arr = Experimenting.randomArray(max);
            for (int i = 0; i < max; i++) {
                bag.add(arr[i]);
            }
        }
    }
}