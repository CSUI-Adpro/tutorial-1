package id.ac.ui.cs.advprog.tutorial1.newsletter.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    public void setUp() throws Exception {
        user = new User("Alice");
    }

    @Test
    void testHandleNotification() throws Exception {
        user.handleNotification("GameStart");
        user.handleNotification("Koped Travel");
        user.handleNotification("BI Sports");
        assertArrayEquals(user.getNews().toArray(),
                Arrays.asList("Mendapatkan notifikasi tentang rilisnya game dari GameStart",
                        "Mendapatkan notifikasi tentang tempat wisata dari Koped Travel",
                        "Mendapatkan notifikasi tentang hasil pertandingan dari BI Sports")
                        .toArray()
        );
    }

}