package by.epam.webproject.model.entity;

/**
 * The {@code Wallet} class represents wallet entity
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class Wallet {
    /**
     *  The value is used for wallet id storage.
     */
    private Integer walletId;

    /**
     *  The value is used for balance storage.
     */
    private double balance;

    public Wallet(){}

    /**
     * Instantiates a new Bet
     *
     * @param walletId the wallet id
     * @param balance the balance
     */
    public Wallet(Integer walletId, double balance){
        this.walletId = walletId;
        this.balance = balance;
    }

    /**
     * Gets wallet id
     *
     * @return the wallet id
     */
    public Integer getWalletId() {
        return walletId;
    }

    /**
     * Sets wallet id
     *
     * @param walletId the wallet id
     */
    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    /**
     * Gets balance
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets balance
     *
     * @param balance the balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Wallet wallet = (Wallet) o;

        if (walletId != wallet.walletId) {
            return false;
        }
        return Double.compare(wallet.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = walletId;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Wallet{");
        sb.append("walletId=").append(walletId);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}
