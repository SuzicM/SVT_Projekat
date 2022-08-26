package redditclone.model.dto;

import lombok.*;
import redditclone.model.entity.ReactionType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReactionDTO {

    private ReactionType type;
    private long voter_id;
    private long post_id;

}
