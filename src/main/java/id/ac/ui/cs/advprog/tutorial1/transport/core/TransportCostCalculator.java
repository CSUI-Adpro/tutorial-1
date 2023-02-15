package id.ac.ui.cs.advprog.tutorial1.transport.core;


public interface TransportCostCalculator {
    Cost getCosts(Double distanceInKm);
    Double getTransportFare(Double distanceInKm);
    Double getTransportTimeInHour(Double distanceInKm);
    Integer getTransportSatisfaction(Double distanceInKm);
    
    
}
