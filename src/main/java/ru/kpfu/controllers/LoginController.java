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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.models.User;
import ru.kpfu.models.request.AuthenticationRequest;
import ru.kpfu.models.response.UserTransfer;
import ru.kpfu.services.UserService;
import ru.kpfu.util.TokenUtil;

import java.util.ArrayList;
import java.util.List;

import static ru.kpfu.models.Role.REGISTERED_USER;

/**
 * 18.02.2018
 *
 * @author Robert Bagramov.
 */
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService customUserDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = {RequestMethod.POST})
    public ResponseEntity<UserTransfer> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            String username = authenticationRequest.getUsername();
            String password = authenticationRequest.getPassword();

            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(REGISTERED_USER);

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,
                    password, authorities);
            Authentication authentication = this.authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);

            List<String> roles = new ArrayList<>();

            for (GrantedAuthority authority : userDetails.getAuthorities()) {
                roles.add(authority.toString());
            }

            User user = userService.findByUsernameOrEmail(userDetails.getUsername());

            return new ResponseEntity<UserTransfer>(UserTransfer
                    .builder()
                    .id(user.getId())
                    .roles(roles)
                    .username(user.getLogin())
                    .token(TokenUtil.createToken(userDetails))
                    .status(HttpStatus.OK)
                    .build(), HttpStatus.OK);

        } catch (BadCredentialsException bce) {
            return new ResponseEntity<UserTransfer>(new UserTransfer(), HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
}
