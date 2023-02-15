package id.ac.ui.cs.advprog.tutorial1.transport.core;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cost {
    // don't modify the code
    Double fare;
    Double timeEstimationInHour;
    Integer satisfaction;
}
