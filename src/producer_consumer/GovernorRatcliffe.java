package producer_consumer;

//this is the gem transporter but we thought he looked a lot like the guy from Pocahontas

import adapter.Deposit;
import flyweight.T;
import singleton.Logger;
import utility.collection.ArrayList;

public class GovernorRatcliffe implements Runnable
{
  private Deposit gemDeposit;
  private ArrayList<T> gems;
 // private static final int TARGET = 200;

  public GovernorRatcliffe(Deposit gemDeposit)
  {
    this.gemDeposit = gemDeposit;
  }

  @Override public void run()
  {
    while (true){

      int value = 0;
      T element;
      Logger logger = Logger.getInstance();

      //step 1 generate random number
      int random = (int) (Math.random() * (200-50) + (50));
      logger.getMessage("Governor Ratcliffe: Hallo. I need to take " + random + "$ to the king for this cool party");

      try
      {
        Thread.sleep(10000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      //step 2 get gem from gem deposit until he has the equal to or over the target amount
      do{
       element = (T) gemDeposit.dequeue();
       value+= element.getValue();
       try
       {
         gems.add(element);
       }
       catch (NullPointerException e)
       {
         e.printStackTrace();

       } logger.getMessage("Governor Ratcliffe: Okay Ramon, I got " + value + " $");
      }while (value < random);

      logger.getMessage("Governor Ratcliffe: Okay Ramon, I got what i need");
      //step 3 clear the list used to contained the gems --> obs we don't have a place to put them so just clear for now

     /* for (int i = 0; i < gems.size() ; i++)
      {
        gems.remove(i);
      }*/

     gems.clear();

        logger.getMessage("Governor Ratcliffe: List cleared");

      //step 4 sleep
      try
      {
        logger.getMessage("Governor Ratcliffe: I need a break to smoke my cigar");
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

      //step 5 is starting over from step 1

    }


  }
}
