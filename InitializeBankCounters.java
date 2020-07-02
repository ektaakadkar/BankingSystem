/*
 *  InitializeBankCounters.java.
 *  The bank counters are initialized. Each thread initializes one object of the bank.
 *
 *  @author      Ekta Rajio Akadkar
 *  Version:     1
 */

class InitializeBankCounters {

    int bankCounter;
    int busyStatus;

    /*
     * Here, busyStatus if assigned to zero means that the counter does not have any customer to attend, otherwise if assigned to one
     * means that the customer is present at the counter.
     */

    InitializeBankCounters(int bankCounter){
        this.bankCounter = bankCounter;
        this.busyStatus = 0;
    }

    void busyStatus(){
        this.busyStatus = 1;
    }

    void relax(){
        this.busyStatus = 0;
    }

}
