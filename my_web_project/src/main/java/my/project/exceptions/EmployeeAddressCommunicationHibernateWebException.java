package my.project.exceptions;

import java.util.List;

public class EmployeeAddressCommunicationHibernateWebException extends RuntimeException {
    private List<String> errorList;

    public EmployeeAddressCommunicationHibernateWebException() {
    }

    public EmployeeAddressCommunicationHibernateWebException(List<String> errorList) {

        this.errorList = errorList;
    }

    public EmployeeAddressCommunicationHibernateWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
