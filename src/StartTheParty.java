import adapter.Deposit;
import flyweight.Mine;
import producer_consumer.GovernorRatcliffe;
import producer_consumer.Miner;

public class StartTheParty
{
  public static void main(String[] args)
  {
    Mine mine = new Mine();
    Deposit gemDeposit = new Deposit(2000);
    Miner ramon = new Miner(gemDeposit);
    GovernorRatcliffe ratcliffe = new GovernorRatcliffe(gemDeposit);

    Thread miner = new Thread(ramon);
    Thread transporter = new Thread(ratcliffe);

    miner.start();
    transporter.start();
  }
}
