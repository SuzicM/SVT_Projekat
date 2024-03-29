package redditclone.service.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import redditclone.model.dto.CreateUserDTO;
import redditclone.model.dto.UpdateUserDTO;
import redditclone.model.entity.Roles;
import redditclone.model.entity.User;
import redditclone.repository.UserRepository;
import redditclone.service.UserService;

@Service
public class UserServiceImplementaion implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(CreateUserDTO userDTO) {

        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setRegistration_date(LocalDate.now());
        user.setDescription("Description");
        user.setDisplay_name(userDTO.getUsername());
        user.setRole(Roles.USER);

        userRepository.save(user);

        return user;
    }

    public User updateUser(UpdateUserDTO updateUserDTO, String username) {

        User updatedUser = userRepository.findByUsername(username);

        if (updateUserDTO.getDescription() != null) {
            updatedUser.setDescription(updateUserDTO.getDescription());
        }

        if (updateUserDTO.getDisplay_name() != null) {
            updatedUser.setDisplay_name(updateUserDTO.getDisplay_name());
        }

        userRepository.updateUser(updatedUser.getDescription(), updatedUser.getDisplay_name(), updatedUser.getId());
        return updatedUser;
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User changePassword(String newPassword, String username) {
        User user = userRepository.findByUsername(username);
        System.out.println("NEW PASSWORD" + user.getPassword());
        user.setPassword(passwordEncoder.encode(newPassword));
        System.out.println("NEW PASSWORD" + user.getPassword());
        userRepository.changePassord(user.getPassword(), user.getId());
        return user;
    }

    @Override
    public Boolean oldPasswordVerification(String oldPassword, String username) {
        User user = userRepository.findByUsername(username);
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
