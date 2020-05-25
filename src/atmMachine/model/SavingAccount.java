package atmMachine.model;

public class SavingAccount extends Account {
    private int withdrawLimit;

    public SavingAccount() {
        System.out.println("saving contruct");
    }

    public int getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(int withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}
