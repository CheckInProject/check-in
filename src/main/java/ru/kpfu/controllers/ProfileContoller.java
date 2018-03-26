package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.models.User;
import ru.kpfu.services.ProfileService;

import java.util.List;

/**
 * 25.02.2018
 *
 * @author Robert Bagramov.
 */
@RestController
@RequestMapping("/api")
public class ProfileContoller {
    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('REGISTERED_USER')")
    public User me() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        return profileService.getMyProfile(authentication);
    }

    @RequestMapping(value = "/me", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('REGISTERED_USER')")
    public User updateProfile(User user) {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        return profileService.updateProfile(user, authentication);
    }

    @RequestMapping(value = "/subscribes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('REGISTERED_USER')")
    public List<User> subscribes() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        return profileService.getSubscribes(authentication);
    }
}
