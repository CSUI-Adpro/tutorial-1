package id.ac.ui.cs.advprog.tutorial1.transport.core;


import id.ac.ui.cs.advprog.tutorial1.transport.exceptions.InvalidDistanceException;

public class AirplaneCostCalculator implements TransportCostCalculator {
    @Override
    public Cost getCosts(Double distanceInKm) {
        // Melakukan pengecekan jarak sesuai kalkulasi transportasi (tidak ada batasan)
        assertWithinDistanceLimit(distanceInKm);
        // Terdiri dari 3 komponen cost yaitu:
        // 1) Fare
        // 2) TimeInHour
        // 3) Satisfaction
        Double fare = getTransportFare(distanceInKm);
        Double timeInHour = getTransportTimeInHour(distanceInKm);
        Integer satisfaction = getTransportSatisfaction(distanceInKm);
        // Construct cost baru
        Cost cost = new Cost(fare, timeInHour, satisfaction);
        return cost;
    }
    
    @Override
    public Double getTransportFare(Double distanceInKm) {
        // CASE 1: Minimum fare adalah 500000 (300 km)
        Double fare = Double.valueOf(500000);
        if (distanceInKm <= 300) {
            return fare;
        }
        // CASE 2: Saat lebih dari 300 km cost 150000 / km
        distanceInKm -= 400;
        fare += Double.valueOf(150000 * Math.ceil((distanceInKm)/100) );
        return fare;
    }

    @Override
    public Double getTransportTimeInHour(Double distanceInKm) {
        // Kecepatan perjalanan motor adalah 800 km/jam
        // Waktu = Jarak / Kecepatan
        Double time = Double.valueOf(distanceInKm/800);
        return time;
    }

    @Override
    public Integer getTransportSatisfaction(Double distanceInKm) {
        // Inisial satisfaction adalah 10
        // KM cost -1 / 100 km
        Integer satisfaction = 10;
        int minPoint = (int) Math.floor(distanceInKm/100);
        satisfaction = satisfaction - Integer.valueOf(minPoint);
        // Handle minimal 1
        return satisfaction < 1 ? 1 : satisfaction;
    }
    
    private void assertWithinDistanceLimit(Double distanceInKm){
        // Implement method, throws InvalidDistanceException if requirements are not met
        if (distanceInKm < 0) {
            throw new InvalidDistanceException();
        }
    }
}
