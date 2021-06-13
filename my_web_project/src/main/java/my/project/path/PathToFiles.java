package my.project.path;

public enum PathToFiles {
    PATH_TO_PHOTO("src/main/webapp/images/employeePhoto.jpg"),
    PATH_TO_TEMP_IMAGE("src/main/webapp/images/tempImage.jpg");

    String path;

    PathToFiles(String path) {
        this.path = path;
    }

    PathToFiles() {
    }

    public String getPath() {
        return path;
    }
}
