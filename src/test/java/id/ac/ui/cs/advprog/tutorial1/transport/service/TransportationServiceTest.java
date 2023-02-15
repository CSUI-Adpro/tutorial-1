package id.ac.ui.cs.advprog.tutorial1.transport.service;
import id.ac.ui.cs.advprog.tutorial1.transport.core.Cost;
import id.ac.ui.cs.advprog.tutorial1.transport.core.Location;
import id.ac.ui.cs.advprog.tutorial1.transport.core.Transportation;
import id.ac.ui.cs.advprog.tutorial1.transport.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportationServiceTest {

    LocationRepository mockLocationRepository;
    TransportationServiceImpl transportationService;


    static final double saharaDesertDistance = 3000.0;
    static final double bogorDistance= 49.0;
    static final double jakartaDistance = 24.0;

    @BeforeEach
    void setUp() {
        mockLocationRepository = new LocationRepository();
        mockLocationRepository.addLocation( new Location("Sahara Desert", saharaDesertDistance));
        mockLocationRepository.addLocation( new Location("Bogor", bogorDistance));
        mockLocationRepository.addLocation( new Location("Jakarta", jakartaDistance));
        transportationService = new TransportationServiceImpl(mockLocationRepository);
    }

    @Test
    void shouldReturnNullWhenMotorcycleGoesToSaharaDesert() {
        assertNull(
                transportationService.calculateCost(
                        "Sahara Desert",
                        Transportation.Motorcycle.name()
                )
        );
    }

    @Test
    void shouldReturnTheCostWhenMotorCycleGoesToJakarta() {
        var result = transportationService.calculateCost(
                "Jakarta",
                Transportation.Motorcycle.name()
        );

        var expected = new Cost(
                38000.0,
                0.6,
                9
        );

        assertEquals(result, expected);
    }

    @Test
    void shouldReturnNullWhenCarGoesToSaharaDesert() {
        assertNull(
                transportationService.calculateCost(
                        "Sahara Desert",
                        Transportation.Car.name()
                )
        );
    }


    @Test
    void shouldReturnTheCostWhenCarGoesToJakarta() {
        var result = transportationService.calculateCost(
                "Jakarta",
                Transportation.Car.name()
        );

        var expected = new Cost(
                87000.0,
                0.8,
                6
        );

        assertEquals(result, expected);
    }

    @Test
    void shouldReturnTheCostWhenAirplaneGoesToSaharaDesert() {
        var result = transportationService.calculateCost(
                "Sahara Desert",
                Transportation.Airplane.name()
        );

        var expected = new Cost(
                4550000.0,
                saharaDesertDistance/800,
                1
        );

        assertEquals(result, expected);
    }

    @Test
    void shouldReturnNullWhenAirplaneGoesToJakarta() {
        assertNull(
                transportationService.calculateCost(
                        "Jakarta",
                        Transportation.Airplane.name()
                )
        );
    }

}
