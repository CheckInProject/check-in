package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.models.User;
import ru.kpfu.models.response.UserTransferDto;
import ru.kpfu.services.RegistrationService;
import ru.kpfu.services.UserService;
import ru.kpfu.util.TokenUtil;

import java.util.ArrayList;
import java.util.List;

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
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService customUserDetailsService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseStatus(CREATED)
    public ResponseEntity<UserTransferDto> createUser(@RequestParam("fullname") String fullname,
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

        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password);
            Authentication authentication = this.authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(login);

            List<String> roles = new ArrayList<>();

            for (GrantedAuthority authority : userDetails.getAuthorities()) {
                roles.add(authority.toString());
            }

            User user = userService.findByUsernameOrEmail(userDetails.getUsername());

            return new ResponseEntity<UserTransferDto>(UserTransferDto
                    .builder()
                    .id(user.getId())
                    .roles(roles)
                    .username(user.getLogin())
                    .token(TokenUtil.createToken(userDetails))
                    .status(HttpStatus.OK)
                    .build(), HttpStatus.OK);

        } catch (BadCredentialsException bce) {
            return new ResponseEntity<UserTransferDto>(new UserTransferDto(), HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}