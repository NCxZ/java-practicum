package com.patika.repository;

import com.patika.entity.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<user, Integer> {

}
