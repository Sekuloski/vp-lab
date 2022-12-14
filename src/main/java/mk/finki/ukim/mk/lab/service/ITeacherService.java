package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface ITeacherService {
    List<Teacher> findAll();
    Optional<Teacher> findById(Long id);
}
