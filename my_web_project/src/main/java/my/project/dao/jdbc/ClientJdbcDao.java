package my.project.dao.jdbc;

import my.project.dao.Dao;
import my.project.dao.MysqlJdbcUtil;
import my.project.entity.Client;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientJdbcDao implements Dao<Client> {

    @Override
    public void create(Client client) {
        try (Connection connection = new MysqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO web_java_project_database.client (name, project, address) VALUES ('"
                    + client.getNameClient() + "','" + client.getNameProject() + "','" + client.getAddress() + "')";
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Client updateClient) {
        String sql = "UPDATE web_java_project_database.client SET name=?, project=?, address= ? WHERE (id = ?)";
        try (Connection connection = new MysqlJdbcUtil().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updateClient.getNameClient());
            preparedStatement.setString(2, updateClient.getNameProject());
            preparedStatement.setString(3, updateClient.getAddress());
//            preparedStatement.setBi(4, updateClient.getClientId().t);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(BigInteger id) {
        try (Connection connection = new MysqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM web_java_project_database.client WHERE (id=" + id + ")";
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Client> readAll() {
        try (Connection connection = new MysqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM web_java_project_database.client";
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                BigInteger clientId = new BigInteger(id);
                String name = resultSet.getString(2);
                String project = resultSet.getString(3);
                String address = resultSet.getString(4);
                Client client = new Client(clientId, name, project, address);
                clients.add(client);
            }
            return clients;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Client readById(BigInteger id) {
        try (Connection connection = new MysqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT *  FROM web_java_project_database.client  WHERE (id=" + id + ")";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String name = resultSet.getString(2);
                String project = resultSet.getString(2);
                String address = resultSet.getString(2);

                Client client = new Client(id, name, project, address);
                return client;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Client> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<Client> readAllByHqlQuery(String sql) {
        return null;
    }

}
