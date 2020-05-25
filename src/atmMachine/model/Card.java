package atmMachine.model;

import javafx.util.Pair;

import java.util.Date;

public class Card {
    private String cardNumber;
    private String customerName;
    private Date expiryDate;
    private int pin;
    public Address getBillingAddress() {
        return null;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Pair<String, Date> getCardDetails() {
        return new Pair<>(cardNumber, expiryDate);
    }
}
