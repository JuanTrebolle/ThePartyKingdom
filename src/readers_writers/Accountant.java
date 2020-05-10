package readers_writers;
import proxy.TreasureRoomDoor;
import proxy.TreasureRoomGuardsman;
import singleton.Logger;

public class Accountant implements Runnable
{
  private TreasureRoomDoor treasureRoomDoor = new TreasureRoomGuardsman();
  private int sum = 0;
  private Logger logger = Logger.getInstance();
  private String name;

  public Accountant(TreasureRoomDoor treasureRoomDoor, String name)
  {
    this.treasureRoomDoor = treasureRoomDoor;
    this.name = name;
  }

  @Override public void run()
  {
    while (true){
      //step 1. Acquire read
      treasureRoomDoor.acquireReadAccess(name);

      Logger.getInstance().getMessage(name + ": enters treasure room");

      //step 2. Count gems in treasure room and then sleep

      for (int i = 0; i < treasureRoomDoor.lookAtAllGems().size(); i++)
      {
        sum += treasureRoomDoor.lookAtAllGems().get(i).getValue();
        try
        {
          Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }

      //step 3. Print total sum of gems(Logger)
      logger.getMessage(name + ": total sum " + sum + "$");

      //step 4. Release read
      treasureRoomDoor.releaseReadAccess(name);
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
