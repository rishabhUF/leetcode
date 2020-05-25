package atmMachine;

import atmMachine.model.*;

public class atmMachine {
    public static void main(String[] args) {
        // ----- Create a New Bank -----
        Bank bank = new Bank("Chase Bank", "CH101");
        // ----- Create a New ATM branch -----
        ATM chaseATM = new ATM();
        // ----- Create a New Customer ------
        Customer rishabh = new Customer();
        Customer jay = new Customer();
        // ----- Add checking account or Saving account -----
        Account account = new CheckingAccount();

        // ----- Add card for the customer ------

        // ----- Customer can use Atm -----
        rishabh.setAccount(account);
        Card card = new Card();
        card.setCardNumber("1234 4567 7891");
        card.setCustomerName("rishabh");

        rishabh.setCard(card);
        account.setAccountNumber(123456);
        account.setAvailableBalance(100);
        account.setTotalBalance(1500);

    }
}
