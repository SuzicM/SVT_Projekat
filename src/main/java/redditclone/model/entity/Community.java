package redditclone.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "communities")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_id", unique = true, nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private LocalDate creation_date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moderator_id", referencedColumnName = "id")
    private User moderator;

    @JsonManagedReference
    @OneToMany(mappedBy = "community")
    private Set<Post> posts;
}
