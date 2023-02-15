package id.ac.ui.cs.advprog.tutorial1.transport.controller;
import id.ac.ui.cs.advprog.tutorial1.transport.core.Cost;
import id.ac.ui.cs.advprog.tutorial1.transport.service.TransportationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = TransportController.class)
class TransportControllerTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    @MockBean
    private TransportationService transportationService;

    private Cost retCost;

    @BeforeEach
    public void setUp(){
        retCost = new Cost(0.0, 0.0, 0);
    }

    @Test
    void testWhenHomeCalledWithoutInputtingParameterReturn200() throws Exception{

        mockMvc.perform(get("/transport"))
                .andExpect(model().attribute("locationNames", hasSize(4)))
                .andExpect(model().attribute("transportTypes", hasSize(3)))
                .andExpect(status().isOk());
    }

    @Test
    void testWhenCalculateServiceCalledShouldReturnRightPrice() throws Exception{

        when(transportationService.calculateCost("Mock Location", "Mock Type")).thenReturn(retCost);

        mockMvc.perform(post("/transport/calculate-cost")
                        .param("location", "Mock Location")
                        .param("transportType", "Mock Type"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("locationNames", hasSize(4)))
                .andExpect(model().attribute("transportTypes", hasSize(3)));
    }

}
