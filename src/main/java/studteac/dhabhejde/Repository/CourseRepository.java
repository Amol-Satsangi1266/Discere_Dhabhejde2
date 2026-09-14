package studteac.dhabhejde.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studteac.dhabhejde.Model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
