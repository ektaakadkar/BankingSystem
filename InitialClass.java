import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *  InitialClass.java.
 *  The following code implements producer consumer algorithm to provide the customers in bank the correct counter
 *  to take place their transaction. Multi-threading is used for the above purpose. Each counter is allocated one thread.
 *  The customer line is implemented using a queue where customers are added at a random time irrespective of any other processes. The
 *  customers added in the queue are called by the counters one by one. The transaction time at each counter is a random number
 *  to make it a natural scenario.
 *
 *  The following class initiates the threads for each counter. The number of counters is user-dependent. The process of adding the number of
 *  customers is also started.
 *
 *  @author      Ekta Rajio Akadkar
 *  Version:     1
 */

public class InitialClass {

    private Object mainObject = new Object();
    private void initiate(String inputNumberOfBankCounters, addCustomer customerObject) {

        int numberOfBankCounters;
        try {
            numberOfBankCounters = Integer.parseInt(inputNumberOfBankCounters);
            for (int number = 0; number < numberOfBankCounters;number++){
                InitializeBankCounters bankObject = new InitializeBankCounters(number);
                new Customers(bankObject, mainObject, customerObject).start();
            }
        }

        catch (NumberFormatException | InputMismatchException e) {
            System.out.print("Please enter a valid number!");
            Scanner num = new Scanner(System.in);
            inputNumberOfBankCounters = num.next();
            initiate(inputNumberOfBankCounters, customerObject);
        }
    }

    public static void main(String[] args){
        String numberOfBankCounters = args[0];
        addCustomer customerObject = new addCustomer();
        customerObject.start();
        int count = 0;
        InitialClass classObject = new InitialClass();
        while (true){
        classObject.initiate(numberOfBankCounters, customerObject);
//        count++;
//        if (count > 10000){
//            System.out.println(count);
//            count = 0;
//            numberOfBankCounters = "1";
//        }
        }
    }
}
