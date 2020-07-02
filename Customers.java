
/*
 *  Customers.java.
 *  The first step of the transaction is initiated here if the customer queue is not empty and the counter has no customer to
 *  attend currently.
 *
 *  @author      Ekta Rajio Akadkar
 *  Version:     1
 */
public class Customers extends Thread {
    private final Object mainObject;
    private InitializeBankCounters bankObject;
    private addCustomer customerObject;

    Customers(InitializeBankCounters bankObject, Object mainObject, addCustomer customerObject){
        this.bankObject = bankObject;
        this.mainObject = mainObject;
        this.customerObject = customerObject;
    }

    /*
     * Here, after adding the customer to the respective counter the status of the bank counter is changed. The entire flow of
     *  the transaction is decided here.
     */

    public void run() {
        synchronized (mainObject) {
            if (bankObject.busyStatus == 0 && !customerObject.waitingQueue.isEmpty()) {
                int customerNumber = customerObject.waitingQueue.remove();
                System.out.println("Consumer added: " + customerNumber + " to " + this.bankObject.bankCounter);
                this.bankObject.busyStatus();
                try {
                    new Transaction(mainObject, customerNumber, bankObject).transactionStart();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    mainObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new BankCounters(mainObject, customerNumber, bankObject, customerObject).transactionEnd();
            }
        }
    }
}
