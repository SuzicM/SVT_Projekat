package com.projekat.SR19.service.implementation;

import com.projekat.SR19.model.dto.UserDto;
import com.projekat.SR19.model.entity.User;
import com.projekat.SR19.model.entity.UserRole;
import com.projekat.SR19.repository.UserRepository;
import com.projekat.SR19.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override //getting one user
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override //update user
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override //delete user
    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public User registerNewUser(UserDto userDto) {
        User registeredUser = new User();
        registeredUser.setUserRole(UserRole.User);
        registeredUser.setUsername(userDto.getUsername());
        registeredUser.setPassword(userDto.getPassword());
        registeredUser.setEmail(userDto.getEmail());
        registeredUser.setAvatar(userDto.getAvatar());
        registeredUser.setDisplayName(userDto.getDisplayName());
        registeredUser.setDescription(userDto.getDescription());
        registeredUser.setRegistrationDate(LocalDateTime.now());

        return userRepository.save(registeredUser);
    }



   /* private String setUserImageUrl(){
        String[] imageName = {"default.png"};
        return ServletUriComponentsBuilder.fromContextPath().path("/user/image" + "default.png").toUriString();
    }*/
}
