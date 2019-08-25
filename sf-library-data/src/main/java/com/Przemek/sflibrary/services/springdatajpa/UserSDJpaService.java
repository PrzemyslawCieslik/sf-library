package com.Przemek.sflibrary.services.springdatajpa;

import com.Przemek.sflibrary.model.User;
import com.Przemek.sflibrary.repositories.UserRepository;
import com.Przemek.sflibrary.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class UserSDJpaService implements UserService {

    private final UserRepository userRepository;

    public UserSDJpaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public User findByDocumentNumber(String documentNumber) {
        return userRepository.findByDocumentNumber(documentNumber);
    }

    @Override
    public List<User> findAllByLastName(String lastName) {
        return userRepository.findAllByLastName(lastName);
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(Long aLong) {
        return userRepository.findById(aLong).orElse(null);
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }
}
