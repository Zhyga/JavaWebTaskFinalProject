package by.epam.webproject.model.entity;

public class Bet {
    private int betId;
    private String typeOfBet;
    private double firstMultiplier;
    private double secondMultiplier;
    private Race raceId;

    public Bet(){}

    public Bet(String typeOfBet,Race raceId) {
        this.typeOfBet = typeOfBet;
        this.raceId = raceId;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public String getTypeOfBet() {
        return typeOfBet;
    }

    public void setTypeOfBet(String typeOfBet) {
        this.typeOfBet = typeOfBet;
    }

    public double getFirstMultiplier() {
        return firstMultiplier;
    }

    public void setFirstMultiplier(double firstMultiplier) {
        this.firstMultiplier = firstMultiplier;
    }

    public double getSecondMultiplier() {
        return secondMultiplier;
    }

    public void setSecondMultiplier(double secondMultiplier) {
        this.secondMultiplier = secondMultiplier;
    }

    public Race getRaceId() {
        return raceId;
    }

    public void setRaceId(Race raceId) {
        this.raceId = raceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Bet bet = (Bet) o;

        if (betId != bet.betId) {
            return false;
        }
        if (Double.compare(bet.firstMultiplier, firstMultiplier) != 0) {
            return false;
        }
        if (Double.compare(bet.secondMultiplier, secondMultiplier) != 0) {
            return false;
        }
        if (!typeOfBet.equals(bet.typeOfBet)) {
            return false;
        }
        return raceId.equals(bet.raceId);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = betId;
        result = 31 * result + typeOfBet.hashCode();
        temp = Double.doubleToLongBits(firstMultiplier);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(secondMultiplier);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + raceId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bet{");
        sb.append("betId=").append(betId);
        sb.append(", typOfBet='").append(typeOfBet).append('\'');
        sb.append(", firstMultiplier=").append(firstMultiplier);
        sb.append(", secondMultiplier=").append(secondMultiplier);
        sb.append(", raceId=").append(raceId);
        sb.append('}');
        return sb.toString();
    }
}
