package producer_consumer;

//this is the gem transporter but we thought he looked a lot like the guy from Pocahontas

import adapter.Deposit;

public class GovernorRatcliffe implements Runnable
{
  private Deposit gemDeposit;

  @Override public void run()
  {
    while (true){
      int random = (int) (Math.random() * (50-200) - (50));
    }


  }
}
