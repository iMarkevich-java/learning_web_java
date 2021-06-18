package my.project.dto.update;

import my.project.entity.Developer;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class DeveloperDtoForUpdate {
    public Developer convertDeveloperDtoToDeveloper(String developerDepartment, int developerExperience, BigInteger developerId) {
        return Developer
                .builder()
                .developerId(developerId)
                .developerDepartment(developerDepartment)
                .developerExperience(developerExperience)
                .build();
    }
}
