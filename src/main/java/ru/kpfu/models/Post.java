package ru.kpfu.models;

import lombok.*;
import org.hibernate.annotations.GenerationTime;

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

    @Column
    private String avatar;

    @Column
    private double longitude;

    @Column
    private double latitude;

    @Column
    private String description;

    @Column(columnDefinition = "timestamp default current_timestamp")
    @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User user;

}
