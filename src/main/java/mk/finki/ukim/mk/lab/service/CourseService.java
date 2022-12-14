package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Course;
import mk.finki.ukim.mk.lab.model.Student;
import mk.finki.ukim.mk.lab.model.Teacher;
import mk.finki.ukim.mk.lab.model.enumerations.Type;
import mk.finki.ukim.mk.lab.repository.ICourseRepository;
//import mk.finki.ukim.mk.lab.repository.StudentRepository;
import mk.finki.ukim.mk.lab.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {
    private final ICourseRepository courseRepository;
    private final IStudentRepository studentRepository;

    public CourseService(ICourseRepository courseRepository, IStudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findStudentsByCourseId(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = this.studentRepository.findByUsername(username);
        Course course = this.courseRepository.findByCourseId(courseId);
        course.getStudents().add(student);
        return this.courseRepository.save(course);
    }

    @Override
    public Optional<Course> save(String name, String description, Teacher teacher, Type type) {
        Course course = new Course(name, description, new ArrayList<>(), teacher, type);
        return Optional.of(this.courseRepository.save(course));
    }

    @Override
    public void deleteById(Long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }
}
