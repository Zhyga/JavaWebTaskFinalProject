package by.epam.webproject.model.entity;

import java.time.LocalDateTime;

public class BetInfo {
    private int betInfoId;
    private double prize;
    private double betSize;
    private double multiplier;
    private String betStatus;
    private LocalDateTime date;
    private String betInfo;
    private int userId;
    private int betId;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getBetInfo() {
        return betInfo;
    }

    public void setBetInfo(String betInfo) {
        this.betInfo = betInfo;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBetInfoId() {
        return betInfoId;
    }

    public void setBetInfoId(int betInfoId) {
        this.betInfoId = betInfoId;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public double getBetSize() {
        return betSize;
    }

    public void setBetSize(double betSize) {
        this.betSize = betSize;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public String getBetStatus() {
        return betStatus;
    }

    public void setBetStatus(String betStatus) {
        this.betStatus = betStatus;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
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
