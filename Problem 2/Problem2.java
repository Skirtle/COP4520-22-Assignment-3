import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Problem2 {
    static final int THREADS = 8;
    static final int[] TEMP_RANGE = { -100, 70 };

    public static void main(String[] args) throws InterruptedException {
        int hours = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of hours to report: ");
        hours = scanner.nextInt();
        scanner.close();

        for (int hour = 0; hour < hours; hour++) {
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

            // System.out.println(Arrays.toString(Sensor.temps));
            int[] sorted = new int[480];
            for (int i = 0; i < 480; i++) {
                sorted[i] = Sensor.temps[i];
            }
            ArrayList<Integer> fixed = sortUnique(sorted);

            // Report
            System.out.println("Hour " + (hour + 1));
            System.out.print("\t5 lowest temperatures: " + fixed.get(0));
            for (int i = 1; i < 5; i++) {
                System.out.print(", " + fixed.get(i));
            }
            System.out.println();
            System.out.print("\t5 highest temperatures: " + fixed.get(fixed.size() - 1));
            for (int i = fixed.size() - 2; i > fixed.size() - 6; i--) {
                System.out.print(", " + fixed.get(i));
            }
            System.out.println();
        }

    }

    public static ArrayList<Integer> sortUnique(int[] arr) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        Arrays.sort(arr);
        for (int i = 0; i < 480; i++) {
            if (newList.contains(arr[i]))
                continue;
            newList.add(arr[i]);
        }

        return newList;

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
