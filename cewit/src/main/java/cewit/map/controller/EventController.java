package cewit.map.controller;
import cewit.map.model.Event;
import cewit.map.model.User;
import cewit.map.server.EventService;
import cewit.map.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/homepage")
@CrossOrigin
public class EventController {
    @Autowired
    private EventService eventService;
    @PostMapping(value = "/loadAllEvent")//check the user exist in the database or not
    public ResponseEntity<?> findAllEvent() {
        Iterable<Event> events = eventService.findAll();
        List<Event> eventList  = new ArrayList<>();
        for(Event event: events){
            eventList.add(event);
        }
        return new ResponseEntity<List<Event>>(eventList, HttpStatus.OK);
    }
    @PostMapping(value = "/addEvent")//check the user exist in the database or not
    public ResponseEntity<?> addEvent(@RequestBody Event event) {

        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(event.getEndtimes()+" "+event.getStarttimes());
        try {
            Date st = output.parse(event.getStarttimes());
            event.setStarttime(st);
            Date et = output.parse(event.getEndtimes());
            event.setEndtime(et);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        eventService.add(event);
        return new ResponseEntity<>("add successful", HttpStatus.OK);
    }

    @PostMapping(value = "/deleteEvent")//check the user exist in the database or not
    public ResponseEntity<?> deletedUsers(@RequestBody Event event) {
        eventService.isValidEvent(event);

        eventService.delete(event);
        return new ResponseEntity<>("finish deleted event", HttpStatus.OK);
    }
}
