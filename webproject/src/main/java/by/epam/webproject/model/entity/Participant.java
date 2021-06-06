package by.epam.webproject.model.entity;

/**
 * The {@code Participant} class represents participant entity
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class Participant {
    /**
     *  The value is used for participant id storage.
     */
    private int participantID;

    /**
     *  The value is used for horse storage.
     */
    private String horse;

    /**
     *  The value is used for weight storage.
     */
    private int weight;

    /**
     *  The value is used for jockey storage.
     */
    private String jockey;

    /**
     * Gets participant id
     *
     * @return the participant id
     */
    public int getParticipantID() {
        return participantID;
    }

    /**
     * Sets participant id
     *
     * @param participantID
     */
    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    /**
     * Gets horse
     *
     * @return the horse
     */
    public String getHorse() {
        return horse;
    }

    /**
     * Sets horse
     *
     * @param horse the horse
     */
    public void setHorse(String horse) {
        this.horse = horse;
    }

    /**
     * Gets weight
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets weight
     *
     * @param weight the weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Gets jockey
     *
     * @return the jockey
     */
    public String getJockey() {
        return jockey;
    }

    /**
     * Sets jockey
     *
     * @param jockey the jockey
     */
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
