package com.introidx.caching_experimental;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Cacheable(value = "test", key = "#id")
    public Optional<User> readUserById(int id) {
        return userRepository.getUserById(id);
    }

    @CachePut(value = "test", key = "#user.id")
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    @CacheEvict(value = "test", key = "#id")
    public void removeUserById(int id) {
        userRepository.removeUserById(id);
    }
}
