package id.ac.ui.cs.advprog.tutorial1.transport.repository;

import id.ac.ui.cs.advprog.tutorial1.transport.core.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LocationRepositoryTest {
    private LocationRepository locationRepository;
    private Location mockLocation;

    @BeforeEach
    void setUp() {
        locationRepository = new LocationRepository();
        mockLocation = new Location("mock location",1000.0);
    }

    @Test
    void locationRepositoryShouldReturnLocationWhenFindByNameIsCalled() {
        locationRepository.addLocation(mockLocation);
        assertEquals(mockLocation,locationRepository.findByName("mock location"));
    }
}
