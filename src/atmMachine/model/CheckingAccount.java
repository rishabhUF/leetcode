package atmMachine.model;

import javafx.util.Pair;

import java.util.Date;

public class CheckingAccount extends Account {
    private Card debitCard;

    public CheckingAccount(Card debitCard) {
        this.debitCard = debitCard;
    }

    public Pair<String, Date> getDebitCardInformation() {
        return debitCard.getCardDetails();
    }

    public void issueDebitCard(Card debitCard) {
        this.debitCard = debitCard;
    }
}
