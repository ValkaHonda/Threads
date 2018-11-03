package taskOS;

class Bank {
    private double totalMoney;
    public Bank(double totalMoney) {this.totalMoney = totalMoney;}
    public void changeMoney(double exchangeSum)
    {synchronized(this) {totalMoney+=exchangeSum;}}
    public double getTotalMoney() {synchronized(this) {return totalMoney;}}}

    class ClientThread extends Thread {
    private Bank bank;
    public double bankAccount;
    public double clientAmount;
    public ClientThread(Bank bank, double bankAccount, double clientAmount)
    {this.bank = bank; this.bankAccount = bankAccount; this.clientAmount = clientAmount;}
    @Override
        public void run() {
        if (this.bank.getTotalMoney() + clientAmount >= 500000 && this.bank.getTotalMoney() + clientAmount <= 10000000
                && bankAccount - clientAmount >= 0)
        {bank.changeMoney(clientAmount); bankAccount -= clientAmount;
        }
        else {try {Thread.sleep(2000);} catch (InterruptedException e) {}}}}

public class BankMain {
    public static void main(String[] args) {
        Bank newBank = new Bank(1000000);
        ClientThread firstClient = new ClientThread(newBank, 10000, 1000);
        ClientThread secondClient = new ClientThread(newBank, 8000, -500);
        ClientThread thirdClient = new ClientThread(newBank, 7000, -200);
        ClientThread fourthClient = new ClientThread(newBank, 6000, -100);
        ClientThread fifthClient = new ClientThread(newBank, 5000, 10);
        firstClient.start(); secondClient.start(); thirdClient.start();
        fourthClient.start(); fifthClient.start();
        try {firstClient.join();} catch (InterruptedException e) {}
        try {secondClient.join();} catch (InterruptedException e) {}
        try {thirdClient.join();} catch (InterruptedException e) {}
        try {fourthClient.join();} catch (InterruptedException e) {}
        try {fifthClient.join();} catch (InterruptedException e) {}
        System.out.println("Money$: "+newBank.getTotalMoney());
        System.out.println("Client Amount: "+fifthClient.bankAccount);
    }
}
