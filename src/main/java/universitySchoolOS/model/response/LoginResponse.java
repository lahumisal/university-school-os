package universitySchoolOS.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import universitySchoolOS.model.enums.Roles;
import universitySchoolOS.model.enums.UserType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String firstName;
    private String lastName;
    private String email;
    private Roles role;
    private UserType userType;
    private String token;
}

