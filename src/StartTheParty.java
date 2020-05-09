import adapter.Deposit;
import flyweight.Mine;
import producer_consumer.GovernorRatcliffe;
import producer_consumer.Miner;
import proxy.TreasureRoom;
import proxy.TreasureRoomGuardsman;
import readers_writers.Accountant;

public class StartTheParty
{
  public static void main(String[] args)
  {
    Mine mine = new Mine();
    Deposit gemDeposit = new Deposit(2000);
    Miner ramon = new Miner(gemDeposit);
    TreasureRoom treasureRoom = new TreasureRoom();
    GovernorRatcliffe ratcliffe = new GovernorRatcliffe(gemDeposit);
    Accountant alicia = new Accountant();
    TreasureRoomGuardsman blaise = new TreasureRoomGuardsman();

    Thread miner = new Thread(ramon);
    Thread transporter = new Thread(ratcliffe);
    Thread accountant = new Thread(alicia);

    miner.start();
    transporter.start();
    accountant.start();
  }
}
