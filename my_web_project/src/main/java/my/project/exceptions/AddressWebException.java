package my.project.exceptions;

import java.util.List;

public class AddressWebException extends RuntimeException {
    private List<String> errorList;

    public AddressWebException() {

    }

    public AddressWebException(List<String> errorList) {
        this.errorList = errorList;
    }

    public AddressWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
