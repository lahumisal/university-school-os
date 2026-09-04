package universitySchoolOS.database;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "spring.datasource")
@Component
public class DatabaseProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
