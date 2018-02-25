package ru.kpfu.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.models.Post;

import java.util.List;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
public interface PostRepository extends CrudRepository<Post, Integer> {
    //language=SQL
    @Query(value = "SELECT* FROM post p WHERE p.creator_id IN (:usersIds) OFFSET :offset LIMIT :limit", nativeQuery = true)
    List<Post> findPostsByUserId(@Param("usersIds") List<Integer> usersIds, @Param("offset") int offset, @Param("limit") int limit);

    //language=SQL
    @Query(value = "DELETE FROM post p WHERE p.post_id = :postId AND p.creator_id = :userId", nativeQuery = true)
    void removePostByUserAndId(@Param("userId") int userId, @Param("postId") int id);

    Post save(Post post);
}
