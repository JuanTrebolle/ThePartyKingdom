package proxy;

import flyweight.T;

import java.util.List;

//proxy. writers preference

public class TreasureRoomGuardsman implements TreasureRoomDoor
{

  private boolean activeWriter;
  private int waitingWriters;
  private int activeReaders;
  private int waitingReaders;

  private TreasureRoom treasureRoom;

  @Override public synchronized void acquireReadAccess(String actorName)
  {
    while (activeWriter || waitingWriters > 0){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    activeReaders++;
  }

  @Override public synchronized void acquireWriteAccess(String actorName)
  {
    waitingWriters++;
    while (activeWriter || activeReaders > 0){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    waitingWriters--;
    activeWriter = true;
  }

  @Override public void releaseReadAccess(String actorName)
  {
    activeReaders--;
    if(activeReaders == 0){
      notifyAll();
    }
  }

  @Override public void releaseWriteAccess(String actorName)
  {
    activeWriter = false;
    notifyAll();
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
