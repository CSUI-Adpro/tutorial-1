package id.ac.ui.cs.advprog.tutorial1.newsletter.repository;

import id.ac.ui.cs.advprog.tutorial1.newsletter.core.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void addUser(String name, User user) {
        users.put(name, user);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User findByName(String name) {
        return users.get(name);
    }
}
