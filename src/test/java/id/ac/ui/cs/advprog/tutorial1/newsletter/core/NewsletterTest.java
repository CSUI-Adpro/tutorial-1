package id.ac.ui.cs.advprog.tutorial1.newsletter.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class NewsletterTest {

    private Newsletter newsletter;

    @BeforeEach
    public void setUp() throws Exception {
        newsletter = new Newsletter("BI Sports");
    }

    @Test
    void testAddRemoveSubscriber() throws Exception {
        User user = new User("Alice");
        newsletter.addSubscriber(user);
        assertEquals(1, newsletter.getSubscribers().size());
        newsletter.removeSubscriber(user);
        assertEquals(0, newsletter.getSubscribers().size());
    }

    @Test
    void testNotifySubscriber() throws Exception {
        User userMock = mock(User.class);
        newsletter.addSubscriber(userMock);
        newsletter.notifySubscriber();
        verify(userMock, atLeastOnce()).handleNotification(any());
    }

}