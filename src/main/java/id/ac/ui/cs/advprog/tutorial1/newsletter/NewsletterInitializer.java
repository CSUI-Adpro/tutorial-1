package id.ac.ui.cs.advprog.tutorial1.newsletter;

import id.ac.ui.cs.advprog.tutorial1.newsletter.core.Newsletter;
import id.ac.ui.cs.advprog.tutorial1.newsletter.core.User;
import id.ac.ui.cs.advprog.tutorial1.newsletter.repository.NewsletterRepository;
import id.ac.ui.cs.advprog.tutorial1.newsletter.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsletterInitializer {

    @Autowired
    UserRepository userRepository;
    @Autowired
    NewsletterRepository newsletterRepository;

    @PostConstruct
    public void init() {
        // initialize users
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        userRepository.addUser(alice.getName(), alice);
        userRepository.addUser(bob.getName(), bob);
        userRepository.addUser(charlie.getName(), charlie);

        // initialize newsletters
        Newsletter sport = new Newsletter("BI Sports");
        Newsletter travel = new Newsletter("Koped Travel");
        Newsletter game = new Newsletter("GameStart");

        newsletterRepository.addNewsletter(sport.getName(), sport);
        newsletterRepository.addNewsletter(travel.getName(), travel);
        newsletterRepository.addNewsletter(game.getName(), game);

    }
}
