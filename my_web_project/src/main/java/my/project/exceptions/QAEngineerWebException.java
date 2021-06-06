package my.project.exceptions;

import java.util.List;

public class QAEngineerWebException extends RuntimeException {
    private List<String> errorList;

    public QAEngineerWebException() {
    }

    public QAEngineerWebException(List<String> errorList) {

        this.errorList = errorList;
    }

    public QAEngineerWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
