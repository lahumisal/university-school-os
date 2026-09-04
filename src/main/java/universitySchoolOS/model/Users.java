package universitySchoolOS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import universitySchoolOS.model.enums.Roles;
import universitySchoolOS.model.enums.UserType;
import java.sql.Timestamp;

@Entity
@Table(name = "usos_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Column(name = "user_id", nullable = false, unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles", nullable = false)
    private Roles role;

    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @JsonIgnore
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;
}