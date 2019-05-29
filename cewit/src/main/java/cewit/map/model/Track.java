package cewit.map.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Track {
    private String trackName;
    private List<Event> eventList;

    public Track(String trackName, List<Event> eventList){
        this.trackName=trackName;
        this.eventList=eventList;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }


}
