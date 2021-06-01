package my.project.exceptions;

import java.util.List;

public class ProjectWebException extends RuntimeException {
    private List<String> errorList;

    public ProjectWebException() {
    }

    public ProjectWebException(List<String> errorList) {

        this.errorList = errorList;
    }

    public ProjectWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
