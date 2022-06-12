package redditclone.model.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id",unique = true,nullable = false)
	private Long user_id;
	 
	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String email;

	@Column
	private LocalDate registration_date;
	
	@Column
	private String description;
	
	@Column
	private String display_name;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Roles role;


}