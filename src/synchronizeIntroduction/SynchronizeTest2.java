package synchronizeIntroduction;
class StaticVariableThread extends Thread {
    public static int counter = 0;
    @Override
    public void run() {
        System.out.println(this.getName()+" --> the value is: "+counter);
        synchronized (this) {counter++;}
        //Common resource, accessed through several threads, is in the synchronized block.
        //With this tactic, only one thread can use it, and when it's done, another thread gets access.
    }
};
public class SynchronizeTest2 {
    public static void main(String[] args) {
        StaticVariableThread thread1 = new StaticVariableThread();
        thread1.run();
        System.out.println("Value in main thread: "+StaticVariableThread.counter);
        StaticVariableThread thread2 = new StaticVariableThread();
        thread2.run();
        
        System.out.println("Value in main thread: "+StaticVariableThread.counter);
    }
}
