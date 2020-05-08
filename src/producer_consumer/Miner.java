package producer_consumer;

import adapter.Deposit;
import flyweight.Mine;

public class Miner<T> implements Runnable{
    private static final int DIAMOND = 0;
    private static final int GOLDNUGGET = 1;
    private static final int RUBY = 2;
    private Deposit gemDeposit;
    private T element;

    @Override
    public void run() {
        while (true){

           int random = (int) (Math.random() * (2));
         if(random == 0)
            element = (T) Mine.getValues("Diamond", 11);
         if(random == 1)
             element = (T) Mine.getValues("GoldNugget", 5);
         if(random == 2)
             element = (T) Mine.getValues("Ruby", 8);

         gemDeposit.enqueue(element);

            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}
