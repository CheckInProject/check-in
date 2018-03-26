package ru.kpfu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.kpfu.models.Subscribe;
import ru.kpfu.repositories.SubscribeRepository;
import ru.kpfu.services.SubscribeService;

import java.util.List;

/**
 * 24.02.2018
 *
 * @author Robert Bagramov.
 */
@Service
public class SubscriptionServiceImpl implements SubscribeService {
    @Autowired
    SubscribeRepository subscribeRepository;

    @Override
    public void subscribeToUser(Subscribe subscribe) {
        subscribeRepository.save(subscribe);
    }

    @Override
    public void unsubscribeFromUser(Subscribe subscribe) {
        subscribeRepository.delete(subscribe);
    }

    @Override
    public List<Subscribe> findSubscribesIdsByUserId(Authentication authentication) {
        return null;
    }
}
