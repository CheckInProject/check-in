package ru.kpfu.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserTransferDto {
    private int id;
    private String username;
    private List<String> roles;
    private String token;
    private HttpStatus status;

    public UserTransferDto() {
        this.token = "";
        this.username = "";
        this.roles = Collections.emptyList();
        this.status = HttpStatus.NOT_FOUND;
    }
}
