package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IStudentRepository extends JpaRepository<Student, String> {
    List<Student> findAllByName(String text);
    Student findByUsername(String username);
}
