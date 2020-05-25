package atmMachine.model;

import java.io.IOException;
import java.util.UUID;

public class ATM {
    private String atmID;
    private Address address;
    private Bank bank;
    private Keyboard keyboard;
    private CashDispenser cashDispenser;
    private Screen screen;

    public ATM(Bank bank, Address address) {
        this.atmID = UUID.randomUUID().toString();
        this.address = address;
        this.bank = bank;
        bank.addATMBranch(atmID);
        keyboard = new Keyboard();
        this.cashDispenser = new CashDispenser();
    }

    // ATM Methods
    public boolean insertCard(Card card) throws IOException {
        System.out.println("Welcome you to "+ bank.getName() + " ATM at street " + address.getStreet());
        if(!validateTheCard(card.getCardNumber())) {
            System.out.println("Please enter the valid card");
        }
        System.out.println("Enter your PIN");
        String pin = keyboard.getInput();
        if(card.getPin() != Integer.parseInt(pin)) {
            return false;
        }
        int option = printAndGetOptions();
        while(option != 4) {
            switch (option) {
                case 1:
                    processWithdraw(card.getCardNumber());
                    option = printAndGetOptions();
                    break;
                case 2:
                    processDeposit(card.getCardNumber());
                    option = printAndGetOptions();
                    break;
                case 3:
                    getCustomerInfo(card.getCardNumber());
                    option = printAndGetOptions();
                    break;
                default:
                    System.out.println("Thank you");
                    break;
            }
        }
        return true;
    }

    public boolean addMoneyToATM(int totalTwentyDollarBills, int totalFiveDollarBills) {
        try {
            cashDispenser.setTotalFiveDollarBills(totalFiveDollarBills);
            cashDispenser.setTotalTwentyDollarBills(totalTwentyDollarBills);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void getCustomerInfo(String cardNumber) {
        bank.getCustomerDetails(cardNumber);
    }

    private void processDeposit(String cardNumber) throws IOException {
        System.out.println("Please Enter the amount you want to deposit");
        int amount = Integer.parseInt(keyboard.getInput());
        bank.processDeposit(cardNumber, amount);
    }

    private void processWithdraw(String cardNumber) throws IOException {
        System.out.println("Please enter the amount you want to withdraw");
        int amount = Integer.parseInt(keyboard.getInput());
        if(amount > cashDispenser.getTotalFiveDollarBills()*5 + cashDispenser.getTotalTwentyDollarBills()*20) {
            System.out.println("ATM is out of cash");
        }
        try {
            bank.processWithdraw(cardNumber, amount);
        } catch (Exception e) {

        }
    }

    private int printAndGetOptions() throws IOException {
        int option = 4;
        System.out.println("Choose from the following:");
        System.out.println("1. WITHDRAW");
        System.out.println("2. DEPOSIT");
        System.out.println("3. BALANCE INQUIRY");
        System.out.println("4. EXIT");
        option = Integer.parseInt(keyboard.getInput());
        return option;
    }

    private boolean validateTheCard(String cardNumber) {
        return bank.verifyCard(cardNumber);
    }
}
