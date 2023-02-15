package id.ac.ui.cs.advprog.tutorial1.transport.controller;

import id.ac.ui.cs.advprog.tutorial1.transport.core.Cost;
import id.ac.ui.cs.advprog.tutorial1.transport.core.Transportation;
import id.ac.ui.cs.advprog.tutorial1.transport.service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path = "/transport")
public class TransportController {
    // don't modify the code
    final TransportationService transportationService;
    List<String> locationNames = Arrays.asList("Johor","Surabaya","Depok","Puncak");
    List<String> transportTypes = Transportation.getNames();

    @Autowired
    public TransportController(TransportationService transportationService) {
        this.transportationService = transportationService;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public String transportHome(Model model) {
        model.addAttribute("isInvalidRange", false);
        model.addAttribute("locationNames",locationNames);
        model.addAttribute("transportTypes",transportTypes);
        return "transport/home";
    }
    @RequestMapping(path = "/calculate-cost", method = RequestMethod.POST)
    public String changeLocationAndTransport(Model model,
                                             @RequestParam(value = "location", required = true) String locationName,
                                             @RequestParam(value = "transportType", required = true) String transportType ) {
        Cost costResults = transportationService.calculateCost(locationName, transportType);
        model.addAttribute("isInvalidRange", costResults == null);
        model.addAttribute("costResults", costResults);
        model.addAttribute("locationNames",locationNames);
        model.addAttribute("transportTypes",transportTypes);
        return "transport/home";
    }


}
