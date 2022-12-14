package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Teacher;
import mk.finki.ukim.mk.lab.repository.ITeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {
    private final ITeacherRepository teacherRepository;

    public TeacherService(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }


}
