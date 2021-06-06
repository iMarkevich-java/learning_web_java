package my.project.entity;

public enum Positions {
    MANAGER("Manager"),
    DEVELOPER("Developer"),
    QA_ENGINEER("QA engineer");

    String position;

    Positions(String position) {
        this.position = position;
    }

    Positions() {
    }

    public String getPosition() {
        return position;
    }
}
