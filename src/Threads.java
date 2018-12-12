public class Threads {

    public void two() throws Exception{
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++){
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        first.start();
        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++){
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + (i+h) / 5) * Math.cos(0.2f + (i+h) / 5) * Math.cos(0.4f + (i+h) / 2));
                }
            }
        });

        second.start();
        first.join();
        second.join();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
        System.out.println("Threads time");
        /*for (int j = 0; j<size; j++){
            System.out.println(arr[j]);
        }*/
    }
}
