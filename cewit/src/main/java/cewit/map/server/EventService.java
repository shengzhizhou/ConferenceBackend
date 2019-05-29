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

    public Optional<Event> findById(String title) {
        return eventRepository.findById(title);
    }

    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    public void delete(Event event) {
        eventRepository.deleteById(event.getTitle());
    }

    public Event add(Event event) {
        return eventRepository.save(event);
    }

    public boolean isValidEvent(Event event) {
        Optional<Event> opt = eventRepository.findById(event.getTitle());
        if (!opt.isPresent()) {//check if the account exist
            return false;
        }
        return true;
    }
}
