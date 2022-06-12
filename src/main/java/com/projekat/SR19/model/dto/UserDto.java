package com.projekat.SR19.model.dto;

import com.projekat.SR19.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
/*@AllArgsConstructor*/
public class UserDto {

    private Long id;

    @NotEmpty(message = "Username field cannot be empty!")
    private String username;

    @NotEmpty(message = "Password field cannot be empty!")
    private String password;

    @NotEmpty(message = "Email field cannot be empty!")
    private String email;

    @NotEmpty(message = "Path to Url cannot be empty!")
    private String avatar;

    @NotEmpty(message = "Display name cannot be empty!")
    private String displayName;

    @NotEmpty(message = "Description field cannot be empty!")
    private String description;

    public UserDto(User registeredUser){
        this.id = registeredUser.getId();
        this.username = registeredUser.getUsername();
        this.password = registeredUser.getPassword();
        this.email = registeredUser.getEmail();
        this.avatar = registeredUser.getAvatar();
        this.displayName = registeredUser.getDisplayName();
        this.description = registeredUser.getDescription();
    }
}
