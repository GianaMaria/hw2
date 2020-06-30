package lesson5;

public class RunMillisTwo implements Runnable{
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float[] arr;

    public RunMillisTwo(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f +(i + HALF)  / 5) * Math.cos(0.4f + (i + HALF)  / 2));

        }
    }
}
