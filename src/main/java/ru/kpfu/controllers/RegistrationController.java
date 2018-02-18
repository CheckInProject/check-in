package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.models.Post;
import ru.kpfu.models.User;
import ru.kpfu.services.RegistrationService;
import ru.kpfu.services.RoleService;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * 17.02.2018
 *
 * @author Robert Bagramov.
 */
@RestController
@RequestMapping("/api")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseStatus(CREATED)
    public void createUser(@RequestParam("fullname") String fullname,
                           @RequestParam("login") String login,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password) {

        registrationService.create(
                User.builder()
                        .fullName(fullname)
                        .login(login)
                        .email(email)
                        .build(),
                password
        );
    }

}