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

    //language=SQL
    @Query(value = "INSERT INTO subscribe(subscribed_user_id, subscription_id) " +
            "VALUES (:userId, :subscriptionId)", nativeQuery = true)
    void save(@Param("userId") int userId, @Param("subscriptionId") int subscriptionId);

    //language=SQL
    @Query(value = "DELETE FROM subscribe s WHERE s.subscribed_user_id = :userId " +
            "AND s.subscription_id = :subscriptionId", nativeQuery = true)
    void delete(@Param("userId") int userId, @Param("subscriptionId") int subscriptionId);
}
