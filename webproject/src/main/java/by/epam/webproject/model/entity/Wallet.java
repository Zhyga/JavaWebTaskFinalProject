package by.epam.webproject.model.entity;

public class Wallet {
    private Integer walletId;
    private double balance;

    public Wallet(Integer walletId, double balance){
        this.walletId = walletId;
        this.balance = balance;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public double getBalance() {
        return balance;
    }

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
