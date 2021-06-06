package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.Client;
import my.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class ClientRepositoryDao implements Dao<Client> {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void update(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void delete(BigInteger id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> readAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client readById(BigInteger id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<Client> readAllByHqlQuery(String sql) {
        return null;
    }
}
