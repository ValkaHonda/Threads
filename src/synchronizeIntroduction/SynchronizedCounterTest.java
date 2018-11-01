package synchronizeIntroduction;

class Counter {
    private int count = 0;
    public int getCount()
    {synchronized (this) {return count;}}
    public void incrementCount()
    {synchronized (this) {count++;}}

}
class CounterThread extends Thread {
    private Counter counter;
    private int limit;

    public CounterThread(Counter counter, int limit) {
        this.counter = counter;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            counter.incrementCount();
        }}}

public class SynchronizedCounterTest {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterThread firstThread = new CounterThread(counter, 500000);
        CounterThread secondThread = new CounterThread(counter, 600000);
        firstThread.start();
        secondThread.start();

        try {firstThread.join();} catch (InterruptedException e) {}
        try {secondThread.join();} catch (InterruptedException e) {}
        System.out.println("Counter == "+counter.getCount());
    }}
