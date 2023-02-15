package id.ac.ui.cs.advprog.tutorial1.newsletter.core;

import java.util.ArrayList;
import java.util.List;

public class User implements Subscriber {
    private final String name;
    private final List<String> news = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void handleNotification(String from) {
        // Menambahkan notifikasi ke news
        String notification = "Mendapatkan notifikasi baru dari "+from+"!";
        news.add(notification);
    }

    public String getName() {
        return name;
    }

    public List<String> getNews() {
        return new ArrayList<>(news);
    }
}
