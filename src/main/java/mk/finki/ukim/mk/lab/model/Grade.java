package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Character grade;
    @OneToOne
    private Student student;
    @OneToOne
    private Course course;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public Grade(Character grade, Student student, Course course) {
        this.grade = grade;
        this.student = student;
        this.course = course;
        this.timestamp = LocalDateTime.now();
    }

    public Grade() {

    }
}
