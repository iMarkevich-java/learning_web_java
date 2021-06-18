package my.project.dto.update;

import my.project.entity.Manager;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class ManagerDtoForUpdate {
    public Manager convertManagerDtoToManager(String departmentParam, int experienceParam, BigInteger managerId) {
        return Manager
                .builder()
                .managerId(managerId)
                .managerDepartment(departmentParam)
                .managerExperience(experienceParam)
                .build();
    }
}

