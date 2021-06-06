package by.epam.webproject.model.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The {@code RaceData} class represents race data entity
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class RaceData {
    /**
     *  The value is used for race data id storage.
     */
    private int raceDataId;

    /**
     *  The value is used for date storage.
     */
    private LocalDateTime date;

    /**
     *  The value is used for participants id storage.
     */
    private List<Participant> participantsId;

    /**
     * Instantiates a new Race
     *
     * @param date the date
     * @param participants the participants
     */
    public RaceData(LocalDateTime date,List<Participant> participants){
        this.date = date;
        this.participantsId = participants;
    }

    /**
     * Instantiates a new Race
     *
     * @param raceDataId the race data id
     * @param date the date
     * @param participants the participants
     */
    public RaceData(int raceDataId,LocalDateTime date,List<Participant> participants){
        this.raceDataId = raceDataId;
        this.date = date;
        this.participantsId = participants;
    }

    /**
     * Gets race data id
     *
     * @return the race data id
     */
    public int getRaceDataId() {
        return raceDataId;
    }

    /**
     * Sets race data id
     *
     * @param raceDataId the race data id
     */
    public void setRaceDataId(int raceDataId) {
        this.raceDataId = raceDataId;
    }

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
     * Gets participants id
     *
     * @return the participants id
     */
    public List<Participant> getParticipantsId() {
        return participantsId;
    }

    /**
     * Sets participants id
     *
     * @param participantsId the participants id
     */
    public void setParticipantsId(List<Participant> participantsId) {
        this.participantsId = participantsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RaceData raceData = (RaceData) o;

        if (raceDataId != raceData.raceDataId) {
            return false;
        }
        if (!date.equals(raceData.date)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = raceDataId;
        result = 31 * result + date.hashCode();
        result = 31 * result + participantsId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RaceData{");
        sb.append("raceDataId=").append(raceDataId);
        sb.append(", date=").append(date);
        sb.append(", participantId=").append(participantsId);
        sb.append('}');
        return sb.toString();
    }
}
