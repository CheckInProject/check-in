package ru.kpfu.controllers;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.models.Post;
import ru.kpfu.services.PostService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * 19.02.2018
 *
 * @author Robert Bagramov.
 */
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('REGISTERED_USER')")
    @ResponseStatus(OK)
    public List<Post> loadPostsByUser(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return postService.findPostsByUserId(authentication, offset, limit);
    }

    @RequestMapping(value = "/post/delete", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('REGISTERED_USER')")
    @ResponseStatus(OK)
    public ResponseEntity<Object> deleteUserPost(@RequestParam("postId") int postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            postService.removePost(authentication, postId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('REGISTERED_USER')")
    @ResponseStatus(CREATED)
    public void createUserPost(@RequestBody Post post) {
        postService.createPostByUserId(post);
    }
}
