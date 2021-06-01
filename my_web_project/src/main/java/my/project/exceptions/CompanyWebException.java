package my.project.exceptions;

import java.util.List;

public class CompanyWebException extends RuntimeException {
    private List<String> errorList;

    public CompanyWebException() {

    }

    public CompanyWebException(List<String> errorList) {
        this.errorList = errorList;
    }

    public CompanyWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
