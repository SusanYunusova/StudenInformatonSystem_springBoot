package az.ibatech.task_iba.db.service.impl;

import az.ibatech.task_iba.db.entity.Student;
import az.ibatech.task_iba.db.repo.StudentRepository;
import az.ibatech.task_iba.db.service.MySqlDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentDBService implements MySqlDBService<Student> {
    private final StudentRepository studentRepository;

    public StudentDBService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Optional<Student> saveUpdate(Student student) {
        try {
            log.info("trying to save student to db...");
            studentRepository.save(student);
            return Optional.of(student);
        } catch (Exception e) {
            log.error("error saving student to db...{}", e, e);
            return Optional.empty();
        }
    }


    @Override
    public boolean delete(Student student) {
        try {
            log.info("trying to delete student from db");
            studentRepository.delete(student);
            return true;
        } catch (Exception e) {
            log.error("error from deleting student from db{}", e, e);
            return false;
        }
    }

    @Override
    public Optional<Student> getById(long idStudent) {
        try {
            log.info("trying to get student by id from db");
            return studentRepository.findByIdStudent(idStudent);
        } catch (Exception e) {
            log.error("error getting by idStudent from Db{}{}", e, e);
            return Optional.empty();
        }
    }

    @Override
    public List<Student> getAll() {
        try {
            log.info("trying to getAll students from db");
            return studentRepository.findAll();
        } catch (Exception e) {
            log.error("error getting all from db{}{}", e, e);
            return new ArrayList<>();
        }

    }

    @Override
    public List<Student> getAllBy(long id) {

        return null;
    }
}
