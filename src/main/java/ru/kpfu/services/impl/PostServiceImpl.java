package ru.kpfu.services.impl;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import ru.kpfu.models.Post;
import ru.kpfu.models.Subscribe;
import ru.kpfu.repositories.PostRepository;
import ru.kpfu.repositories.SubscribeRepository;
import ru.kpfu.repositories.UserRepository;
import ru.kpfu.services.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 19.02.2018
 *
 * @author Robert Bagramov.
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    SubscribeRepository subscribeRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Post> findPostsByUserId(Authentication authentication, int offset, int limit) {
        User userDetails = (User) authentication.getPrincipal();
        String username = userDetails.getUsername();

        List<Integer> usersIds = new ArrayList<>();
        int userId = userRepository.findByUsernameOrEmail(username).getId();
        usersIds.add(userId);

        usersIds.addAll(subscribeRepository.findSubscribesIdsByUserId(userId)
                .stream()
                .map(Subscribe::getSubscriptionId)
                .collect(Collectors.toList()));
        List<Post> posts = new ArrayList<>();
        posts.addAll(postRepository.findPostsByUserId(usersIds, offset, limit));
        return posts;
    }

    @Override
    public void removePost(Authentication authentication, int postId) throws ObjectNotFoundException {
        User userDetails = (User) authentication.getPrincipal();
        String username = userDetails.getUsername();
        try {
            ru.kpfu.models.User user = userRepository.findByUsernameOrEmail(username);
            int userId = user.getId();
            postRepository.removePostByUserAndId(userId, postId);
        } catch (Exception e) {
            throw new ObjectNotFoundException("Пост не найден.");
        }

    }

    @Override
    public void createPostByUserId(Post post) {
        postRepository.save(post);
    }
}
