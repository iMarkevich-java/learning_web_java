package my.project.exceptions;

import java.util.List;

public class AllEntityWebException extends RuntimeException{
    private List<String> errorList;

    public AllEntityWebException() {
    }

    public AllEntityWebException(List<String> errorList) {
        this.errorList = errorList;
    }

    public AllEntityWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
