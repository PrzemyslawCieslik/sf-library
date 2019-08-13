package com.Przemek.sflibrary.services.map;

import com.Przemek.sflibrary.model.User;
import com.Przemek.sflibrary.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class UserMapService extends MapService<User, Long> implements UserService {

    private final UserService userService;

    public UserMapService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public User findByLastName(String lastName) {
        //TODO Create logic and throw an exception
        return null;
    }

    @Override
    public List<User> findAllByLastName(String lastName) {
        //TODO Create logic and throw an exception
        return null;
    }

    @Override
    public User findByDocumentNumber(String documentNumber) {
        return this.findByDocumentNumber(documentNumber);
        //TODO Create logic and throw an exception
    }

    @Override
    public List<User> findByBirthDate(LocalDate birthDate) {
        return this.findByBirthDate(birthDate);
        //TODO Create logic and throw an exception
    }

    @Override
    public Set<User> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(User object) {
        super.delete(object);
    }

    @Override
    public User save(User object) {
        return super.save(object);
    }

    @Override
    public User findById(Long id) {
        return super.findById(id);
    }
}
