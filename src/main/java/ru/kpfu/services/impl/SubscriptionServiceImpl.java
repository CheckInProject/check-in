package ru.kpfu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.repositories.SubscribeRepository;
import ru.kpfu.services.SubscribeService;

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
    public void subscribeToUser(int userId, int subscriptionId) {

        subscribeRepository.save(userId, subscriptionId);
    }

    @Override
    public void unsubscribeFromUser(int userId, int subscriptionId) {
        subscribeRepository.delete(userId, subscriptionId);
    }
}
