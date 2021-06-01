package my.project.dao;

import my.project.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonJdbcDao implements PersonDao {


    public static void main(String[] args) {
//        ArrayList<Person> people = new ArrayList<>();
//        people.add(new Person(105, "Vova", 35));
//        people.add(new Person(107, "Ivan", 55));
//        people.add(new Person(106, "Sergej", 45));
//        new PersonJdbcDao().createManyPersons(people);
//        new PersonJdbcDao().deletePerson(3);
        new PersonJdbcDao().updatePerson(100, "vovan", 1000);
//        new PersonJdbcDao().readAllPersons();
//        new PersonJdbcDao().readPersonById(1);
    }

    public void createManyPersons(List<Person> persons) {
        try (Connection connection = new MysqlJdbcUtil().getConnection()) {
            connection.setAutoCommit(false);
            try (Statement statement = connection.createStatement()) {

                for (Person person : persons) {
                    String sql = "INSERT INTO `my_database`.`person` (`id`,`name`, `age`) VALUES ('"
                            + person.getPersonId() + "','" + person.getName() + "'," + person.getAge() + ")";
                    statement.execute(sql);
                }
                connection.commit();

            } catch (SQLException throwables) {
                connection.rollback();
                throwables.printStackTrace();
            }
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createPerson(int id, String name, int age) {

    }

    @Override
    public void createPerson(Person person) {

        try (Connection connection = new MysqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO `my_database`.`person` (`name`, `age`) VALUES ('" + person.getName() +
                    "'," + person.getAge() + ")";
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updatePerson(int id, String updateName, int updateAge) {
        String sql = "UPDATE `my_database`.`person` SET `name` = ?, `age` = ? WHERE (`id` = ?)";
        try (Connection connection = new MysqlJdbcUtil().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updateName);
            preparedStatement.setInt(2, updateAge);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deletePerson(int id) {
        try (Connection connection = new MysqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM `my_database`.`person` WHERE (`id` = " + id + ")";
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Person> readAllPersons() {
        try (Connection connection = new MysqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM my_database.person";
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Person> people = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString(2);
                int age = resultSet.getInt("age");
                Person person = new Person(id, name, age);
                people.add(person);
            }
            return people;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readPersonById(int id) {
        try (Connection connection = new MysqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT *  FROM my_database.person  WHERE (`id` = " + id + ")";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String name = resultSet.getString(2);
                int age = resultSet.getInt("age");
                Person person = new Person(id, name, age);
                return person;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
