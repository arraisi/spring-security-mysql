package com.itsarraisi.springsecuritymysql.service;

import com.itsarraisi.springsecuritymysql.dao.UserDao;
import com.itsarraisi.springsecuritymysql.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDao dao;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<User> findById(Integer id){
        return dao.findById(id);
    };

    public User save(User param) {
        String passwordEncoded = passwordEncoder.encode(param.getPassword());
        param.setPassword(passwordEncoded);
        param.setMatchingPassword(passwordEncoded);
        param.setActive(true);
        return dao.save(param);
    }
}
