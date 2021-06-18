package my.project.dto.update;

import my.project.entity.Address;
import my.project.exceptions.AddressWebException;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;

@Component
public class AddressDtoForUpdate {

    private String updateAddressIdParam;
    private String updateAddressCountryParam;
    private String updateAddressRegionParam;
    private String updateAddressLocalityParam;
    private String updateAddressCityParam;
    private String updateAddressStreetParam;
    private int updateAddressHouseParam;
    private int updateAddressFlatParam;

    public AddressDtoForUpdate() {
    }

    public void checkParameters(String updateAddressIdParam, String updateAddressCountryParam,
                                String updateAddressRegionParam, String updateAddressLocalityParam,
                                String updateAddressCityParam, String updateAddressStreetParam,
                                int updateAddressHouseParam, int updateAddressFlatParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        try {
            new BigInteger(updateAddressIdParam);
        } catch (Exception e) {
            String errorMessage = "Can't parsing String address id to BigInteger address id in class" + getClass().getName();
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateAddressIdParam == null || updateAddressIdParam.isEmpty()) {
            String errorMessage = "Address id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateAddressCountryParam.isEmpty()) {
            String errorMessage = "Address country can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateAddressRegionParam.isEmpty()) {
            String errorMessage = "Address region can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateAddressLocalityParam.isEmpty()) {
            String errorMessage = "Address locality can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateAddressCityParam.isEmpty()) {
            String errorMessage = "Address city can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateAddressStreetParam.isEmpty()) {
            String errorMessage = "Address street can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateAddressHouseParam <= 0) {
            String errorMessage = "Address house can't be <= 0!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (updateAddressFlatParam <= 0) {
            String errorMessage = "Address flat can't be <= 0!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new AddressWebException(errorList);
        }

        this.updateAddressIdParam = updateAddressIdParam;
        this.updateAddressCountryParam = updateAddressCountryParam;
        this.updateAddressRegionParam = updateAddressRegionParam;
        this.updateAddressLocalityParam = updateAddressLocalityParam;
        this.updateAddressCityParam = updateAddressCityParam;
        this.updateAddressStreetParam = updateAddressStreetParam;
        this.updateAddressHouseParam = updateAddressHouseParam;
        this.updateAddressFlatParam = updateAddressFlatParam;
    }

    public Address convertAddressDtoToAddress() {
        BigInteger addressId = new BigInteger(updateAddressIdParam);
        return Address
                .builder()
                .addressId(addressId)
                .country(updateAddressCountryParam)
                .region(updateAddressRegionParam)
                .locality(updateAddressLocalityParam)
                .city(updateAddressCityParam)
                .street(updateAddressStreetParam)
                .house(updateAddressHouseParam)
                .flat(updateAddressFlatParam)
                .build();
    }
}
