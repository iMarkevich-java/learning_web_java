package my.project.dto.create;

import my.project.entity.QaEngineer;
import org.springframework.stereotype.Component;

@Component
public class QaEngineerDtoForCreate {

    public QaEngineerDtoForCreate() {
    }

    public QaEngineer convertQaEngineerDtoToQaEngineer(String departmentParam, int experienceParam) {
        return QaEngineer
                .builder()
                .qaEngineerDepartment(departmentParam)
                .qaEngineerExperience(experienceParam)
                .build();
    }
}
