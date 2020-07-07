package az.ibatech.task_iba.api.student;

import az.ibatech.task_iba.db.entity.Student;
import az.ibatech.task_iba.db.service.impl.StudentDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Slf4j
public class StudentService {
    private final StudentDBService studentDBService;

    public StudentService(StudentDBService studentDBService) {
        this.studentDBService = studentDBService;
    }
    Function<Optional<?>, ResponseEntity<?>> dbFunction = (optionalData) ->
            optionalData
                    .map(data -> {
                        log.info(data+"found");
                      return   new ResponseEntity<>(data, HttpStatus.OK);
                    })
                    .orElseGet(()->new ResponseEntity<>(HttpStatus.NO_CONTENT));

    public ResponseEntity<?> save(Student student) {
        return dbFunction.apply(studentDBService.saveUpdate(student));
    }
}
