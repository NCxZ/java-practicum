package com.patika.service;

import com.patika.entity.product;
import com.patika.entity.user;

public interface IUserService {
    user addUser(user user);
    product getExpiredProducts();
    product getFreshProducts(); // includes null date

}
