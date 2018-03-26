package ru.kpfu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * 19.03.2018
 *
 * @author Robert Bagramov.
 */
@Entity
@Table(name = "location")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int id;
    @Column
    private double latitude;
    @Column
    private double longitude;
    @Column
    private String address;

    @JsonIgnore
    @OneToOne(mappedBy = "location")
    private Post post;

}
