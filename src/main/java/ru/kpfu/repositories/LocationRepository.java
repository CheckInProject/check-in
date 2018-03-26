package ru.kpfu.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.models.Location;

import java.util.List;

/**
 * 19.03.2018
 *
 * @author Robert Bagramov.
 */
public interface LocationRepository extends CrudRepository<Location, Integer> {
    Location save(Location location);

    Location findById(int id);

    List<Location> findAllByIdIn(List<Integer> postsIds);
}
