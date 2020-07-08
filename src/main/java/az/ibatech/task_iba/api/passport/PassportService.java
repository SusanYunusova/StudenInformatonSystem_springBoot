package az.ibatech.task_iba.api.passport;

import az.ibatech.task_iba.db.entity.Passport;
import az.ibatech.task_iba.db.entity.Student;
import az.ibatech.task_iba.db.service.impl.PassportDBService;
import az.ibatech.task_iba.db.service.impl.StudentDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Slf4j
public class PassportService {
    private final PassportDBService passportDBService;

    public PassportService(PassportDBService passportDBService) {
        this.passportDBService = passportDBService;
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
     * CRUD REPOSITORIES passport to database by functional programming method
     * and search methods by selected parameters
     *
     * @param passport
     * @return
     */
    public ResponseEntity<?> saveOrUpdate(Passport passport) {
        log.info("save or update passportService");
        return dbFunction.apply(passportDBService.saveUpdate(passport));
    }

    public ResponseEntity<?> delete(Passport passport) {
        log.info("delete passportService");
        return dbFunction.apply(passportDBService.saveUpdate(passport));
    }


    public ResponseEntity<?> getByID(long idPassport) {
        log.info("getById passportService");
        return dbFunction.apply(passportDBService.getById(idPassport));
    }

    public ResponseEntity<?> getAll(){
        log.info("getting All passport list");
        List<Passport> passportList = passportDBService.getAll();
        if (passportList.isEmpty()){
            log.info("getAll is empty...");
            return new ResponseEntity<>(passportList,HttpStatus.NO_CONTENT);
        }else{
            log.info("list has found...");
            return new ResponseEntity<>(passportList,HttpStatus.OK);
        }
    }



}
