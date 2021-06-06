package by.epam.webproject.model.entity;

/**
 * The {@code User} class represents user entity
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class User {
    /**
     *  The value is used for user id storage.
     */
    private int userId;

    /**
     *  The value is used for email storage.
     */
    private String email;

    /**
     *  The value is used for loin storage.
     */
    private String login;

    /**
     *  The value is used for password storage.
     */
    private String password;

    /**
     *  The value is used for amount of bets storage.
     */
    private int amountOfBets;

    /**
     *  The value is used for is approved storage.
     */
    private boolean isApproved;

    /**
     *  The value is used for role storage.
     */
    private UserRole role;

    /**
     *  The value is used for wallet storage.
     */
    private Wallet wallet;

    /**
     * Gets user id
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets email
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets login
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get amount of bets
     *
     * @return the amount of bets
     */
    public int getAmountOfBets() {
        return amountOfBets;
    }

    /**
     * Set amount of bets
     *
     * @param amountOfBets the amount of bets
     */
    public void setAmountOfBets(int amountOfBets) {
        this.amountOfBets = amountOfBets;
    }

    /**
     * Gets is approved
     *
     * @return the is approved
     */
    public boolean getIsApproved() {
        return isApproved;
    }

    /**
     * Sets is approved
     *
     * @param isApproved the is approved
     */
    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    /**
     * Gets role
     *
     * @return the role
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets role
     *
     * @param role the role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Gets wallet
     *
     * @return the wallet
     */
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * Sets wallet
     *
     * @param wallet the wallet
     */
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
