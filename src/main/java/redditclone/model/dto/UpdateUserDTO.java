package redditclone.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {

    private String description;
    private String display_name;

}
