package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Course;
import mk.finki.ukim.mk.lab.model.Student;
import mk.finki.ukim.mk.lab.model.Teacher;
import mk.finki.ukim.mk.lab.model.enumerations.Type;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    List<Course> listAll();
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);
    Optional<Course> save(String name, String description, Teacher teacher, Type type);

    void deleteById(Long id);

    Optional<Course> findById(Long id);
}