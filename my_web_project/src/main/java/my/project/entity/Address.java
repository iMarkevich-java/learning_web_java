package my.project.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private BigInteger addressId;

    @Column(name = "country")
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "locality")
    private String locality;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private int house;

    @Column(name = "flat")
    private int flat;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_address_communication", joinColumns = @JoinColumn(name = "address_id_fk"), inverseJoinColumns = @JoinColumn(name = "employee_id_fk"))
    private Employee employee;

    public Address() {
    }

    public Address(String country, String region, String locality, String city, String street, int house, int flat) {
        this.country = country;
        this.region = region;
        this.locality = locality;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public Address(BigInteger addressId, String country, String region, String locality, String city, String street, int house, int flat) {
        this.addressId = addressId;
        this.country = country;
        this.region = region;
        this.locality = locality;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public BigInteger getAddressId() {
        return addressId;
    }

    public void setAddressId(BigInteger addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Address address = (Address) o;
//        return house == address.house && flat == address.flat && addressId.equals(address.addressId) && country.equals(address.country) && region.equals(address.region) && locality.equals(address.locality) && city.equals(address.city) && street.equals(address.street) && developer.equals(address.developer);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(addressId, country, region, locality, city, street, house, flat, developer);
//    }
//
    @Override
    public String toString() {
        return "<h2>Адрес:</h2>" +
                "<strong>Страна: </strong>" + country + "<br>" +
                "<strong>Область: </strong>" + region + "<br>" +
                "<strong>Район: </strong>" + locality + "<br>" +
                "<strong>Город: </strong>" + city + "<br>" +
                "<strong>Улица: </strong>" + street + "<br>" +
                "<strong>Дом: </strong>" + house + "<br>" +
                "<strong>Квартира: </strong>" + flat;
    }
}
