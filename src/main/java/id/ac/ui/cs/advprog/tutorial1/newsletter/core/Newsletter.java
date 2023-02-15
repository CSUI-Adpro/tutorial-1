package id.ac.ui.cs.advprog.tutorial1.newsletter.core;

import java.util.ArrayList;
import java.util.List;

public class Newsletter implements Publisher {
    private final String name;
    private final List<Subscriber> subscribers = new ArrayList<>();

    public Newsletter(String name) {
        this.name = name;
    }

    public void addSubscriber(Subscriber subscriber) {
        // Menambahkan subscriber
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        // Menghapus subscriber dari newsletter
        subscribers.remove(subscriber);
    }
    public void notifySubscriber() {
        // Memberi notifikasi ke subscribers
        for (Subscriber s : subscribers) {
            s.handleNotification(name);
        }
    }

    public String getName() {
        return name;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}
