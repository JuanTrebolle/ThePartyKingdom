package proxy;

import flyweight.T;
import singleton.Logger;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasureRoomDoor {
    private List<T> gems;
    Logger logger = Logger.getInstance();
    public TreasureRoom() {
        gems = new ArrayList<>();
    }

    // access methods

    public synchronized void acquireReadAccess(String actorName) {
        logger.getMessage(actorName + " reads");
     }

    public synchronized void acquireWriteAccess(String actorName) {
        logger.getMessage(actorName + " writes");
    }

    public synchronized void releaseReadAccess(String actorName) {
        logger.getMessage(actorName + " releases read ");
    }

    public synchronized void releaseWriteAccess(String actorName) {
        logger.getMessage(actorName + " releases write ");
    }

    // interact methods

    public T retrieveValuable() {
        T v = null;
        if (gems.size() > 0) {
            v = gems.remove(0);
        }
        return v;
    }

    public void addValuable(T v) {
        gems.add(v);
    }

    @Override
    public List<T> lookAtAllGems() {
        return new ArrayList<T>(gems);
    }
}
