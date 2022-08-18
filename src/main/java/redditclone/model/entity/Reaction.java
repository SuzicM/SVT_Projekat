package redditclone.model.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reaction")
public class Reaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reaction_id;

	@Enumerated(EnumType.STRING)
	@Column(name = "reaction_type")
	private ReactionType reaction_type;

	@Column
	private LocalDate time_stamp;

	@Column
	private long voter_id;

	@Column
	private long post_id;

}
