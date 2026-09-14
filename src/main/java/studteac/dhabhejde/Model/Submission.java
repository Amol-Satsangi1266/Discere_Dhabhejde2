package studteac.dhabhejde.Model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "submissions",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"assignment_id", "student_id"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Assignment
    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment;

    // Student
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @Column(length = 10000)
    private String content;

    private LocalDateTime submittedAt;

    private Integer marks;

    @Column(length = 3000)
    private String feedback;

    @Enumerated(EnumType.STRING)
    private SubmissionStatus status;

    @PrePersist
    protected void onCreate() {
        submittedAt = LocalDateTime.now();

        if (status == null) {
            status = SubmissionStatus.SUBMITTED;
        }
    }
}
