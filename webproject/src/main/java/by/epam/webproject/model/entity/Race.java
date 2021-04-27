package by.epam.webproject.model.entity;

public class Race {
    private int raceId;
    private String title;
    private int rounds;
    private String details;
    private RaceData raceData;

    public Race() {
    }

    public Race(String title,RaceData raceData) {
        this.title = title;
        this.raceData = raceData;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public RaceData getRaceData() {
        return raceData;
    }

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
