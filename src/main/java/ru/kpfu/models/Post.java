package ru.kpfu.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
@Entity
@Table(name = "post")
@Data
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

    @ManyToOne()
    @JoinColumn(name = "creator_id")
    private User user;

}
