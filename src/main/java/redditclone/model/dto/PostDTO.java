package redditclone.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private long id;
    private String title;
    private String text;
    private String author_name;
    private String community_name;

}

