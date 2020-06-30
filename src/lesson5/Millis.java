package lesson5;

import java.util.Arrays;

public class Millis {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public void firstArray() {
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.printf("Время выполнения первого метода: %d\n", System.currentTimeMillis() - a);
        System.out.println("arr[5 000 000] : " + arr[HALF]);
        System.out.println("arr[1] : " + arr[1]);

    }

    public void secondArray() {
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread t1 = new Thread(new RunMillis(a1));
        Thread t2 = new Thread(new RunMillisTwo(a2));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.printf("Время выполнения второго метода: %d\n", System.currentTimeMillis() - a);
        System.out.println("arr[5 000 000] : " + arr[HALF]);
        System.out.println("arr[1] : " + arr[1]);

    }
}
