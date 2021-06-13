package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.Address;
import my.project.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class AddressRepositoryDao implements Dao<Address> {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void create(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void update(Address address) {
        addressRepository.updateAddress(address.getAddressId(), address.getCountry(), address.getRegion(), address.getLocality()
                ,address.getCity(), address.getStreet(), address.getHouse(), address.getFlat());
    }

    @Override
    public void delete(BigInteger id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> readAll() {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Address readById(BigInteger id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public List<Address> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<Address> readAllByHqlQuery(String sql) {
        return null;
    }
}
