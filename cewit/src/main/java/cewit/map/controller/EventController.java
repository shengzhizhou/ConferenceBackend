package cewit.map.controller;
import cewit.map.model.Event;
import cewit.map.model.User;
import cewit.map.server.EventService;
import cewit.map.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/homepage")
@CrossOrigin
public class EventController {
    @Autowired
    private EventService eventService;
    @PostMapping(value = "/loadAllEvent")//check the user exist in the database or not
    public ResponseEntity<?> findAllUsers() {
        Iterable<Event> events = eventService.findAll();
        List<Event> eventList  = new ArrayList<>();
        for(Event event: events){
            eventList.add(event);
        }
        return new ResponseEntity<List<Event>>(eventList, HttpStatus.OK);
    }
}
