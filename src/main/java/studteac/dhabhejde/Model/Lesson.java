package studteac.dhabhejde.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 10000)
    private String content;

    private String videoUrl;

    private Integer orderNumber;

    // Many lessons belong to one course
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
