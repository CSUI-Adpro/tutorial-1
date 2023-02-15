package id.ac.ui.cs.advprog.tutorial1.newsletter.controller;

import id.ac.ui.cs.advprog.tutorial1.newsletter.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.anEmptyMap;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = NewsletterController.class)
public class NewsletterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsService newsService;

    @Test
    public void testWhenHomeCalledWithoutInputtingParameterReturn200() throws Exception {
        mockMvc.perform(get("/newsletter"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("map", anEmptyMap()))
                .andExpect(model().attribute("newsletters", hasSize(0)));
    }

    @Test
    public void testWhenSubscribeCalledWithoutInputtingParameterReturn200() throws Exception {
        mockMvc.perform(get("/newsletter/subscribe"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("map", anEmptyMap()))
                .andExpect(model().attribute("newsletters", hasSize(0)))
                .andExpect(model().attribute("users", hasSize(0)));
    }

    @Test
    public void testWhenHandleSubscribeCalledReturnRedirect() throws Exception {
        mockMvc.perform(post("/newsletter/subscribe")
                        .param("subscribe", "Subscribe")
                        .param("userName", "Alice")
                        .param("newsletterName", "Koped Travel"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/newsletter/subscribe"));
    }

    @Test
    public void testWhenHandleUnsubscribeCalledReturnRedirect() throws Exception {
        mockMvc.perform(post("/newsletter/subscribe")
                        .param("unsubscribe", "Unsubscribe")
                        .param("userName", "Alice")
                        .param("newsletterName", "Koped Travel"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/newsletter/subscribe"));
    }

    @Test
    public void testWhenHandleNewNewsCalledReturnRedirect() throws Exception {
        mockMvc.perform(post("/newsletter")
                        .param("newsletterName", "Koped Travel"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/newsletter"));
    }


}