package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.mk.lab.model.attributes.TeacherFullname;
import mk.finki.ukim.mk.lab.model.attributes.TeacherFullnameConverter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = TeacherFullnameConverter.class)

    private TeacherFullname fullname;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfEmployment;

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return fullname.getName();
    }

    public String getSurname() {
        return fullname.getSurname();
    }

    public Teacher(TeacherFullname fullname) {
        this.fullname = fullname;
        this.dateOfEmployment = LocalDate.now();
    }
}
