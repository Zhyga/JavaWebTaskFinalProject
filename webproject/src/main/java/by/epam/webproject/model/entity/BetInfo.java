package by.epam.webproject.model.entity;

import java.time.LocalDateTime;

/**
 * The {@code BetInfo} class represents bet info entity
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class BetInfo {
    /**
     *  The value is used for bet info id storage.
     */
    private int betInfoId;

    /**
     *  The value is used for prize storage.
     */
    private double prize;

    /**
     *  The value is used for bet size storage.
     */
    private double betSize;

    /**
     *  The value is used for multiplier storage.
     */
    private double multiplier;

    /**
     *  The value is used for bet status storage.
     */
    private String betStatus;

    /**
     *  The value is used for date storage.
     */
    private LocalDateTime date;

    /**
     *  The value is used for bet info storage.
     */
    private String betInfo;

    /**
     *  The value is used for user id storage.
     */
    private int userId;

    /**
     *  The value is used for bet id storage.
     */
    private int betId;

    /**
     * Gets date
     *
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets date
     *
     * @param date the date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Gets bet info
     *
     * @return the bet info
     */
    public String getBetInfo() {
        return betInfo;
    }

    /**
     * Sets bet info
     *
     * @param betInfo the bet info
     */
    public void setBetInfo(String betInfo) {
        this.betInfo = betInfo;
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
     * Gets bet info id
     *
     * @return the bet info id
     */
    public int getBetInfoId() {
        return betInfoId;
    }

    /**
     * Sets bet info if
     *
     * @param betInfoId the bet info id
     */
    public void setBetInfoId(int betInfoId) {
        this.betInfoId = betInfoId;
    }

    /**
     * Gets prize
     *
     * @return the prize
     */
    public double getPrize() {
        return prize;
    }

    /**
     * Sets prize
     *
     * @param prize the prize
     */
    public void setPrize(double prize) {
        this.prize = prize;
    }

    /**
     * Gets bet size
     *
     * @return the bet size
     */
    public double getBetSize() {
        return betSize;
    }

    /**
     * Sets bet size
     *
     * @param betSize the bet size
     */
    public void setBetSize(double betSize) {
        this.betSize = betSize;
    }

    /**
     * Gets multiplier
     *
     * @return the multiplier
     */
    public double getMultiplier() {
        return multiplier;
    }

    /**
     * Sets multiplier
     *
     * @param multiplier the multiplier
     */
    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    /**
     * Gets bet status
     *
     * @return the bet status
     */
    public String getBetStatus() {
        return betStatus;
    }

    /**
     * Sets bet status
     *
     * @param betStatus the bet status
     */
    public void setBetStatus(String betStatus) {
        this.betStatus = betStatus;
    }

    /**
     * Gets bet id
     *
     * @return the bet id
     */
    public int getBetId() {
        return betId;
    }

    /**
     * Sets bet id
     *
     * @param betId the bet id
     */
    public void setBetId(int betId) {
        this.betId = betId;
    }

    /**
     * Gets user id
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BetInfo betInfo = (BetInfo) o;

        if (Double.compare(betInfo.prize, prize) != 0) {
            return false;
        }
        if (Double.compare(betInfo.betSize, betSize) != 0) {
            return false;
        }
        if (Double.compare(betInfo.multiplier, multiplier) != 0) {
            return false;
        }
        return betId == betInfo.betId;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(prize);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(betSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(multiplier);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + betStatus.hashCode();
        result = 31 * result + userId;
        result = 31 * result + betId;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BetInfo{");
        sb.append("prize=").append(prize);
        sb.append(", betSize=").append(betSize);
        sb.append(", multiplier=").append(multiplier);
        sb.append(", betStatus=").append(betStatus);
        sb.append(", userId=").append(userId);
        sb.append(", betId=").append(betId);
        sb.append('}');
        return sb.toString();
    }
}
