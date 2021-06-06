package by.epam.webproject.model.entity;

/**
 * The {@code Race} class represents race entity
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class Race {
    /**
     *  The value is used for race id storage.
     */
    private int raceId;

    /**
     *  The value is used for title storage.
     */
    private String title;

    /**
     *  The value is used for rounds storage.
     */
    private int rounds;

    /**
     *  The value is used for details storage.
     */
    private String details;

    /**
     *  The value is used for race data storage.
     */
    private RaceData raceData;

    public Race() {
    }

    /**
     * Instantiates a new Race
     *
     * @param title the title
     * @param raceData the race data
     */
    public Race(String title,RaceData raceData) {
        this.title = title;
        this.raceData = raceData;
    }

    /**
     * Gets race id
     *
     * @return the race id
     */
    public int getRaceId() {
        return raceId;
    }

    /**
     * Sets race id
     *
     * @param raceId the race id
     */
    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    /**
     * Gets title
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets rounds
     *
     * @return the rounds
     */
    public int getRounds() {
        return rounds;
    }

    /**
     * Sets rounds
     *
     * @param rounds the rounds
     */
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    /**
     * Gets details
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Set details
     *
     * @param details the details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Gets race data
     *
     * @return the race data
     */
    public RaceData getRaceData() {
        return raceData;
    }

    /**
     * Sets race data
     *
     * @param raceData the race data
     */
    public void setRaceData(RaceData raceData) {
        this.raceData = raceData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Race race = (Race) o;
        if (raceId != race.raceId) {
            return false;
        }
        if (rounds != race.rounds) {
            return false;
        }
        if (!title.equals(race.title)) {
            return false;
        }
        if (!details.equals(race.details)) {
            return false;
        }
        return raceData.equals(race.raceData);
    }

    @Override
    public int hashCode() {
        int result = raceId;
        result = 11 * result + title.hashCode();
        result = 11 * result + rounds;
        result = 11 * result + details.hashCode();
        result = 11 * result + raceData.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Race{");
        sb.append("raceId=").append(raceId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", rounds=").append(rounds);
        sb.append(", details='").append(details).append('\'');
        sb.append(", raceData=").append(raceData);
        sb.append('}');
        return sb.toString();
    }
}
