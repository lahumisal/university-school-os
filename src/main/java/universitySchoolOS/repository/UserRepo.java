package universitySchoolOS.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universitySchoolOS.model.Users;

@Repository
public interface UserRepo extends JpaRepository<@NonNull Users,@NonNull Long> {

    Users findByEmail(String email);
}
