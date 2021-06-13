package my.project.dto;

import my.project.exceptions.EmployeeWebException;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Component
public class ConvertMultiPartFileToBlob {

    public ConvertMultiPartFileToBlob() {
    }

    public Blob convert(MultipartFile photoParam, String pathEmployeeImage) {
        Blob photoBlob = null;
        if (!(photoParam.isEmpty())) {
            try (InputStream inputStreamImage = photoParam.getInputStream()) {
                byte[] imageByte = IOUtils.toByteArray(inputStreamImage);
                photoBlob = new SerialBlob(imageByte);
            } catch (IOException | SQLException e) {
                List<String> errorList = new EmployeeWebException().getErrorList();
                errorList.add(e.getMessage());
                new EmployeeWebException().setErrorList(errorList);
            }
        } else {
            try (FileInputStream fileInputStream = new FileInputStream(pathEmployeeImage)) {
                byte[] imageByte = IOUtils.toByteArray(fileInputStream);
                photoBlob = new SerialBlob(imageByte);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return photoBlob;
    }

    public Blob convert(MultipartFile photoParam) {
        Blob photoBlob = null;
        if (!(photoParam.isEmpty())) {
            try (InputStream inputStreamImage = photoParam.getInputStream()) {
                byte[] imageByte = IOUtils.toByteArray(inputStreamImage);
                photoBlob = new SerialBlob(imageByte);
            } catch (IOException | SQLException e) {
                List<String> errorList = new EmployeeWebException().getErrorList();
                errorList.add(e.getMessage());
                new EmployeeWebException().setErrorList(errorList);
            }
        } else {
            try (FileInputStream fileInputStream = new FileInputStream("src/main/webapp/images/employeePhoto.jpg")) {
                byte[] imageByte = IOUtils.toByteArray(fileInputStream);
                photoBlob = new SerialBlob(imageByte);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }

        }
        return photoBlob;
    }
}
