package az.ibatech.task_iba.api.student;

import az.ibatech.task_iba.db.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping()
    public ResponseEntity<?> create(Student student){
        log.info("save...");
        return studentService.saveOrUpdate(student);

    }
    @PutMapping()
    public ResponseEntity<?> update(Student student){
        log.info("update...");
        return studentService.saveOrUpdate(student);

    }
    @DeleteMapping()
    public ResponseEntity<?> delete(Student student){
        log.info("delete...");
        return studentService.saveOrUpdate(student);

    }
    @GetMapping()
    public ResponseEntity<?> getAll(){
        log.info("getting All");
        return studentService.getAll();

    }
    @GetMapping("/{idStudent}")
    public ResponseEntity<?> getByID(@PathVariable long idStudent){
        log.info("getting by id:{}",idStudent);
        return studentService.getByID(idStudent);

    }



}
