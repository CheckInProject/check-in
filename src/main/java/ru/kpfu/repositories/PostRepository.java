package ru.kpfu.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.models.Post;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
public interface PostRepository extends CrudRepository<Post, Integer> {
}
