package az.ibatech.task_iba.api.passport;

import az.ibatech.task_iba.db.entity.Course;
import az.ibatech.task_iba.db.entity.Passport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/passport")
public class PassportController {
    private final PassportService passportService;


    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }


    @PostMapping()
    public ResponseEntity<?> create(Passport passport){
        log.info("save...");
        return passportService.saveOrUpdate(passport);

    }
    @PutMapping()
    public ResponseEntity<?> update(Passport passport){
        log.info("update...");
        return passportService.saveOrUpdate(passport);

    }
    @DeleteMapping()
    public ResponseEntity<?> delete(Passport passport){
        log.info("delete...");
        return passportService.saveOrUpdate(passport);

    }
    @GetMapping()
    public ResponseEntity<?> getAll(){
        log.info("getting All");
        return passportService.getAll();

    }
    @GetMapping("/{idCourse}")
    public ResponseEntity<?> getByID(@PathVariable long idCourse){
        log.info("getting by id:{}",idCourse);
        return passportService.getByID(idCourse);

    }



}
