package id.ac.ui.cs.advprog.tutorial1.newsletter.service;

import id.ac.ui.cs.advprog.tutorial1.newsletter.core.Newsletter;
import id.ac.ui.cs.advprog.tutorial1.newsletter.core.User;
import id.ac.ui.cs.advprog.tutorial1.newsletter.repository.NewsletterRepository;
import id.ac.ui.cs.advprog.tutorial1.newsletter.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NewsServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private NewsletterRepository newsletterRepository;

    @InjectMocks
    NewsServiceImpl newsService;

    @Test
    public void testGetAllUsers() throws Exception {
        when(userRepository.getAll()).thenReturn(new ArrayList<>());
        List<User> users = newsService.getAllUsers();
        assertEquals(0, users.size());
    }

    @Test
    public void testGetAllNewsletters() throws Exception {
        when(newsletterRepository.getAll()).thenReturn(new ArrayList<>());
        List<Newsletter> newsletters = newsService.getAllNewsletters();
        assertEquals(0, newsletters.size());
    }

    @Test
    public void testGetAllUsersName() throws Exception {
        when(userRepository.getAll()).thenReturn(List.of(new User("Alice")));
        List<String> usersName = newsService.getAllUsersName();
        assertArrayEquals(usersName.toArray(), List.of("Alice").toArray());
    }

    @Test
    public void testGetAllNewslettersName() throws Exception {
        when(newsletterRepository.getAll()).thenReturn(List.of(new Newsletter("GameStart")));
        List<String> newslettersName = newsService.getAllNewslettersName();
        assertArrayEquals(newslettersName.toArray(), List.of("GameStart").toArray());
    }
}