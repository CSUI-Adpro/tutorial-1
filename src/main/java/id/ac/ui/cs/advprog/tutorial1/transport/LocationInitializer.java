package id.ac.ui.cs.advprog.tutorial1.transport;

import id.ac.ui.cs.advprog.tutorial1.transport.core.Location;
import id.ac.ui.cs.advprog.tutorial1.transport.repository.LocationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationInitializer {
    // don't modify the code
    final LocationRepository locationRepository;

    @Autowired
    public LocationInitializer(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @PostConstruct
    public void init() {
        locationRepository.addLocation(new Location("Johor", 2560.0));
        locationRepository.addLocation(new Location("Surabaya", 1200.0));
        locationRepository.addLocation(new Location("Puncak", 40.0));
        locationRepository.addLocation(new Location("Depok", 10.0));
    }

}
