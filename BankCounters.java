
/*
 *  BankCounters.java.
 *  The final step of the transaction takes place over here. The status of the bank counter is changed after the
 *  transaction is over and a new customer is called.
 *
 *  @author      Ekta Rajio Akadkar
 *  Version:     1
 */

class BankCounters extends Thread{

    private final Object mainObject;
    private int customerNumber;
    private InitializeBankCounters bankObject;
    private addCustomer waitingQueue;

    BankCounters(Object obj, int counter_increment, InitializeBankCounters bankObject, addCustomer waitingQueue) {
        mainObject = obj;
        this.customerNumber =  counter_increment;
        this.bankObject = bankObject;
        this.waitingQueue = waitingQueue;
    }

    void transactionEnd() {
        synchronized (mainObject) {
            System.out.println("3. Banking transaction over at " + bankObject.bankCounter + " for customer " + customerNumber);
            bankObject.relax();
            new Customers(bankObject, mainObject, waitingQueue).start();
        }
    }

}
