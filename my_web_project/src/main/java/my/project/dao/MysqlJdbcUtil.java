package my.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlJdbcUtil {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/web_java_project_database";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    private boolean checkDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() {
        if (checkDriver()) {
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                return connection;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public Statement getStatement() {
        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statement;
    }

}
