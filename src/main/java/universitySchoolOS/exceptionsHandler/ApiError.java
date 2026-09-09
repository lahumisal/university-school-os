package universitySchoolOS.exceptionsHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {

    private Integer errorStatus;

    private String errorCode;

    private String errorMessage;

    private ErrorTypes errorType;
}
