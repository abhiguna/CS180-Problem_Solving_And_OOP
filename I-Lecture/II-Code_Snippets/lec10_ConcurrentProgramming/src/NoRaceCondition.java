public class NoRaceCondition implements Runnable {
    private static int counter = 0;
    private static Object gateKeeper = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new NoRaceCondition());
        Thread t2 = new Thread(new NoRaceCondition());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.printf("counter = %d\n", counter);
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (gateKeeper) { counter++; }
        }
    }
}
