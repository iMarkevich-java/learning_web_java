package my.project.repository;

import my.project.entity.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Repository
public interface AddressRepository extends CrudRepository<Address, BigInteger> {

    @Transactional
    @Modifying
    @Query(value = "Update Address address SET address.country = ?2, address.region = ?3, address.locality = ?4, address.city = ?5," +
            " address.street = ?6, address.house = ?7, address.flat = ?8 WHERE address.addressId = ?1", nativeQuery = true)
    void updateAddress(BigInteger addressId, String country, String region, String locality, String city, String street, int house, int flat);
}
