package com.projekat.SR19.service;

import com.projekat.SR19.model.dto.UserDto;
import com.projekat.SR19.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User get(Long id);
    User update(User user);
    Boolean delete(Long id);
    User registerNewUser(UserDto userDto);
}
