package com.validate_form.service;

import com.validate_form.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save (User user);
}
