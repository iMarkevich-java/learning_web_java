package my.project.dao;

import java.math.BigInteger;
import java.util.List;

public interface Dao<T> {

    void create(T t);

    void update(T t);

    void delete(BigInteger id);

    List<T> readAll();

    T readById(BigInteger id);

    List<T> readAllByParameterAndValues(String parameter, String values);

    List<T> readAllByHqlQuery(String sql);

}
