package introduction;

import java.util.ArrayList;
import java.util.List;

class firstThread extends Thread{
    private String string;

    public firstThread(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(string+"-->" + i);
        }
    }
}

public class firstExample {
    public static void main(String[] args) {
        Thread threadOne = new firstThread("****");
        Thread threadTwo = new firstThread("&&&&");
        List<Thread> threads = new ArrayList<>();
        threads.add(threadOne);
        threads.add(threadTwo);
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
