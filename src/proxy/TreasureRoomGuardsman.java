package proxy;

import flyweight.T;

import java.util.List;

//proxy. readers preference

public class TreasureRoomGuardsman implements TreasureRoomDoor
{

  private boolean activeWriter;
  private int activeReaders;
  private int waitingReaders;

  private TreasureRoom treasureRoom;

  public TreasureRoomGuardsman()
  {
    this.treasureRoom = new TreasureRoom();
  }

  @Override public synchronized void acquireReadAccess(String actorName)
  {
    waitingReaders++;
    while(activeWriter)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    waitingReaders--;
    activeReaders++;
    treasureRoom.acquireReadAccess(actorName);
  }

  @Override public synchronized void acquireWriteAccess(String actorName)
  {
    while (activeWriter ||  activeReaders > 0 || waitingReaders > 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    activeWriter = true;
    treasureRoom.acquireWriteAccess(actorName);
  }

  @Override public synchronized void releaseReadAccess(String actorName)
  {
    activeReaders--;
    if(activeReaders == 0){
      notifyAll();
    }
    treasureRoom.releaseReadAccess(actorName);
  }

  @Override public synchronized void releaseWriteAccess(String actorName)
  {
    activeWriter = false;
    notifyAll();
    treasureRoom.releaseWriteAccess(actorName);
  }

  @Override public T retrieveValuable()
  {
    return treasureRoom.retrieveValuable();
  }

  @Override public void addValuable(T v)
  {
    treasureRoom.addValuable(v);
  }

  @Override public List<T> lookAtAllGems()
  {
    return treasureRoom.lookAtAllGems();
  }
}
