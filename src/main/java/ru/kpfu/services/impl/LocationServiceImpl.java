package ru.kpfu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.models.Location;
import ru.kpfu.repositories.LocationRepository;
import ru.kpfu.services.LocationService;

/**
 * 19.03.2018
 *
 * @author Robert Bagramov.
 */
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location findById(int id) {
        return locationRepository.findById(id);
    }
}
