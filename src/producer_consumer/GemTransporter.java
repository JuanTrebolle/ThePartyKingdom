package producer_consumer;

import adapter.Deposit;
import flyweight.T;
import proxy.TreasureRoomDoor;
import singleton.Logger;
import utility.collection.ArrayList;


public class GemTransporter implements Runnable
{
  private Deposit gemDeposit;
  private ArrayList<T> gems;
  private TreasureRoomDoor treasureRoomDoor;
  private String name;

  public GemTransporter(Deposit gemDeposit, TreasureRoomDoor treasureRoomDoor, String name)
  {
    this.gemDeposit = gemDeposit;
    this.treasureRoomDoor = treasureRoomDoor;
    this.gems = new ArrayList<>();
    this.name = name;
  }

  @Override public void run()
  {
      Logger logger = Logger.getInstance();

      //step 1 generate random number
      int random = (int) (Math.random() * (200-50) + (50));
      logger.getMessage(name + ": Hallo. I need to take " + random + "$ to the king's treasure room");

    while (true){

      int value = 0;
      T element;
      element = (T) gemDeposit.dequeue();

      gems.add(element);
      for (int i = 0; i < gems.size(); i++)
      {
      value += element.getValue();
      }

      logger.getMessage(name +": Okay, I got " + value + " $");

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      //step 2 get gem from gem deposit until he has the equal to or over the target amount
/*
      while (value < random)
      {
        for (int i = 0; i < gemDeposit.size(); i++)
        {
          element = (T) gemDeposit.dequeue();
          value += element.getValue();
          gems.add(element);
          logger.getMessage(name +": Okay, I got " + value + " $");
      }
        }*/

      if(value >= random){
      logger.getMessage(name+ ": Okay, I got what i need");

      //step 3 clear the list used to contained the gems
        treasureRoomDoor.acquireWriteAccess(name);
        logger.getMessage(name + ": write aquired");
      for (int i = 0; i < gems.size() ; i++) {
        treasureRoomDoor.addValuable(gems.get(i));
        gems.remove(i);
      }
        treasureRoomDoor.releaseWriteAccess(name);
        logger.getMessage(name + ": write released");
      }

      //step 4 sleep
      try {
        logger.getMessage(name + ": I need a break to smoke my cigar while i wait for you to find me some gems");
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        }

      //step 5 is starting over from step 1
    }
  }
}
