import java.util.Random;

/*
 *  Transaction.java.
 *  The second process of the transaction takes place over here. The transaction time is decided using a random number.
 *
 *  @author      Ekta Rajio Akadkar
 *  Version:     1
 */

class Transaction extends Thread {
    private final Object mainObject;
     private int customerNumber;
    private InitializeBankCounters bankObject;

    Transaction(Object mainObject, int counter_increment, InitializeBankCounters bankCounterobject){
        this.mainObject = mainObject;
        this.customerNumber = counter_increment;
        this.bankObject = bankCounterobject;
    }

    void transactionStart() throws InterruptedException {
        synchronized (mainObject) {
            Random ob = new Random();
            int r = ob.nextInt(10);
            System.out.println("2. Transaction taking place for customer "+ customerNumber + " at counter "+bankObject.bankCounter);
            sleep(r);
            mainObject.notifyAll();
        }
    }
}
