package introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FactorialCalculator extends Thread {
    private long base, factorial;
public FactorialCalculator(String threadName, long baseNumber) {
    this.setName(threadName);
    this.base = baseNumber;
    this.factorial = 1;
}
    @Override
    public void run() {
        for (int i =1; i <= base; i++) {
            factorial*=i;
        }
        System.out.println(this.getName()+" Factorial result == "+this.factorial);
    }
}
class TextPrinter extends Thread {
    public TextPrinter(String threadName){
        this.setName(threadName);
    }

    @Override
    public void run() {
        for (int i = 0; i < 80; i++) {
        System.out.print("--->");
        System.out.print("   ");
    }
    }
}
public class ThirdExample {
    public static void main(String[] args) {
        System.out.println("Third example.");
        Thread firstThread = new FactorialCalculator("FactorialThread", 7);
        Thread secondThread = new FactorialCalculator("FactorialThreadAgain", 18);
        Thread thirdThread = new TextPrinter("TextPrintingThread");
        secondThread.setPriority(Thread.MIN_PRIORITY);
        List<Thread> threads = new ArrayList<>(Arrays.asList(firstThread, secondThread, thirdThread));
        for (Thread currentThread : threads) {
            currentThread.start();
        }


    }}
