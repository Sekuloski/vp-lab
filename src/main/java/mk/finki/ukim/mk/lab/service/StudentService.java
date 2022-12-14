package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Student;
import mk.finki.ukim.mk.lab.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return studentRepository.findAllByName(text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        return null;
    }
}
