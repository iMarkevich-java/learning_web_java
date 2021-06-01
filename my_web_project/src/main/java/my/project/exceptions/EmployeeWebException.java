package my.project.exceptions;

import java.util.List;

public class EmployeeWebException extends RuntimeException {
    private List<String> errorList;

    public EmployeeWebException() {
    }

    public EmployeeWebException(List<String> errorList) {

        this.errorList = errorList;
    }

    public EmployeeWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
