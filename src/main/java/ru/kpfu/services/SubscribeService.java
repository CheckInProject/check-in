package ru.kpfu.services;

/**
 * 24.02.2018
 *
 * @author Robert Bagramov.
 */
public interface SubscribeService {
    void subscribeToUser(int userId, int subscriptionId);

    void unsubscribeFromUser(int userId, int subscriptionId);
}
