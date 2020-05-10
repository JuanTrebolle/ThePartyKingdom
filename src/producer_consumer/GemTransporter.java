package producer_consumer;

//this is the gem transporter but we thought he looked a lot like the guy from Pocahontas

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
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      int value = 0;
      T element;

      //step 2 get gem from gem deposit until he has the equal to or over the target amount
      while (value < random)
      {

        for (int i = 0; i < gemDeposit.size(); i++)
        {
          element = (T) gemDeposit.dequeue();
          value += element.getValue();
          gems.add(element);
          logger.getMessage(name +": Okay, I got " + value + " $");
        }
      }

      if(value >= random){
      logger.getMessage(name+ ": Okay, I got what i need");

      }

        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      //step 3 clear the list used to contained the gems
      for (int i = 0; i < gems.size() ; i++) {
        treasureRoomDoor.acquireWriteAccess("Transporter");
        logger.getMessage(name + ": write aquired");

        treasureRoomDoor.addValuable(gems.get(i));
        treasureRoomDoor.releaseWriteAccess("Transporter");
        logger.getMessage(name + ": write released");
      }

      //step 4 sleep
      try {
        logger.getMessage(name + ": I need a break to smoke my cigar");
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        }

      //step 5 is starting over from step 1
    }
  }
}
