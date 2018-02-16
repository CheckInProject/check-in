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
@Table(name = "subscribe")
@Data
@Builder
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "subscription_id")
    private int subscriptionId;

    @Column(name = "subscribed_user_id")
    private int subscribedUserId;
}
