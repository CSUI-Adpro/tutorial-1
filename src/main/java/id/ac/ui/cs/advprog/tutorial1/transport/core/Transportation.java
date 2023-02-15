package id.ac.ui.cs.advprog.tutorial1.transport.core;

import java.util.ArrayList;
import java.util.List;

public enum Transportation {
    // don't modify the code
    Motorcycle, Car, Airplane;
    
    public static List<String> getNames(){
        var ret = new ArrayList<String>();
        for (Transportation transportation: Transportation.values()) {
            ret.add(transportation.name());
        }
        return ret;
    }
}
