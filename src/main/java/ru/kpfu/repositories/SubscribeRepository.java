package ru.kpfu.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.models.Subscribe;

import java.util.List;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
public interface SubscribeRepository extends CrudRepository<Subscribe, Integer> {
    //language=SQL
    @Query(value = "SELECT* FROM subscribe s WHERE s.subscribed_user_id = :userId", nativeQuery = true)
    List<Subscribe> findSubscribesIdsByUserId(@Param("userId") int id);

    Subscribe save(Subscribe subscribe);

    void delete(Subscribe subscribe);
}
