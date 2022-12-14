package mk.finki.ukim.mk.lab.repository;

//import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Course;
import mk.finki.ukim.mk.lab.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseId(Long courseId);

    List<Student> findStudentsByCourseId(Long courseId);

    void deleteByCourseId(Long courseId);
}
