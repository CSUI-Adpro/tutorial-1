package id.ac.ui.cs.advprog.tutorial1.transport.core;


import id.ac.ui.cs.advprog.tutorial1.transport.exceptions.InvalidDistanceException;

public class MotorCostCalculator implements TransportCostCalculator {
    @Override
    public Cost getCosts(Double distanceInKm) {
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
    public Double getTransportFare(Double distanceInKm) {
        // CASE 1: Saat di bawah atau sama dengan 2 km tarif 5000
        Double fare;
        if (distanceInKm <= 2) {
            fare = Double.valueOf(5000);
            return fare;
        }
        // CASE 2: Saat lebih dari 2 km cost 1500 / km
        distanceInKm -= 2;
        fare = Double.valueOf(5000+(1500*distanceInKm));
        return fare;
    }
    
    @Override
    public Double getTransportTimeInHour(Double distanceInKm) {
        // Kecepatan perjalanan motor adalah 40 km/jam
        // Waktu = Jarak / Kecepatan
        Double time = Double.valueOf(distanceInKm/40);
        return time;
    }
    
    @Override
    public Integer getTransportSatisfaction(Double distanceInKm) {
        // Inisial satisfaction adalah 10
        // KM 0-10 Satisfaction tetap 10
        // KM Selanjutnya -1 / 10 km
        Integer satisfaction = 10;
        if (distanceInKm <= 10) {
            satisfaction = Integer.valueOf(10);
        }
        int minPoint = (int) Math.floor(distanceInKm/10);
        satisfaction -= Integer.valueOf(minPoint);
        // Handle minimal 1
        return satisfaction < 1 ? 1 : satisfaction;
    }
    
    private void assertWithinDistanceLimit(Double distanceInKm){
        // Implement method, throws InvalidDistanceException if requirements are not met
        if (distanceInKm < 0 || distanceInKm > 25) {
            throw new InvalidDistanceException();
        }
    }
}
