package my.project.dto.create;

import my.project.entity.Department;
import my.project.entity.Developer;
import my.project.entity.Manager;
import my.project.entity.QaEngineer;
import my.project.exceptions.PositionWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PositionDtoForCreate {

    private String departmentParam;
    private int experienceParam;

    @Autowired
    private ManagerDtoForCreate managerDtoForCreate;

    @Autowired
    private DeveloperDtoForCreate developerDtoForCreate;

    @Autowired
    private QaEngineerDtoForCreate qaEngineerDtoForCreate;

    public PositionDtoForCreate() {
    }

    public void checkParameters(String departmentParam, int experienceParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();

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
    }

    public Manager readCreateManager() {
        return managerDtoForCreate.convertManagerDtoToManager(departmentParam, experienceParam);
    }

    public Developer readCreateDeveloper() {
        return developerDtoForCreate.convertDeveloperDtoToDeveloper(departmentParam, experienceParam);
    }

    public QaEngineer readCreateQaEngineer() {
        return qaEngineerDtoForCreate.convertQaEngineerDtoToQaEngineer(departmentParam, experienceParam);
    }
}
