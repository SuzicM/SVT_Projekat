package redditclone.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDTO {

    private long id;
    private String name;
    private String description;
    private LocalDate creationDate;
    private String moderatorUsername;

}

