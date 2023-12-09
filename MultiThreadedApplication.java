class NumberPrinter extends Thread {
    private int start;

    public NumberPrinter(int start) {
        this.start = start;
    }

    @Override
    public void run() {
        for (int i = start; i <= start + 4; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);

            try {
                // Simulate some work
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreadedApplication {
    public static void main(String[] args) {
        // Create three threads
        NumberPrinter thread1 = new NumberPrinter(1);
        NumberPrinter thread2 = new NumberPrinter(6);
        NumberPrinter thread3 = new NumberPrinter(11);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished.");
    }
}