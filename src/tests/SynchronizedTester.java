package tests;


class Counter {
    private int count;
    public Counter(int count){
        this.count = count;
    }
    public void incrementCounter(){
synchronized (this){
            count++;}

    }
    public int getCounter(){
          synchronized (this) {return count;}

    }
}

class CounterThread extends Thread{
    private int limit;
    private Counter counter;

    public CounterThread(int limit, Counter counter) {
        this.limit = limit;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++){
            counter.incrementCounter();
        }
    }
}

public class SynchronizedTester {
    public static void main(String[] args) {
        System.out.println("Test--->");
        Counter counter = new Counter(0);
        CounterThread counterThread1 = new CounterThread(2000,counter);
        CounterThread counterThread2 = new CounterThread(5000,counter);

        counterThread1.start();
        counterThread2.start();

        try {
            counterThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            counterThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getCounter());

    }
}
