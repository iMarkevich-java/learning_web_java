package my.project.service.entity;

import my.project.dao.hibernate.entity.ClientHibernateDao;
import my.project.dao.repository.ClientRepositoryDao;
import my.project.entity.Client;
import my.project.exceptions.ClientWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    final ClientHibernateDao dao;
    @Autowired
    ClientRepositoryDao clientRepositoryDao;
    private Boolean flag = false;
    private Client client;

    public ClientService() {
        dao = new ClientHibernateDao();
    }

    public BigInteger createClient(String clientNameParam, String clientNameProjectParam, String clientAddressParam) {
        checkAllParameterOnException(clientNameParam, clientNameProjectParam, clientAddressParam);
        client = new Client(clientNameParam, clientNameProjectParam, clientAddressParam);
//        dao.create(client);
        clientRepositoryDao.create(client);
        return client.getClientId();
    }

    public void updateClientById(String updateClientIdParam, String updateClientNameParam, String updateClientNameProjectParam, String updateClientAddressParam) {
        checkAllParameterOnException(updateClientIdParam, updateClientNameParam, updateClientNameProjectParam, updateClientAddressParam);
        BigInteger updateClientId = new BigInteger(updateClientIdParam);
        client = new Client(updateClientId, updateClientNameParam, updateClientNameProjectParam, updateClientAddressParam);
        dao.update(client);
    }

    public void deleteClientById(String deleteClientIdParam) {
        BigInteger deleteClientId = new BigInteger(deleteClientIdParam);
        dao.delete(deleteClientId);
    }

    public Client readClientById(BigInteger clientId) {
        return dao.readById(clientId);
    }

    public List<Client> readAllClient() {
        return dao.readAll();
    }

    private String checkParameter(String parameterName, String parameterValue, String sql) {
        if (!parameterValue.isEmpty() && this.flag) {
            sql += " and " + parameterName + "='" + parameterValue + "'";
        } else if (!parameterValue.isEmpty()) {
            sql += parameterName + "='" + parameterValue + "'";
            this.flag = true;
        }
        return sql;
    }

    private String checkAllParameter(String... parameter) {
        String hqlString;
        if (parameter[0].isEmpty() && parameter[1].isEmpty() && parameter[2].isEmpty() &&
                parameter[3].isEmpty() && parameter[4].isEmpty()) {
            hqlString = "from Employee";
        } else {
            hqlString = "FROM Employee employee WHERE ";
        }
        return hqlString;
    }

    private void checkAllParameterOnException(String clientNameParam, String clientNameProjectParam, String clientAddressParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (clientNameParam.isEmpty()) {
            String errorMessage = "Client name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (clientNameProjectParam.isEmpty()) {
            String errorMessage = "Client project can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (clientAddressParam.isEmpty()) {
            String errorMessage = "Client address can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new ClientWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String clientIdParam, String clientNameParam, String clientNameProjectParam, String clientAddressParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (clientIdParam.isEmpty()) {
            String errorMessage = "Client id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (clientNameParam.isEmpty()) {
            String errorMessage = "Client name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (clientNameProjectParam.isEmpty()) {
            String errorMessage = "Client project can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (clientAddressParam.isEmpty()) {
            String errorMessage = "Client address can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new ClientWebException(errorList);
        }
    }
}
