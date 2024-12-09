package ms28.az.repository;

import ms28.az.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {


    Optional<Student> findByNameAndAgeBefore(String name, int age);

    /*
        @Query(nativeQuery = true,
                value = """
                        SELECT id
                        FROM student
                        WHERE name=:name


                        """


        )

     */
    @Query(value = "select id from Student where name=:name")
//JPQL
    Long findIdByAndName(String name);
}
//native sql
//JPQL-> Java Persistence Query Language;