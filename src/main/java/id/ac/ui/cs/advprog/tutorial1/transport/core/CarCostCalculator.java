package id.ac.ui.cs.advprog.tutorial1.transport.core;


import id.ac.ui.cs.advprog.tutorial1.transport.exceptions.InvalidDistanceException;

public class CarCostCalculator implements TransportCostCalculator {
    @Override
    public Cost getCosts(Double distanceInKm) {
        // TODO: implement method
        // Melakukan pengecekan jarak sesuai kalkulasi transportasi 0 <= jarak <= 25 km
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
    public Double getTransportTimeInHour(Double distanceInKm) {
        // CASE 1: Saat di bawah atau sama dengan 2 km tarif 10000
        Double fare;
        if (distanceInKm <= 2) {
            fare = Double.valueOf(10000);
            return fare;
        }
        // CASE 2: Saat lebih dari 2 km cost 3500 / km
        fare = Double.valueOf(10000+(3500*distanceInKm-2));
        return fare;
    }

    @Override
    public Double getTransportFare(Double distanceInKm) {
        // Kecepatan perjalanan motor adalah 30 km/jam
        // Waktu = Jarak / Kecepatan
        Double time = Double.valueOf(distanceInKm/30);
        return time;
    }

    @Override
    public Integer getTransportSatisfaction(Double distanceInKm) {
        // Inisial satisfaction adalah 10
        // KM cost -1 / 5 km
        Integer satisfaction = 10;
        int minPoint = (int) Math.floor(distanceInKm/5);
        satisfaction = satisfaction - Integer.valueOf(minPoint);
        return satisfaction;
    }

    private void assertWithinDistanceLimit(Double distanceInKm){
        // Implement method, throws InvalidDistanceException if requirements are not met
        if (distanceInKm < 0 || distanceInKm > 50) {
            throw new InvalidDistanceException();
        }
    }
}
