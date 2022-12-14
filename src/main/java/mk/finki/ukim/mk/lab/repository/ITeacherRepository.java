package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findAll();
}
