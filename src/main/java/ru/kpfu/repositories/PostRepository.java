package ru.kpfu.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.models.Post;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}
