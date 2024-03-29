package com.Przemek.sflibrary.services.map;

import com.Przemek.sflibrary.model.User;
import com.Przemek.sflibrary.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserMapService extends MapService<User, Long> implements UserService {


    @Profile("default")
    @Override
    public User findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(user -> user.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);

    }


    @Override
    public User findByDocumentNumber(String documentNumber) {
        return this.findByDocumentNumber(documentNumber);

    }

    @Override
    public List<User> findAllByLastName(String lastName) {
        //TODO -impl
        return null;
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
