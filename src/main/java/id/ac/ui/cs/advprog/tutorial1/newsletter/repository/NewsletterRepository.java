package id.ac.ui.cs.advprog.tutorial1.newsletter.repository;

import id.ac.ui.cs.advprog.tutorial1.newsletter.core.Newsletter;

import java.util.List;

public interface NewsletterRepository {
    void addNewsletter(String name, Newsletter newsletter);
    List<Newsletter> getAll();
    Newsletter findByName(String name);
}
