package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.services.SubscribeService;

import static org.springframework.http.HttpStatus.OK;

/**
 * 24.02.2018
 *
 * @author Robert Bagramov.
 */
@RestController
@RequestMapping("/api")
public class SubscribeController {
    @Autowired
    SubscribeService subscribeService;

    @RequestMapping("/subscribe")
    @PreAuthorize("hasAuthority('REGISTERED_USER')")
    @ResponseStatus(OK)
    public void subscribeToUser(@RequestParam("userId") int userId,
                                @RequestParam("subscriptionId") int subscriptionId) {
        subscribeService.subscribeToUser(userId, subscriptionId);
    }

    @RequestMapping("/unsubscribe")
    @PreAuthorize("hasAuthority('REGISTERED_USER')")
    @ResponseStatus(OK)
    public void unsubscribeFromUser(@RequestParam("userId") int userId,
                                    @RequestParam("subscriptionId") int subscriptionId) {
        subscribeService.unsubscribeFromUser(userId, subscriptionId);
    }
}