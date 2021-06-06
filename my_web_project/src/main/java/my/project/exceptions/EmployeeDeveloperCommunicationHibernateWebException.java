package my.project.exceptions;

import java.util.List;

public class EmployeeDeveloperCommunicationHibernateWebException extends RuntimeException {
    private List<String> errorList;

    public EmployeeDeveloperCommunicationHibernateWebException() {
    }

    public EmployeeDeveloperCommunicationHibernateWebException(List<String> errorList) {

        this.errorList = errorList;
    }

    public EmployeeDeveloperCommunicationHibernateWebException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
