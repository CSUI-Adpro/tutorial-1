package id.ac.ui.cs.advprog.tutorial1.transport.service;

import id.ac.ui.cs.advprog.tutorial1.transport.core.*;
import id.ac.ui.cs.advprog.tutorial1.transport.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportationServiceImpl implements TransportationService{

    final LocationRepository locationRepository;
    TransportCostCalculator transportStrategy;

    @Autowired
    public TransportationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Cost calculateCost(String locationName, String transportationTypeName) {
        // Returns either Cost or null
        // CHECK 1 : Cek LocationName dan mendapatkan jarak
        Location location = this.locationRepository.findByName(locationName);
        if (location == null) {
            return null;
        }
        // Memasangkan transportation strategy
        Double distance = location.getDistance();
        Cost cost;
        // CHECK 2 : Cek Transportation TypeName lalu menghitung cost berdasarkan jarak
        if (transportationTypeName.equals("Motorcycle")) {
            // Motorcycle
            transportStrategy = new MotorCostCalculator();
            cost = transportStrategy.getCosts(distance);
        } else if (transportationTypeName.equals("Car")) {
            // Car
            transportStrategy = new CarCostCalculator();
            cost = transportStrategy.getCosts(distance);
        } else {
            // Airplane
            transportStrategy = new AirplaneCostCalculator();
            cost = transportStrategy.getCosts(distance);
        }
        return cost;
    }
}
