package com.itsarraisi.springsecuritymysql.dao;

import com.itsarraisi.springsecuritymysql.entity.User;
import com.itsarraisi.springsecuritymysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    UserRepository repository;

    public Optional<User> findById(Integer id){
        return repository.findById(id);
    }

    public User save(User param) {
        return repository.save(param);
    }
}
