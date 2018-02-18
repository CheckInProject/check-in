package ru.kpfu.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.models.Subscribe;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
public interface SubscribeRepository extends CrudRepository<Subscribe, Integer> {
}
