package by.epam.webproject.model.entity;

/**
 * The {@code Bet} class represents bet entity
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class Bet {
    /**
     *  The value is used for bet id storage.
     */
    private int betId;

    /**
     *  The value is used for type of bet storage.
     */
    private String typeOfBet;

    /**
     *  The value is used for first multiplier storage.
     */
    private double firstMultiplier;

    /**
     *  The value is used for second multiplier storage.
     */
    private double secondMultiplier;

    /**
     *  The value is used for race id storage.
     */
    private Race raceId;

    public Bet(){}

    /**
     * Instantiates a new Bet
     *
     * @param typeOfBet the type of bet
     * @param raceId the race id
     */
    public Bet(String typeOfBet,Race raceId) {
        this.typeOfBet = typeOfBet;
        this.raceId = raceId;
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
     * Gets type of bet
     *
     * @return the type of bet
     */
    public String getTypeOfBet() {
        return typeOfBet;
    }

    /**
     * Sets type of bet
     *
     * @param typeOfBet the type of bet
     */
    public void setTypeOfBet(String typeOfBet) {
        this.typeOfBet = typeOfBet;
    }

    /**
     * Gets first multiplier
     *
     * @return the first multiplier
     */
    public double getFirstMultiplier() {
        return firstMultiplier;
    }

    /**
     * Sets first multiplier
     *
     * @param firstMultiplier the first multiplier
     */
    public void setFirstMultiplier(double firstMultiplier) {
        this.firstMultiplier = firstMultiplier;
    }

    /**
     * Gets second multiplier
     *
     * @return the second multiplier
     */
    public double getSecondMultiplier() {
        return secondMultiplier;
    }

    /**
     * Sets second multiplier
     *
     * @param secondMultiplier the second multiplier
     */
    public void setSecondMultiplier(double secondMultiplier) {
        this.secondMultiplier = secondMultiplier;
    }

    /**
     * Gets race id
     *
     * @return the race id
     */
    public Race getRaceId() {
        return raceId;
    }

    /**
     * Sets race id
     *
     * @param raceId the race id
     */
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
