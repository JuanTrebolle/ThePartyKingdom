import adapter.Deposit;
import flyweight.Mine;
import producer_consumer.GemTransporter;
import producer_consumer.Miner;
import proxy.TreasureRoom;
import readers_writers.Accountant;
import readers_writers.King;

public class StartTheParty
{
  public static void main(String[] args)
  {
    Mine mine = new Mine();

    Deposit gemDeposit = new Deposit(2000);

    TreasureRoom treasureRoom = new TreasureRoom();

    Miner ramon = new Miner(mine, gemDeposit);
    Miner bruno = new Miner(mine, gemDeposit);
    Miner vanessa = new Miner(mine, gemDeposit);


    GemTransporter governorRatcliffe = new GemTransporter(gemDeposit);
    GemTransporter sirBlaise = new GemTransporter(gemDeposit);

    Accountant claudia = new Accountant();

    King joffrey = new King();

    Thread miner1 = new Thread(ramon);
    Thread miner2 = new Thread(bruno);
    Thread miner3 = new Thread(vanessa);
    Thread transporter1 = new Thread(governorRatcliffe);
    Thread transporter2 = new Thread(sirBlaise);
    Thread accountant = new Thread(claudia);
    Thread king = new Thread(joffrey);

    miner1.start();
    miner2.start();
    miner3.start();
    transporter1.start();
    transporter2.start();
    accountant.start();
    king.start();
  }
}
