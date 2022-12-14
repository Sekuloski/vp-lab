package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> listAll();
    List<Student> searchByNameOrSurname(String text);
    Student save(String username, String password, String name, String surname);
}