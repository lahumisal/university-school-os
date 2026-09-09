package universitySchoolOS.exceptionsHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ValidationError {

    UNAUTHORIZE_ACCESS(400,"CRAPE0051", FieldErrorMessages.UNAUTHORIZE_ACCESS,ErrorTypes.unauthorized_access);

    public final int errorStatus;
    public final String errorCode;
    public final String errorMessage;
    public final ErrorTypes errorType;

}
