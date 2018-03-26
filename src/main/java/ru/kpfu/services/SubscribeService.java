package ru.kpfu.services;

import org.springframework.security.core.Authentication;
import ru.kpfu.models.Subscribe;

import java.util.List;

/**
 * 24.02.2018
 *
 * @author Robert Bagramov.
 */
public interface SubscribeService {
    void subscribeToUser(Subscribe subscribe);

    void unsubscribeFromUser(Subscribe subscribe);

    List<Subscribe> findSubscribesIdsByUserId(Authentication authentication);
}
