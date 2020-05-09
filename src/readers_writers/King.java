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

    @Override
    public void run() {
        while (true) {
            Logger logger = Logger.getInstance();

            //Step 1: generate random number to pay the party.
            int random = (int) (Math.random() * (150 - 50) + (50));
            logger.getMessage("King: I need " + random + "$ for my project X party");

            //Step 2: acquire write access.
            treasureRoomDoor.acquireWriteAccess("Da king...DA-DDY-YAN-KEE!!");
            logger.getMessage("King: I have write access");

            //Step 3: retrieves gems(one at a time) and sleep.
            do {
                myGem = treasureRoomDoor.retrieveValuable();
                value += myGem.getValue();
                kingList.add(myGem);
                logger.getMessage("King: gem to the bag");
            } while (value < random);

            try {
                logger.getMessage("King: I need a break");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Step 4: release the write
            treasureRoomDoor.releaseWriteAccess("Da king...DA-DDY-YAN-KEE!");
            if (value >= random){
                logger.getMessage("King: I'm throwing THE party :)");
                kingList.clear();
            }

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
