package taskOS;

class CommonPool {
    private double poolVolume;
    public CommonPool(double initialPoolVolume) {this.poolVolume = initialPoolVolume;}
    public void changeVolume(double pipeCapacity)
    {synchronized (this) {poolVolume+=pipeCapacity;}}
    public double getCurrentVolume() {synchronized(this) {return poolVolume;}}}
class PipeThread extends Thread {
    private CommonPool pool;
    private double cubicMeters;
    public PipeThread(CommonPool pool, double cubicMeters)
    {this.pool = pool; this.cubicMeters = cubicMeters;}
    @Override
    public void run() {
        while(true)
        {if (this.pool.getCurrentVolume() + cubicMeters < 1000 && this.pool.getCurrentVolume() + cubicMeters >= 0)
        {pool.changeVolume(cubicMeters);
        try {Thread.sleep(3600000);} catch (InterruptedException e) {}}
        else {try {Thread.sleep(60000);} catch (InterruptedException e) {}}}}}
public class PoolTester {
    public static void main(String[] args) {
        CommonPool newPool = new CommonPool(600);
        PipeThread firstThread = new PipeThread(newPool, 2);
        PipeThread secondThread = new PipeThread(newPool, 1);
        PipeThread thirdThread = new PipeThread(newPool, -0.5);
        firstThread.start(); secondThread.start(); thirdThread.start();
        try {firstThread.join();} catch (InterruptedException e) {}
        try {secondThread.join();} catch (InterruptedException e) {}
        try {thirdThread.join();} catch (InterruptedException e) {}
        System.out.println("Volume "+newPool.getCurrentVolume());
    }}
