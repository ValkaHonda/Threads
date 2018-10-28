package customThreadExam;
class RenamerThread extends Thread
{private String currentHumanName;
 public static String commonName = "Annie";

    public RenamerThread(String currentHumanName)
    {this.currentHumanName = currentHumanName;}

    @Override
    public void run()
    {
     while (true)
     {if(commonName.endsWith(String.valueOf(this.currentHumanName.charAt(0)))){
         System.out.println(this.getName()+" is sleeping for two seconds.");
         try {Thread.sleep(2*1000);} catch (InterruptedException e) {}
     }
     else {synchronized (this) {commonName = commonName + "a";}
     }
     if(commonName.endsWith("a")) {
         synchronized (this) {commonName = commonName + "b";}
     }
        System.out.println(this.getName()+" "+commonName);

    if(commonName.length() > 20)
    {synchronized (this) {commonName = "Elly";}}}}}
public class CustomOSExam
{public static void main(String[] args)
{RenamerThread firstThread = new RenamerThread("ivan");
 RenamerThread secondThread = new RenamerThread("boris");
 RenamerThread thirdThread = new RenamerThread("petkan");
 RenamerThread fourthThread = new RenamerThread("ivo");
 RenamerThread fifthThread = new RenamerThread("amy");
 firstThread.start();
 secondThread.start();
    thirdThread.start();
    fourthThread.start();
    fifthThread.start();
try {fourthThread.wait();} catch (InterruptedException e) {} //Stops thread until notified.
try {Thread.sleep(20*1000);} catch (InterruptedException e) {}
    fourthThread.notify();
}}
