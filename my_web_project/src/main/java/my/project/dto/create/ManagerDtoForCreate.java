package my.project.dto.create;

import my.project.entity.Manager;
import org.springframework.stereotype.Component;

@Component
public class ManagerDtoForCreate {

    public ManagerDtoForCreate() {
    }

    public Manager convertManagerDtoToManager(String departmentParam, int experienceParam) {
        return Manager
                .builder()
                .managerDepartment(departmentParam)
                .managerExperience(experienceParam)
                .build();
    }

}
