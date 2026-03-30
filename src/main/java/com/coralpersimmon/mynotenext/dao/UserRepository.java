package com.coralpersimmon.mynotenext.dao;

import com.coralpersimmon.mynotenext.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
