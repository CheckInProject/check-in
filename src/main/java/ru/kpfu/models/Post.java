package ru.kpfu.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
@Entity
@Table(name = "post")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int id;

    @Column(name = "avatar_link")
    private String avatarName;

    @Column
    private String coordinates;

    @Column
    private String description;

    @Column
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User user;

}
