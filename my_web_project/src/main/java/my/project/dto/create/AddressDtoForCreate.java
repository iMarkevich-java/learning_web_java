package my.project.dto.create;

import my.project.entity.Address;
import my.project.exceptions.AddressWebException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AddressDtoForCreate {

    private String addressCountryParam;
    private String addressRegionParam;
    private String addressLocalityParam;
    private String addressCityParam;
    private String addressStreetParam;
    private int addressHouseParam;
    private int addressFlatParam;

    public AddressDtoForCreate() {
    }

    public void checkParameters(String addressCountryParam, String addressRegionParam, String addressLocalityParam, String addressCityParam, String addressStreetParam, int addressHouseParam, int addressFlatParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (addressCountryParam.isEmpty()) {
            String errorMessage = "Address country can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressRegionParam.isEmpty()) {
            String errorMessage = "Address region can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressLocalityParam.isEmpty()) {
            String errorMessage = "Address locality can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressCityParam.isEmpty()) {
            String errorMessage = "Address city can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressStreetParam.isEmpty()) {
            String errorMessage = "Address street can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressHouseParam <= 0) {
            String errorMessage = "Address house can't be <= 0!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressFlatParam <= 0) {
            String errorMessage = "Address flat can't be <= 0!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new AddressWebException(errorList);
        }

        this.addressCountryParam = addressCountryParam;
        this.addressRegionParam = addressRegionParam;
        this.addressLocalityParam = addressLocalityParam;
        this.addressCityParam = addressCityParam;
        this.addressStreetParam = addressStreetParam;
        this.addressHouseParam = addressHouseParam;
        this.addressFlatParam = addressFlatParam;
    }

    public Address convertAddressDtoToAddress() {
        return Address
                .builder()
                .country(addressCountryParam)
                .region(addressRegionParam)
                .locality(addressLocalityParam)
                .city(addressCityParam)
                .street(addressStreetParam)
                .house(addressHouseParam)
                .flat(addressFlatParam)
                .build();
    }
}
