package my.project.dto;

import my.project.exceptions.EmployeeWebException;
import my.project.path.PathToFiles;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    EmployeeWebException employeeWebException;

    public ConvertMultiPartFileToBlob() {
    }

    public Blob convertCreatePhoto(MultipartFile photoParam) {
        Blob photoBlob;
        if (!(photoParam.isEmpty())) {
            try (InputStream inputStreamImage = photoParam.getInputStream()) {
                byte[] imageByte = IOUtils.toByteArray(inputStreamImage);
                photoBlob = new SerialBlob(imageByte);
            } catch (IOException | SQLException e) {
                List<String> errorList = employeeWebException.getErrorList();
                errorList.add(e.getMessage());
                employeeWebException.setErrorList(errorList);
                throw employeeWebException;
            }
        } else {
            try (FileInputStream fileInputStream = new FileInputStream(PathToFiles.PATH_TO_TEMP_IMAGE.getPath())) {
                byte[] imageByte = IOUtils.toByteArray(fileInputStream);
                photoBlob = new SerialBlob(imageByte);
            } catch (SQLException | IOException e) {
                List<String> errorList = employeeWebException.getErrorList();
                errorList.add(e.getMessage());
                employeeWebException.setErrorList(errorList);
                throw employeeWebException;
            }
        }
        return photoBlob;
    }

    public Blob convertUpdatePhoto(MultipartFile photoParam) {
        Blob photoBlob = null;
        if (!(photoParam.isEmpty())) {
            try (InputStream inputStreamImage = photoParam.getInputStream()) {
                byte[] imageByte = IOUtils.toByteArray(inputStreamImage);
                photoBlob = new SerialBlob(imageByte);
            } catch (IOException | SQLException e) {
                List<String> errorList = employeeWebException.getErrorList();
                errorList.add(e.getMessage());
                employeeWebException.setErrorList(errorList);
                throw employeeWebException;
            }
        } else {
            try (FileInputStream fileInputStream = new FileInputStream(PathToFiles.PATH_TO_PHOTO.getPath())) {
                byte[] imageByte = IOUtils.toByteArray(fileInputStream);
                photoBlob = new SerialBlob(imageByte);
            } catch (SQLException | IOException e) {
                List<String> errorList = employeeWebException.getErrorList();
                errorList.add(e.getMessage());
                employeeWebException.setErrorList(errorList);
                throw employeeWebException;
            }
        }
        return photoBlob;
    }
}
