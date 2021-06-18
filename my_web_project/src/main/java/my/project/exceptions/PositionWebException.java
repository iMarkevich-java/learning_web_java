package my.project.exceptions;

import java.util.List;

public class PositionWebException extends RuntimeException {
    private List<String> errorList;

    public PositionWebException() {

    }

    public PositionWebException(List<String> errorList) {
        this.errorList = errorList;
    }

    public PositionWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
