package proxy;

import flyweight.T;
import flyweight.ValuableImpl;

import java.util.List;

public interface TreasureRoomDoor {

    void acquireReadAccess(String actorName);

    void acquireWriteAccess(String actorName);

    void releaseReadAccess(String actorName);

    void releaseWriteAccess(String actorName);

    T retrieveValuable();

    void addValuable(T v);

    List<T> lookAtAllGems();

}
