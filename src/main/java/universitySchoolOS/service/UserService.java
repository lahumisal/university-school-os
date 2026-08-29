package universitySchoolOS.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import universitySchoolOS.model.Users;
import universitySchoolOS.model.enums.Roles;
import universitySchoolOS.model.enums.UserType;
import universitySchoolOS.model.request.LoginReqDTO;
import universitySchoolOS.model.request.RegisterUserDTO;
import universitySchoolOS.model.response.LoginResponse;
import universitySchoolOS.repository.UserRepo;

import java.util.UUID;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService  jwtService;

    @Autowired
    public AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public String registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
        Users user = new Users();
        user.setRole(Roles.STUDENT);
        user.setUserType(UserType.COLLEGE);
        user.setFirstName(registerUserDTO.getFirstName());
        user.setLastName(registerUserDTO.getLastName());
        user.setEmail(registerUserDTO.getEmail());
        user.setContactNumber(registerUserDTO.getContactNumber());
        user.setPassword(encoder.encode(registerUserDTO.getPassword()));
        userRepo.save(user);
        return "Register success";
    }

    public LoginResponse verifyUser(LoginReqDTO loginReqDTO) {
        log.info("verifying the user");
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginReqDTO.getUsername(), loginReqDTO.getPassword()));
        if(authentication.isAuthenticated()){
            log.info("Authentication result: {}", authentication.getPrincipal());
            
            // Get user from database to retrieve full user details
            Users dbUser = userRepo.findByEmail(loginReqDTO.getUsername());
            
            // Generate JWT token
            String token = jwtService.generateToken(dbUser.getEmail());
            
            // Create and return login response with username, password, and token
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setFirstName(dbUser.getFirstName());
            loginResponse.setLastName(dbUser.getLastName());
            loginResponse.setEmail(dbUser.getEmail());
            loginResponse.setUserType(dbUser.getUserType());
            loginResponse.setRole(dbUser.getRole());
            loginResponse.setToken(token);
//            loginResponse.setPassword(dbUser.getPassword()); // Hashed password from database

            return loginResponse;
        }
        return null; // Return null if authentication fails
    }
    
    public String logout(String token) {
        if (token != null && !token.isEmpty()) {
            try {
                jwtService.blacklistToken(token);
                log.info("Token blacklisted successfully");
                return "Logout successfully";
            } catch (Exception e) {
                log.error("Error during logout: {}", e.getMessage());
                return "Logout not successfully";
            }
        }
        return "Logout not successfully";
    }
}
