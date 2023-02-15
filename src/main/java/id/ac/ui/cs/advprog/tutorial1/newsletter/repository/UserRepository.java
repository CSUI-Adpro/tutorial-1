package id.ac.ui.cs.advprog.tutorial1.newsletter.repository;

import id.ac.ui.cs.advprog.tutorial1.newsletter.core.User;

import java.util.List;

public interface UserRepository {

    void addUser(String name, User user);
    List<User> getAll();
    User findByName(String name);

}
