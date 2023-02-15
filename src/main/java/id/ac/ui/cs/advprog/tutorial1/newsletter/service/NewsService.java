package id.ac.ui.cs.advprog.tutorial1.newsletter.service;

import id.ac.ui.cs.advprog.tutorial1.newsletter.core.Newsletter;
import id.ac.ui.cs.advprog.tutorial1.newsletter.core.User;

import java.util.List;
import java.util.Map;

public interface NewsService {
    List<User> getAllUsers();
    List<Newsletter> getAllNewsletters();
    List<String> getAllUsersName();
    List<String> getAllNewslettersName();
    Map<String, List<String>> getNewsFromAllUsers();
    Map<String, List<String>> getSubscribersFromAllNewsletter();
    void handleNewBroadcast(String newsletterName);
    void handleSubscribe(String userName, String newsletterName);
    void handleUnsubscribe(String userName, String newsletterName);
}
