package id.ac.ui.cs.advprog.tutorial1.transport.service;

import id.ac.ui.cs.advprog.tutorial1.transport.core.Cost;

public interface TransportationService {
    Cost calculateCost(String locationName, String transportationType);
}
