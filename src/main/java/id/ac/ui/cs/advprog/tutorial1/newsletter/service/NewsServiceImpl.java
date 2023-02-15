package id.ac.ui.cs.advprog.tutorial1.newsletter.service;

import id.ac.ui.cs.advprog.tutorial1.newsletter.core.Newsletter;
import id.ac.ui.cs.advprog.tutorial1.newsletter.core.Subscriber;
import id.ac.ui.cs.advprog.tutorial1.newsletter.core.User;
import id.ac.ui.cs.advprog.tutorial1.newsletter.repository.NewsletterRepository;
import id.ac.ui.cs.advprog.tutorial1.newsletter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsletterRepository newsletterRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public List<Newsletter> getAllNewsletters() {
        return newsletterRepository.getAll();
    }

    @Override
    public List<String> getAllUsersName() {
        List<String> names = new ArrayList<>();
        for (User user : userRepository.getAll()) {
            names.add(user.getName());
        }
        return names;
    }
    @Override
    public List<String> getAllNewslettersName() {
        List<String> names = new ArrayList<>();
        for (Newsletter newsletter : newsletterRepository.getAll()) {
            names.add(newsletter.getName());
        }
        return names;
    }

    @Override
    public Map<String, List<String>> getNewsFromAllUsers() {
        Map<String, List<String>> newsByUsersName = new HashMap<>();

        for (User user : getAllUsers()) {
            newsByUsersName.put(user.getName(), user.getNews());
        }

        return newsByUsersName;
    }

    @Override
    public Map<String, List<String>> getSubscribersFromAllNewsletter() {
        Map<String, List<String>> subscribersNameByNewsletterName = new HashMap<>();

        for (Newsletter newsletter : getAllNewsletters()) {

            List<String> subscribersName = new ArrayList<>();
            for (Subscriber subscriber : newsletter.getSubscribers()) {
                subscribersName.add(subscriber.getName());
            }

            subscribersNameByNewsletterName.put(newsletter.getName(), subscribersName);
        }

        return subscribersNameByNewsletterName;
    }

    @Override
    public void handleNewBroadcast(String newsletterName) {
        // Menambahkan broadcast baru
        Newsletter newsletter = new Newsletter(newsletterName);
        newsletterRepository.addNewsletter(newsletterName, newsletter);
    }

    @Override
    public void handleSubscribe(String userName, String newsletterName) {
        // Mendapatkan user terkait
        User user = new User("User tidak ditemukan");
        for (User u : getAllUsers()) {
            if (u.getName().equals(userName)) {
                user = u;
            }
        }
        // Mendapatkan newsletter terkait
        Newsletter newsletter = new Newsletter("Newsletter tidak ditemukan")
        for (Newsletter n : getAllNewsletters()) {
            if (n.getName().equals(newsletterName)) {
                newsletter = n;
            }
        }
        // Melakukan subscribe user pada newsletter
        newsletter.addSubscriber(user);
    }

    @Override
    public void handleUnsubscribe(String userName, String newsletterName) {
        // Mendapatkan user terkait
        User user = new User("User tidak ditemukan");
        for (User u : getAllUsers()) {
            if (u.getName().equals(userName)) {
                user = u;
            }
        }
        // Mendapatkan newsletter terkait
        Newsletter newsletter = new Newsletter("Newsletter tidak ditemukan")
        for (Newsletter n : getAllNewsletters()) {
            if (n.getName().equals(newsletterName)) {
                newsletter = n;
            }
        }
        // Melakukan subscribe user pada newsletter
        newsletter.removeSubscriber(user);
    }

}
