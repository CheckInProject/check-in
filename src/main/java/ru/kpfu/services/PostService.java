package ru.kpfu.services;

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

    void deletePostByIdAndUserId(int postId, Authentication authentication);

    void createPostByUserId(Post post);
}
