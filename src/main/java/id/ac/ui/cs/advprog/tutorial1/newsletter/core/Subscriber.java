package id.ac.ui.cs.advprog.tutorial1.newsletter.core;

public interface Subscriber {
    void handleNotification(String from);
    String getName();
}
