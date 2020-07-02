import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
 *  addCustomer.java.
 *  Here, the queue of the customers is initialized. Customers are added to the queue at a random time to present it as a
 *  practical scenario.
 *
 *  @author      Ekta Rajio Akadkar
 *  Version:     1
 */

public class addCustomer extends Thread {

    Queue<Integer> waitingQueue = new LinkedList<>();
    private static int customerNumber = 0;
    public void run() {
        Random random_object = new Random();
        while (true) {
            int randomSleepTime = random_object.nextInt(10000);
            try {
                sleep(randomSleepTime);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitingQueue.add(customerNumber++);
        }
    }
}


