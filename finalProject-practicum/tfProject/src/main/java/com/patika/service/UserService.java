package com.patika.service;

import com.patika.entity.product;
import com.patika.entity.user;
import com.patika.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public user addUser(user user){
        return userRepository.save(user);
    }

    @Override
    public product getExpiredProducts() {
        return null;
    }

    @Override
    public product getFreshProducts() {
        return null;
    }
}
