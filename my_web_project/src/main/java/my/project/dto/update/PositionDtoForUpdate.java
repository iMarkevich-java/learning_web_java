package my.project.dto.update;

import my.project.entity.Department;
import my.project.entity.Developer;
import my.project.entity.Manager;
import my.project.entity.QaEngineer;
import my.project.exceptions.PositionWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;

@Component
public class PositionDtoForUpdate {

    private String departmentParam;
    private int experienceParam;
    private String updateManagerIdParam;
    private String updateDeveloperIdParam;
    private String updateQaEngineerIdParam;

    @Autowired
    private ManagerDtoForUpdate managerDtoForUpdate;

    @Autowired
    private DeveloperDtoForUpdate developerDtoForUpdate;

    @Autowired
    private QaEngineerDtoForUpdate qaEngineerDtoForUpdate;

    public PositionDtoForUpdate() {
    }

    public void checkParameters(String departmentParam, int experienceParam, String updateManagerIdParam, String updateDeveloperIdParam, String updateQaEngineerIdParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (updateManagerIdParam != null) {
            if (!(updateManagerIdParam.isEmpty())) {
                try {
                    new BigInteger(updateManagerIdParam);
                } catch (Exception e) {
                    String errorMessage = "Can't parsing String manager id to BigInteger manager id in class" + getClass().getName();
                    errorList.add(errorMessage);
                    flag = true;
                }
            }

        }
        if (updateDeveloperIdParam != null) {
            if (!(updateDeveloperIdParam.isEmpty())) {
                try {
                    new BigInteger(updateDeveloperIdParam);
                } catch (Exception e) {
                    String errorMessage = "Can't parsing String developer id to BigInteger developer id in class" + getClass().getName();
                    errorList.add(errorMessage);
                    flag = true;
                }
            }
        }
        if (updateQaEngineerIdParam != null) {
            if (!(updateQaEngineerIdParam.isEmpty())) {
                try {
                    new BigInteger(updateDeveloperIdParam);
                } catch (Exception e) {
                    String errorMessage = "Can't parsing String qa engineer id to BigInteger qa engineer id in class" + getClass().getName();
                    errorList.add(errorMessage);
                    flag = true;
                }
            }
        }

        if (!(departmentParam.equals(Department.ECONOMIC.getDepartment()) || departmentParam.equals(Department.ROBOTIC.getDepartment()) || departmentParam.equals(Department.INDUSTRIAL.getDepartment()))) {
            String errorMessage = "Department can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (experienceParam < 0) {
            String errorMessage = "Experience can't be < 0 !!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new PositionWebException(errorList);
        }
        this.departmentParam = departmentParam;
        this.experienceParam = experienceParam;
        this.updateManagerIdParam = updateManagerIdParam;
        this.updateDeveloperIdParam = updateDeveloperIdParam;
        this.updateQaEngineerIdParam = updateQaEngineerIdParam;
    }

    public Manager readUpdateManager() {
        BigInteger updateManagerId = new BigInteger(updateManagerIdParam);
        return managerDtoForUpdate.convertManagerDtoToManager(departmentParam, experienceParam, updateManagerId);
    }

    public Developer readUpdateDeveloper() {
        BigInteger updateDeveloperId = new BigInteger(updateDeveloperIdParam);
        return developerDtoForUpdate.convertDeveloperDtoToDeveloper(departmentParam, experienceParam, updateDeveloperId);
    }

    public QaEngineer readUpdateQaEngineer() {
        BigInteger updateQaEngineer = new BigInteger(updateQaEngineerIdParam);
        return qaEngineerDtoForUpdate.convertQaEngineerDtoToQaEngineer(departmentParam, experienceParam, updateQaEngineer);
    }
}
