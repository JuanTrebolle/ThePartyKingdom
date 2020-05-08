package proxy;

import flyweight.T;

import java.util.List;

public class TreasureRoomGuardsman implements TreasureRoomDoor
{

  private TreasureRoom treasureRoom;

  @Override public void acquireReadAccess(String actorName)
  {

  }

  @Override public void acquireWriteAccess(String actorName)
  {

  }

  @Override public void releaseReadAccess(String actorName)
  {

  }

  @Override public void releaseWriteAccess(String actorName)
  {

  }

  @Override public T retrieveValuable()
  {
    return null;
  }

  @Override public void addValuable(T v)
  {

  }

  @Override public List<T> lookAtAllGems()
  {
    return null;
  }
}
