package my.project.dto;

import my.project.entity.Manager;

public class ManagerDto {

    private String departmentParam;
    private int experienceParam;

    public ManagerDto() {
    }

    public ManagerDto(String departmentParam, int experienceParam) {
        this.departmentParam = departmentParam;
        this.experienceParam = experienceParam;
    }

    public Manager readCreateManager() {
        return Manager
                .builder()
                .managerDepartment(departmentParam)
                .managerExperience(experienceParam)
                .build();
    }
}
