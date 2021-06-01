package my.project.exceptions;

import java.util.List;

public class PersonWebException extends RuntimeException {
    private List<String> errorList;

    public PersonWebException() {

    }

    public PersonWebException(List<String> errorList) {
        this.errorList = errorList;
    }

    public PersonWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
