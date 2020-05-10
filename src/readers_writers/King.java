package readers_writers;

import flyweight.T;
import proxy.TreasureRoomDoor;
import singleton.Logger;
import utility.collection.ArrayList;

public class King implements Runnable{

    private TreasureRoomDoor treasureRoomDoor;
    private ArrayList<T> kingList;
    private T myGem;
    private int value = 0;
    private String name;

    public King(TreasureRoomDoor treasureRoomDoor, String name)
    {
        this.treasureRoomDoor = treasureRoomDoor;
        this.name = name;
        this.kingList = new ArrayList<>();
    }

    @Override
    public void run() {
            //Step 1: generate random number to pay the party.
            int random = (int) (Math.random() * (150 - 50) + (50));
            Logger.getInstance().getMessage(name +  ": I need " + random + "$ for my party");

        while (true) {
            //Step 2: acquire write access.
            treasureRoomDoor.acquireWriteAccess(name);
            Logger.getInstance().getMessage(name +  ": I have write access");

            //Step 3: retrieves gems(one at a time) and sleep.
            for (int i = 0; i < treasureRoomDoor.lookAtAllGems().size(); i++)
            {
                myGem = treasureRoomDoor.retrieveValuable();
                value += myGem.getValue();
                kingList.add(myGem);
                Logger.getInstance().getMessage(name +  ": gem to the bag");
            }

            try {
                Logger.getInstance().getMessage(name +  ": I need a break");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Step 4: release the write
            if (value >= random){
                Logger.getInstance().getMessage(name +  ": I'm throwing THE party :)");
                kingList.clear();
            } else {
                Logger.getInstance().getMessage(name +  ": That's not enough for my party...");
                for (int i = 0; i < kingList.size(); i++)
                {
                    treasureRoomDoor.addValuable(kingList.get(i));
                }
            }
            treasureRoomDoor.releaseWriteAccess(name);

            //Step 5: sleep
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Step 6: start over
        }
    }
}
