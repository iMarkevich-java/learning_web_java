package my.project.dto.update;

import my.project.entity.QaEngineer;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class QaEngineerDtoForUpdate {
    public QaEngineer convertQaEngineerDtoToQaEngineer(String developerDepartment, int developerExperience, BigInteger developerId) {
        return QaEngineer
                .builder()
                .qaEngineerId(developerId)
                .qaEngineerDepartment(developerDepartment)
                .qaEngineerExperience(developerExperience)
                .build();
    }
}
