import adapter.Deposit;
import flyweight.Mine;
import producer_consumer.GemTransporter;
import producer_consumer.Miner;
import proxy.TreasureRoom;
import proxy.TreasureRoomDoor;
import proxy.TreasureRoomGuardsman;
import readers_writers.Accountant;
import readers_writers.King;

public class StartTheParty
{
  public static void main(String[] args)
  {
    Mine mine = new Mine();

    Deposit gemDeposit = new Deposit(2000);

    TreasureRoomDoor guard = new TreasureRoomGuardsman();

    Miner ramon = new Miner(mine, gemDeposit, "Ramon");
    Miner bruno = new Miner(mine, gemDeposit, "Bruno");
    Miner vanessa = new Miner(mine, gemDeposit, "Vanessa");


    GemTransporter governorRatcliffe = new GemTransporter(gemDeposit, guard, "Governor Ratcliffe");
    //this is the gem transporter but we thought he looked a lot like the bad guy from Pocahontas
    GemTransporter sirBlaise = new GemTransporter(gemDeposit, guard, "Sir Blaise Zabini");

    Accountant claudia = new Accountant(guard);

    King joffrey = new King(guard);

    Thread miner1 = new Thread(ramon);
    Thread miner2 = new Thread(bruno);
    Thread miner3 = new Thread(vanessa);
    Thread transporter1 = new Thread(governorRatcliffe);
    Thread transporter2 = new Thread(sirBlaise);
    Thread accountant = new Thread(claudia);
    Thread king = new Thread(joffrey);

    king.start();
    miner1.start();
    miner2.start();
    miner3.start();
    transporter1.start();
    transporter2.start();
    accountant.start();
  }
}
