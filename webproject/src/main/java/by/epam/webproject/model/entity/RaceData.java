package by.epam.webproject.model.entity;

import java.time.LocalDateTime;
import java.util.List;

public class RaceData {
    private int raceDataId;
    private LocalDateTime date;
    private List<Participant> participantsId;

    public RaceData(int raceDataId,LocalDateTime date,List<Participant> participants){
        this.raceDataId = raceDataId;
        this.date = date;
        this.participantsId = participants;
    }

    public int getRaceDataId() {
        return raceDataId;
    }

    public void setRaceDataId(int raceDataId) {
        this.raceDataId = raceDataId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Participant> getParticipantsId() {
        return participantsId;
    }

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
