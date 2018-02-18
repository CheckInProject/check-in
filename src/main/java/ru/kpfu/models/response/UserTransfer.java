package ru.kpfu.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserTransfer {
    private String username;
    private List<String> roles;
    private String token;
    private HttpStatus status;

    public UserTransfer() {
        this.token = "";
        this.username = "";
        this.roles = Collections.emptyList();
        this.status = HttpStatus.NOT_FOUND;
    }

}
