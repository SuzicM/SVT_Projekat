package redditclone.service;

import redditclone.model.dto.CreateUserDTO;
import redditclone.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User createUser(CreateUserDTO userDTO);

    User findUserById(long id);

    User findByUsername(String username);

}
