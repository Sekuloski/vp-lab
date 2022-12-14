package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Grade;

import java.time.LocalDateTime;
import java.util.List;

public interface IGradeRepository {
    List<Grade> filterByDate(LocalDateTime from, LocalDateTime to);
}
