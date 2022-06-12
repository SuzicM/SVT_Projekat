package com.projekat.SR19.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class CommunityDto {

    private Long id;

    @NotEmpty(message = "Name field cannot be empty!")
    private String name;

    @NotEmpty(message = "Description field cannot be empty!")
    private String description;

    private Boolean isSuspended;
    private String SuspendedReason;

}
