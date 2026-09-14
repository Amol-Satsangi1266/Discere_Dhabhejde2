package studteac.dhabhejde.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studteac.dhabhejde.Model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission,Long> {
}

