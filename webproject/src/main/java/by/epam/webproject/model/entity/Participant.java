package by.epam.webproject.model.entity;

public class Participant {
    private int participantID;
    private String horse;
    private int weight;
    private String jockey;

    public int getParticipantID() {
        return participantID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    public String getHorse() {
        return horse;
    }

    public void setHorse(String horse) {
        this.horse = horse;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant participant = (Participant) o;
        if (participantID != participant.participantID) {
            return false;
        }
        if (weight != participant.weight) {
            return false;
        }
        if (!horse.equals(participant.horse)) {
            return false;
        }
        return jockey.equals(participant.jockey);
    }

    @Override
    public int hashCode() {
        int result = participantID;
        result = 31 * result + horse.hashCode();
        result = 31 * result + weight;
        result = 31 * result + jockey.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Participant{");
        sb.append("participantID=").append(participantID);
        sb.append(", horse='").append(horse).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", jockey='").append(jockey).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
