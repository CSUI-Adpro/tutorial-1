package id.ac.ui.cs.advprog.tutorial1.newsletter.core;

public interface Publisher {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscriber();
}
