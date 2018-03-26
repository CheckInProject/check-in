package ru.kpfu.services;

import ru.kpfu.models.Location;

/**
 * 19.03.2018
 *
 * @author Robert Bagramov.
 */

public interface LocationService {
    Location save(Location location);

    Location findById(int id);
}
