package redditclone.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import redditclone.model.dto.CreateUserDTO;
import redditclone.model.dto.JwtAuthRequestDTO;
import redditclone.model.dto.UpdateUserDTO;
import redditclone.model.dto.UserTokenDTO;
import redditclone.model.entity.User;
import redditclone.security.TokenUtils;
import redditclone.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    UserDetailsService userDetailsService;

    @PutMapping(value = "/{username}/", consumes = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserDTO updateUserDTO, @PathVariable("username") String username) {
        return new ResponseEntity<>(userService.updateUser(updateUserDTO, username), HttpStatus.OK);
    }

    @GetMapping(value = "/getAll/")
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/register/", consumes = "application/json")
    public ResponseEntity<User> Register(@RequestBody CreateUserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/")
    public ResponseEntity<User> findUserById(@PathVariable("id") long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "username/{username}/")
    public ResponseEntity<User> findUserByUsername(@PathVariable("username") String username) {
        User user = userService.findUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login/")
    public ResponseEntity<UserTokenDTO> createAuthenticationToken(
            @RequestBody JwtAuthRequestDTO authenticationRequest, HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user);
        int expiresIn = tokenUtils.getExpiredIn();

        return ResponseEntity.ok(new UserTokenDTO(jwt, expiresIn));
    }

    @PutMapping(value = "changePassword/{username}/")
    public ResponseEntity<User> updateUser(@RequestBody String newPassword, @PathVariable("username") String username) {
        return new ResponseEntity<>(userService.changePassword(newPassword, username), HttpStatus.OK);
    }

    @PostMapping(value = "oldPasswordVerification/{username}/")
    public ResponseEntity<Boolean> checkOldPassword(@RequestBody String password, @PathVariable("username") String username) {
        return new ResponseEntity<>(userService.oldPasswordVerification(password, username), HttpStatus.OK);
    }

}
