package az.ibatech.task_iba.db.service.impl;

import az.ibatech.task_iba.db.entity.Student;
import az.ibatech.task_iba.db.service.MySqlDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentDBService implements MySqlDBService<Student> {
    @Override
    public Optional<Student> saveUpdate(Student student) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Student student) {
        return false;
    }

    @Override
    public Optional<Student> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public List<Student> getAllBy(long id) {
        return null;
    }
}
