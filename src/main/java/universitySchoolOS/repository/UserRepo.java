package universitySchoolOS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universitySchoolOS.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {

    Users findByEmail(String email);
}
