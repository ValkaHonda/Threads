package introduction;
class PrintingThread extends Thread {
    private String threadSymbol;
    public PrintingThread (String threadSymbol) {
        this.threadSymbol = threadSymbol;
    }
    @Override
    public void run() {
        for (int i =0; i < 500; i++) {
            System.out.println(threadSymbol+"--->"+i);
            System.out.println(this.getName());
        }
    }

}

public class SecondExample {
    public static void main(String[] args) {
        Thread printingThread_1 = new PrintingThread("Elly");
        printingThread_1.setName("Elly");
        Thread printingThread_2 = new PrintingThread("Rossy");
        Thread printingThread_3 = new PrintingThread(":)");

        printingThread_1.start();
        printingThread_2.start();
        printingThread_3.start();
    }
}
