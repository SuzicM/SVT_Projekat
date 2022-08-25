package redditclone.service;

import java.util.List;
import redditclone.model.dto.CreateUserDTO;
import redditclone.model.dto.UpdateUserDTO;
import redditclone.model.entity.User;

public interface UserService {

    List<User> findAllUsers();

    User createUser(CreateUserDTO userDTO);

    User findUserById(long id);

    User findByUsername(String username);

    User changePassword(String newPassword, String username);

    Boolean oldPasswordVerification(String oldPassword, String username);

    User updateUser(UpdateUserDTO updateUserDTO, String username);

    User findUserByUsername(String username);
}
