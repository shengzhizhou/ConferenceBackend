package cewit.map.repository;

import cewit.map.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event,String> {
}
