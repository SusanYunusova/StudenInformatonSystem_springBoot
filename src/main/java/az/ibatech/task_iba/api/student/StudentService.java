package az.ibatech.task_iba.api.student;

import az.ibatech.task_iba.db.entity.Student;
import az.ibatech.task_iba.db.service.impl.StudentDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService {
    private final StudentDBService studentDBService;

    public StudentService(StudentDBService studentDBService) {
        this.studentDBService = studentDBService;
    }

    /**
     * FunctionalProgramming for reducing code repeating and clean code
     */
    Function<Optional<?>, ResponseEntity<?>> dbFunction = (optionalData) ->
            optionalData
                    .map(data -> {
                        log.info(data + "found");
                        return new ResponseEntity<>(data, HttpStatus.OK);
                    })
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));


    /**
     * CRUD REPOSITORIES student to database by functional programming method
     * and search methods by selected parameters
     *
     * @param student
     * @return
     */
    public ResponseEntity<?> saveOrUpdate(Student student) {
        log.info("save or update studentService");
        return dbFunction.apply(studentDBService.saveUpdate(student));
    }

    public ResponseEntity<?> delete(Student student) {
        log.info("delete studentService");
        return dbFunction.apply(studentDBService.saveUpdate(student));
    }


    public ResponseEntity<?> getByID(long idStudent) {
        log.info("getById studentService");
        return dbFunction.apply(studentDBService.getById(idStudent));
    }

    public ResponseEntity<?> getAll(){
        log.info("getting All student list");
        List<Student> studentList = studentDBService.getAll();
        if (studentList.isEmpty()){
            log.info("getAll is empty...");
            return new ResponseEntity<>(studentList,HttpStatus.NO_CONTENT);
        }else{
            log.info("list has found...");
            return new ResponseEntity<>(studentList,HttpStatus.OK);
        }
    }



}
