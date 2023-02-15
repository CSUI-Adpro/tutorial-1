package id.ac.ui.cs.advprog.tutorial1.newsletter.repository;

import id.ac.ui.cs.advprog.tutorial1.newsletter.core.Newsletter;
import id.ac.ui.cs.advprog.tutorial1.newsletter.core.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Test
    void testWhenGetAllReturnsArray() throws Exception {
        userRepository.addUser("Alice", new User("Alice"));
        userRepository.addUser("Bob", new User("Bob"));

        assertEquals(2, userRepository.getAll().size());
    }

    @Test
    public void testWhenFindByNameCalledReturnTheNewsletterObject() throws Exception {
        userRepository.addUser("Alice", new User("Alice"));

        assertEquals("Alice", userRepository.findByName("Alice").getName());

    }
}