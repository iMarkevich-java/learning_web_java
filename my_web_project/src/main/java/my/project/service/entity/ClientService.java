package my.project.service.entity;

import my.project.dao.hibernate.entity.ClientHibernateDao;
import my.project.entity.Client;
import my.project.exceptions.ClientWebException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    final ClientHibernateDao dao;
    private Client client;

    public ClientService() {
        dao = new ClientHibernateDao();
    }

    public void createClient(String clientNameParam, String clientNameProjectParam, String clientAddressParam){
        ArrayList<String> errorList = new ArrayList<>();
        if (clientNameParam.isEmpty()) {
            String errorMessage = "Client name can't be empty";
            errorList.add(errorMessage);
            throw new ClientWebException(errorList);
        } else if (clientNameProjectParam.isEmpty()) {
            String errorMessage = "Name project can't be empty";
            errorList.add(errorMessage);
            throw new ClientWebException(errorList);
        } else if (clientAddressParam.isEmpty()) {
            String errorMessage = "Client address  can't be empty";
            errorList.add(errorMessage);
            throw new ClientWebException(errorList);
        }

        client = new Client(clientNameParam, clientNameProjectParam, clientAddressParam);
        dao.create(client);
    }

    public void updateClientById(String updateClientIdParam, String updateClientNameParam, String updateClientNameProjectParam, String updateClientAddressParam) {
        ArrayList<String> errorList = new ArrayList<>();
        if (updateClientNameParam.isEmpty() || updateClientNameProjectParam.isEmpty() || updateClientAddressParam.isEmpty()) {
            String errorMessage = "Name, project name or address  can't be empty";
            errorList.add(errorMessage);
            throw new ClientWebException(errorList);
        }

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
}
