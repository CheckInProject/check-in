package ru.kpfu.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "role")
@Entity
public class Role implements GrantedAuthority {
    public static final GrantedAuthority REGISTERED_USER = new SimpleGrantedAuthority("REGISTERED_USER");
    public static final GrantedAuthority MODERATOR = new SimpleGrantedAuthority("MODERATOR");
    public static final GrantedAuthority ADMIN = new SimpleGrantedAuthority("ADMIN");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(nullable = false)
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
