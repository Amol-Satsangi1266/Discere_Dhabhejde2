package studteac.dhabhejde.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studteac.dhabhejde.Model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
