package ru.kpfu.services;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.security.core.Authentication;
import ru.kpfu.models.Post;

import java.util.List;

/**
 * 19.02.2018
 *
 * @author Robert Bagramov.
 */
public interface PostService {

    List<Post> findPostsByUserId(Authentication authentication, int offset, int limit);

    void removePost(Authentication authentication, int postId) throws ObjectNotFoundException;

    void createPostByUserId(Post post);
}
