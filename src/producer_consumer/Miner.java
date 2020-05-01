package producer_consumer;

import adapter.Deposit;
import flyweight.Mine;

public class Miner implements Runnable{
    private Mine mine;
    private Deposit sharedResource;

    @Override
    public void run() {
        while (true){

        }
    }
}
