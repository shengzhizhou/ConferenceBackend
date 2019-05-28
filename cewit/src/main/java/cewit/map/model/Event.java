package cewit.map.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Event")
public class Event {
    @Id
    private String title;
    private String hostname;
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    private String room;
    private String track;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }



    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
