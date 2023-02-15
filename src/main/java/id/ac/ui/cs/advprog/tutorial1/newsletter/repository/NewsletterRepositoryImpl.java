package id.ac.ui.cs.advprog.tutorial1.newsletter.repository;

import id.ac.ui.cs.advprog.tutorial1.newsletter.core.Newsletter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NewsletterRepositoryImpl implements NewsletterRepository {

    private final Map<String, Newsletter> newsletters = new HashMap<>();

    @Override
    public void addNewsletter(String name, Newsletter newsletter) {
        newsletters.put(name, newsletter);
    }

    @Override
    public List<Newsletter> getAll() {
        return new ArrayList<>(newsletters.values());
    }

    @Override
    public Newsletter findByName(String name) {
        return newsletters.get(name);
    }

}
