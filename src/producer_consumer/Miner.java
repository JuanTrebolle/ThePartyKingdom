package producer_consumer;

import adapter.Deposit;
import flyweight.Mine;
import singleton.Logger;

public class Miner<T> implements Runnable{
    private static final int DIAMOND = 0;
    private static final int GOLDNUGGET = 1;
    private static final int RUBY = 2;
    private Deposit gemDeposit;
    private T element;
    private String name;

  public Miner(Mine mine, Deposit gemDeposit, String name)
  {
    this.gemDeposit = gemDeposit;
    this.name = name;
  }

  @Override
    public void run() {
        while (true){
          Logger logger = Logger.getInstance();
          int random = (int) (Math.random() * (2));

         if(random == 0)
            element = (T) Mine.getValues("Diamond", 11);
          logger.getMessage(name + ": wow I found a diamond");
         if(random == 1)
             element = (T) Mine.getValues("GoldNugget", 5);
          logger.getMessage(name + ": wow I found a GoldNugget");
          if(random == 2)
             element = (T) Mine.getValues("Ruby", 8);
          logger.getMessage(name + ": wow I found a Ruby");

          gemDeposit.enqueue(element);

            try
            {
                Thread.sleep(2000);
              logger.getMessage(name + ": I need a break");

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}
