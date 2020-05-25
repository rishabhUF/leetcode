package atmMachine.model;

import atmMachine.Exception.AccountNotFoundException;

import java.util.*;

public class Bank {
    private String name;
    private String bankCode;
    private Map<Integer, Account> accountMap;
    private Set<String> atmMap;
    private Map<String, Account> cardAccountMap;
    Set<Integer> validDebitCards;

    //TODO
    // Add function to add bank ATM

    public Bank(String name, String bankCode) {
        this.name = name;
        this.bankCode = bankCode;
        this.accountMap = new HashMap<>();
        this.validDebitCards = new HashSet<>();
    }

    public void addATMBranch(String atmId) {
        atmMap.add(atmId);
    }

    public boolean verifyCard(String cardNumber) {
        if(accountMap.containsKey(cardNumber)) {
            return true;
        }
        return false;
    }

    public void addAccount(Account account) {
        this.accountMap.put(account.getAccountNumber(), account);
    }

    public Account getAccount(int accountNumber) throws AccountNotFoundException {
        if(accountMap.containsKey(accountNumber)) {
            return accountMap.get(accountNumber);
        }
        throw new AccountNotFoundException("Account not found");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Map<Integer, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<Integer, Account> accountMap) {
        this.accountMap = accountMap;
    }

    public void processWithdraw(String cardNumber, int amount) {
    }

    public void processDeposit(String cardNumber, int amount) {
    }

    public void getCustomerDetails(String cardNumber) {
    }
}
