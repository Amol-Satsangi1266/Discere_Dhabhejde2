package studteac.dhabhejde.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "assignments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 5000)
    private String description;

    private LocalDateTime dueDate;

    private Integer maxMarks;

    // Assignment belongs to Course
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Assignment -> Submissions
    @OneToMany(mappedBy = "assignment")
    private List<Submission> submissions = new ArrayList<>();
}
