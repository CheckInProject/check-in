package ru.kpfu.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
@Entity
@Table(name = "`user`")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;
}
