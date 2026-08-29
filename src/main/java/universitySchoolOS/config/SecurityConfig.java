package universitySchoolOS.config;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtFilter jwtFilter;
    private final JwtLogoutHandler jwtLogoutHandler;

    public SecurityConfig(UserDetailsService userDetailsService, JwtFilter jwtFilter, JwtLogoutHandler jwtLogoutHandler) {
        this.userDetailsService = userDetailsService;
        this.jwtFilter = jwtFilter;
        this.jwtLogoutHandler = jwtLogoutHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v1/api/home/login").permitAll()
                        .requestMatchers("/v1/api/home/register").permitAll()
                        .requestMatchers("/v1/api/home/logout").authenticated()
                        .requestMatchers("/v1/api/principal/**").hasAuthority("PRINCIPAL")
                        .requestMatchers("/v1/api/teacher/**").hasAuthority("TEACHER")
                        .requestMatchers("/v1/api/student/**").hasAuthority("STUDENT")
                        .requestMatchers("/v1/api/university/**").hasAuthority("UNIVERSITY")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .authenticationProvider(authenticationProvider())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout
                        .logoutUrl("/v1/api/home/logout")
                        .addLogoutHandler(jwtLogoutHandler)
                        .logoutSuccessHandler(
                                (request, response, authentication) -> {
                                    response.setStatus(HttpServletResponse.SC_OK);
                                    response.setContentType("application/json");
                                    response.getWriter().write("{\"message\":\"Logout successful\"}"
                                    );
                                }
                        )
                )
                .build();
    }



    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        log.info("daoAuthenticationProvider: {}", daoAuthenticationProvider);
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        log.info("In AuthenticationManager");
        return config.getAuthenticationManager();
    }

}
