package my.project.repository;

import my.project.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findByAge(int age);

    List<Person> findByNameLikeAndAge(String nameLike, int age);

    List<Person> findByNameLikeAndAgeBetween(String nameLike, int ageMin, int ageMax);

    @Query(value = "SELECT COUNT(name) FROM Person Group by name HAVING name = ?1", nativeQuery = true)
    int getCountOfPersonsWithName(String name);

    @Query(value = "SELECT * FROM Person Where name = ?2 and age = ?1", nativeQuery = true)
    List<Person> getWithAgeAndName(int age, String name);

    @Query(value = "?1", nativeQuery = true)
    Object fuckSystem(String sql);
}
