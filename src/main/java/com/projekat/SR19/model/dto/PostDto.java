package com.projekat.SR19.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Long id;

    @NotEmpty(message = "Title field cannot be empty!")
    private String title;

    @NotEmpty(message = "Text field cannot be empty!")
    private String text;

    @NotEmpty(message = "Image path cannot be empty!")
    private String imagePath;

    private LocalDate creationDate;
}
