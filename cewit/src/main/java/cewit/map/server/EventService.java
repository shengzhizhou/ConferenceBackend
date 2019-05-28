package cewit.map.server;


import cewit.map.model.Event;
import cewit.map.model.User;
import cewit.map.repository.EventRepository;
import cewit.map.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Iterable<Event> findAll(){
        return eventRepository.findAll();
    }
    public void delete(Event event){eventRepository.deleteById(event.getTitle());}
    public Event create(Event event){return eventRepository.save(event);}

}
