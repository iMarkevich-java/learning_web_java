package my.project.exceptions;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
