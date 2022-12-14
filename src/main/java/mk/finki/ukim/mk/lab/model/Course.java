package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.mk.lab.model.enumerations.Type;

import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long courseId;
    String name;
    String description;
    @Enumerated(EnumType.STRING)
    Type type;
    @OneToMany
    List<Student> students;
    @ManyToOne
    Teacher teacher;

    public Course() {
        this.name = null;
        this.description = null;
        this.students = null;
        this.teacher = null;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Course(String name, String description, List<Student> students, Teacher teacher, Type type) {
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
        this.type = type;
    }
}
