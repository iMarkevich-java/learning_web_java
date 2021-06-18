package my.project.dto.create;

import my.project.entity.Developer;
import org.springframework.stereotype.Component;

@Component
public class DeveloperDtoForCreate {

    public DeveloperDtoForCreate() {
    }

    public Developer convertDeveloperDtoToDeveloper(String departmentParam, int experienceParam) {
        return Developer
                .builder()
                .developerDepartment(departmentParam)
                .developerExperience(experienceParam)
                .build();
    }
}
