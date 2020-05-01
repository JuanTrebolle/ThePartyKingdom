package producer_consumer;

import adapter.Deposit;

public class ValuableTransporter implements Runnable{

    private Deposit sharedResource;

    @Override
    public void run() {
        while (true){
            /*
            * TODO:
            *   1. Generate a random number between 50-200
            *   2. Get the next valuable from the deposit(a number of times), until he has a list with a total worth
            *       equal to or more than the original target number.
            *   3. Clear the list used to contain the valuables.
            *   4. Sleep for a while.
            *   5. Start again from step 1.
            * */
        }
    }
}
