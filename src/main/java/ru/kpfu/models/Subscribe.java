package ru.kpfu.models;

import lombok.*;

import javax.persistence.*;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
@Entity
@Table(name = "subscribe")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "subscribed_user_id")
    private int subscribedUserId;

    @Column(name = "subscription_id")
    private int subscriptionId;
}
