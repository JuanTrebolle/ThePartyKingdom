package readers_writers;

import flyweight.T;
import proxy.TreasureRoomDoor;
import proxy.TreasureRoomGuardsman;
import singleton.Logger;
import utility.collection.ArrayList;

public class Accountant implements Runnable
{
  private TreasureRoomDoor treasureRoomDoor = new TreasureRoomGuardsman();
  private ArrayList<T> list = new ArrayList<>();
  private int sum = 0;
  private Logger logger = Logger.getInstance();

  public Accountant(TreasureRoomDoor treasureRoomDoor)
  {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override public void run()
  {
    while (true){
      //step 1. Acquire read
      treasureRoomDoor.acquireReadAccess("Accountant");
      //step 2. Count gems in treasure room and then sleep

      list = (ArrayList<T>) treasureRoomDoor.lookAtAllGems();
      for (int i = 0; i < list.size(); i++)
      {
        sum+= list.get(i).getValue();
      }
      try
      {
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

      //step 3. Print total sum of gems(Logger)
      logger.getMessage("Accountant : total sum " + sum + "$");

      //step 4. Release read
      treasureRoomDoor.releaseReadAccess("Accountant");
      //step 5. Sleep

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
