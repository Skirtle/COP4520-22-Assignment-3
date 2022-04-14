import java.util.ArrayList;
import java.util.Random;

class Test {
    public static void main(String[] args) {
        int size = 10;
        Random random = new Random();

        ArrayList<Integer> arrlist = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            arrlist.add(i);
        }

        System.out.println(arrlist.size());
        while (arrlist.size() > 0) {
            int r = random.nextInt(arrlist.size());
            System.out.print(r + ", ");
            arrlist.clear();
        }
    }
}