package taskOS;
class Pool {
    private int poolVolume;

    public Pool(int poolVolume) {
        this.poolVolume = poolVolume;
    }

    public int getPoolVolume() {
        synchronized (this) {
            return poolVolume;
        }}

    public void changeVolume(int volume) {
        synchronized (this) {
            this.poolVolume += volume;
        }}}

class PoolThread extends Thread {
private Pool pool;
private int lits;
private int sleepTime;
public PoolThread(Pool pool, int lits, int sleepTime) {
    this.pool = pool;
    this.lits = lits;
    this.sleepTime = sleepTime;
}
    @Override
    public void run() {
        while (true) {
         if (this.pool.getPoolVolume() + this.lits > 5000 || this.pool.getPoolVolume() + this.lits <= 0) {
             try {Thread.sleep(10*1000);} catch (InterruptedException e) {}
         }
         else {pool.changeVolume(lits);
         try {Thread.sleep(this.sleepTime);} catch (InterruptedException e) {}
         }}}}

public class PoolThreads1 {
    public static void main(String[] args) {
        Pool pool = new Pool(0);
        PoolThread firstThread = new PoolThread(pool, 10, 300);
        PoolThread secondThread = new PoolThread(pool, -50, 70);
        PoolThread thirdThread = new PoolThread(pool, -300, 1000);
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        try {firstThread.join();} catch (InterruptedException e) {}
        try {secondThread.join();} catch (InterruptedException e) {}
        try {thirdThread.join();} catch (InterruptedException e) {}
    }}
