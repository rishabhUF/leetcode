package atmMachine.model;

public class CashDispenser {
    private int totalFiveDollarBills;
    private int totalTwentyDollarBills;

    public int getTotalFiveDollarBills() {
        return totalFiveDollarBills;
    }

    public void setTotalFiveDollarBills(int totalFiveDollarBills) {
        this.totalFiveDollarBills += totalFiveDollarBills;
    }

    public int getTotalTwentyDollarBills() {
        return totalTwentyDollarBills;
    }

    public void setTotalTwentyDollarBills(int totalTwentyDollarBills) {
        this.totalTwentyDollarBills += totalTwentyDollarBills;
    }
}
