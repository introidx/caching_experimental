package com.introidx.caching_experimental;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {


    public Optional<User> getUserById(int id) {
        System.out.println("Simulating a read from the main data store.");
        // In case the id doesn't exist in the cache it will "fetch" jimmy page with the requested id and add it to the cache (cache miss).
        return Optional.of(new User(id, "jimmy page", "jimmy@gmail.com", 77));
    }


    public User addUser(User user) {
        System.out.println("Simulating addition of " + user + " to the main data store.");
        return user;
    }

    public void removeUserById(int id) {
        System.out.println("Simulating removal of " + id + " from the main data store.");
    }
}
