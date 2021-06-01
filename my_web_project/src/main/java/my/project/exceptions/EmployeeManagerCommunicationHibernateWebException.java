package my.project.exceptions;

import java.util.List;

public class EmployeeManagerCommunicationHibernateWebException extends RuntimeException{
    private List<String> errorList;

    public EmployeeManagerCommunicationHibernateWebException() {
    }

    public EmployeeManagerCommunicationHibernateWebException(List<String> errorList) {

        this.errorList = errorList;
    }

    public EmployeeManagerCommunicationHibernateWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
