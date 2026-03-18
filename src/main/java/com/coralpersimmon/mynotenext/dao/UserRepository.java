package com.coralpersimmon.mynotenext.dao;

import com.coralpersimmon.mynotenext.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
