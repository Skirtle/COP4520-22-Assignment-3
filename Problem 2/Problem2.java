import java.util.Arrays;
import java.util.Random;

public class Problem2 {
    static final int THREADS = 8;
    static final int[] TEMP_RANGE = { -100, 70 };

    public static void main(String[] args) throws InterruptedException {
        Sensor[] sensors = new Sensor[THREADS];
        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            sensors[i] = new Sensor(i);
            threads[i] = new Thread(sensors[i]);
        }

        for (int i = 0; i < THREADS; i++) {
            threads[i].start();
        }

        for (int i = 0; i < THREADS; i++) {
            threads[i].join();
        }

        System.out.println(Arrays.toString(Sensor.temps));

    }
}

class Sensor implements Runnable {
    static int[] temps = new int[480];
    Random random;
    int sensorID;

    Sensor(int id) {
        random = new Random();
        sensorID = id;
    }

    public void run() {
        for (int i = 0; i < 60; i++) {
            temps[i + 60 * sensorID] = random.nextInt(171) - 100;
        }
    }

}
