import java.util.logging.Level;
import java.util.logging.Logger;
class Account {
    private int account = 0;
    private boolean readable = true;
    synchronized void withdraw(int account) {
        if (this.account < account) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.account -= account;
        System.out.println("Withdraw: " + account);
        System.out.println("Total: " + this.account);
        notify();
    }
    synchronized void deposit(int account) {
        this.account += account;
        readable = true;
        System.out.println("Deposit complete");
        System.out.println("Total: " + this.account);
        notify();
    }
}
public class Customer extends Account {
    public static void main(String[] args) {
        Account account = new Account();
        new Thread() {
            public void run() {
                account.withdraw(100);
            }
        }.start();
        new Thread() {
            public void run() {
                account.deposit(100);
            }
        }.start();
    }
}
