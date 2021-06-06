package my.project.exceptions;

import java.util.List;

public class EmployeeQAEngineerCommunicationHibernateWbException extends RuntimeException {
    private List<String> errorList;

    public EmployeeQAEngineerCommunicationHibernateWbException() {
    }

    public EmployeeQAEngineerCommunicationHibernateWbException(List<String> errorList) {

        this.errorList = errorList;
    }

    public EmployeeQAEngineerCommunicationHibernateWbException(String message) {
        super(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
