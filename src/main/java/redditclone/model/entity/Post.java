package redditclone.model.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", unique = true, nullable = false)
    private Long post_id;

    @Column
    private String title;

    @Column
    private String text;

    @Column
    private LocalDate creation_date;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;

    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private User author;

}