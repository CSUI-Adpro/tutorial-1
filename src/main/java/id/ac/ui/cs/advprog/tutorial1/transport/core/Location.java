package id.ac.ui.cs.advprog.tutorial1.transport.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    // don't modify the code
    private String name;
    private Double distance;

    public Location(String name, Double distance) {
        this.name = name;
        this.distance = distance;
    }
}
