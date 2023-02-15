package id.ac.ui.cs.advprog.tutorial1.transport.repository;

import id.ac.ui.cs.advprog.tutorial1.transport.core.Location;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LocationRepository {
    // don't modify the code
    final Map<String, Location> locationMap ;

    public LocationRepository() {
        locationMap = new HashMap<>();
    }

    public void addLocation(Location location) {
        locationMap.put(location.getName(), location);
    }

    public Location findByName(String name) {
        return locationMap.get(name);
    }


}
