package by.epam.webproject.model.entity;

public class User {
    private int userId;
    private String email;
    private String login;
    private String password;
    private int amountOfBets;
    private boolean isApproved;
    private UserRole role;
    private Wallet wallet;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAmountOfBets() {
        return amountOfBets;
    }

    public void setAmountOfBets(int amountOfBets) {
        this.amountOfBets = amountOfBets;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        if (userId != user.userId) {
            return false;
        }
        if (amountOfBets != user.amountOfBets) {
            return false;
        }
        if (isApproved != user.isApproved) {
            return false;
        }
        if (!email.equals(user.email)) {
            return false;
        }
        if (!login.equals(user.login)) {
            return false;
        }
        if (!password.equals(user.password)) {
            return false;
        }
        if (!role.equals(user.role)) {
            return false;
        }
        return wallet.equals(user.wallet);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + email.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + amountOfBets;
        result = 31 * result + (isApproved ? 0 : 1);
        result = 31 * result + role.hashCode();
        result = 31 * result + wallet.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("user_id=").append(userId);
        sb.append(", email='").append(email).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", amountOfBets=").append(amountOfBets);
        sb.append(", isApproved=").append(isApproved);
        sb.append(", role=").append(role);
        sb.append(", wallet=").append(wallet);
        sb.append('}');
        return sb.toString();
    }
}
