package id.ac.ui.cs.advprog.tutorial1.transport.core;



public class CarCostCalculator implements TransportCostCalculator {
    @Override
    public Cost getCosts(Double distanceInKm) {
        // TODO: implement method

        return null;
    }
    
    @Override
    public Double getTransportTimeInHour(Double distanceInKm) {
        // TODO: implement method
        return -1.0;
    }

    @Override
    public Double getTransportFare(Double distanceInKm) {
        // TODO: implement method
        return -1.0;
    }

    @Override
    public Integer getTransportSatisfaction(Double distanceInKm) {
        // TODO: implement method
        return -1;
    }

    private void assertWithinDistanceLimit(Double distanceInKm){
        // TODO: implement method, throws InvalidDistanceException if requirements are not met
    }
}
