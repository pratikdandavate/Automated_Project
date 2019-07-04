package com.app.spring.dao;

import com.app.spring.model.User;

public interface UserDetailsDao {
  User findUserByUsername(String username);
}
