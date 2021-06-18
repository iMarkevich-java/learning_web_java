package my.project.entity;

public enum Department {
    ECONOMIC("Economic"),
    ROBOTIC("Robotic"),
    INDUSTRIAL("Industrial");

    String department;

    Department(String department) {
        this.department = department;
    }

    Department() {
    }

    public String getDepartment() {
        return department;
    }
}
