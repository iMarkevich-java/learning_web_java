package my.project.exceptions;

import java.util.List;

public class DeveloperWebException extends RuntimeException {
    private List<String> errorList;

    public DeveloperWebException() {

    }

    public DeveloperWebException(List<String> errorList) {
        this.errorList = errorList;
    }

    public DeveloperWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
