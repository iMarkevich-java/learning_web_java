package my.project.exceptions;

import java.util.List;

public class ClientWebException extends RuntimeException {
    private List<String> errorList;

    public ClientWebException() {

    }

    public ClientWebException(List<String> errorList) {
        this.errorList = errorList;
    }

    public ClientWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
