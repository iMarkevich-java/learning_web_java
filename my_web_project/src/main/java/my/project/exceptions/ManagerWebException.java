package my.project.exceptions;

import java.util.List;

public class ManagerWebException extends RuntimeException {
    private List<String> errorList;

    public ManagerWebException() {
    }

    public ManagerWebException(List<String> errorList) {

        this.errorList = errorList;
    }

    public ManagerWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
