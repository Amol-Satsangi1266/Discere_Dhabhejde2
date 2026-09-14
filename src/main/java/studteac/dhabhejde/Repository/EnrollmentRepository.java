package studteac.dhabhejde.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studteac.dhabhejde.Model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
}
