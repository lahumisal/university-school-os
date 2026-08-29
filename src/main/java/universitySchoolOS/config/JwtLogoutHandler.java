package universitySchoolOS.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import universitySchoolOS.service.JwtService;

@Slf4j
@Component
public class JwtLogoutHandler implements LogoutHandler {

    private final JwtService jwtService;

    public JwtLogoutHandler(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) {

        jwtService.logout(request);

        log.info("Logout handler executed");
    }
}