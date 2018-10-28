package taskOS;
class TaskThreadOrWorkingThreadWhatever extends Thread
{public static int commonResource = 0;
    private int k;
    public TaskThreadOrWorkingThreadWhatever(int k)
    {this.k = k;}
    @Override
    public void run() {
        while (true) {
        System.out.println("Hello, my name is " + this.getName());
        if (commonResource % k != 0)
        {synchronized (this) {
                int tempCR = commonResource;
                commonResource++;
                System.out.println(this.getName()+" : common resource went from "+tempCR+" to "+commonResource);}
            try {
                Thread.sleep(k * 1000);
                } catch (InterruptedException e) {}
        }
            else {
            synchronized (this) {
                int tempCR = commonResource;
                commonResource += k + 1;
                System.out.println(this.getName()+" : common resource went from "+tempCR+" to "+commonResource);
            }
            try {sleep(1000);} catch (InterruptedException e) {}
        }
        if(commonResource%(k*k) == 0) {
            synchronized (this) {
                int tempCR = commonResource;
                commonResource += 2*k + 1;
                System.out.println(this.getName()+" : common resource went from "+tempCR+" to "+commonResource);
            }}}}}
public class ArithmeticThreads {
    public static void main(String[] arguments) {
        System.out.println("This is a demonstration of an OS task. :)");
        Thread firstThread = new TaskThreadOrWorkingThreadWhatever(3);
        Thread secondThread = new TaskThreadOrWorkingThreadWhatever(5);
        Thread thirdThread = new TaskThreadOrWorkingThreadWhatever(7);
        Thread fourthThread = new TaskThreadOrWorkingThreadWhatever(17);
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
    }}
