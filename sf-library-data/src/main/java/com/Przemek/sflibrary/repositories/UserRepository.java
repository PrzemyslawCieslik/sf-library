package com.Przemek.sflibrary.repositories;

import com.Przemek.sflibrary.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLastName(String lastName);

    User findByDocumentNumber(String documentNumber);

}
