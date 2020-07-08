package az.ibatech.task_iba.db.service.impl;

import az.ibatech.task_iba.db.entity.Passport;
import az.ibatech.task_iba.db.repo.PassportRepository;
import az.ibatech.task_iba.db.service.MySqlDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class PassportDBService implements MySqlDBService<Passport> {
    private final PassportRepository passportRepository;

    public PassportDBService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }


    @Override
    public Optional<Passport> saveUpdate(Passport passport) {
        try {
            log.info("trying to save passport to db...");
            passportRepository.save(passport);
            return Optional.of(passport);
        } catch (Exception e) {
            log.error("error saving passport to db...{}", e, e);
            return Optional.empty();
        }
    }


    @Override
    public boolean delete(Passport passport) {
        try {
            log.info("trying to delete passport from db");
            passportRepository.delete(passport);
            return true;
        } catch (Exception e) {
            log.error("error from deleting passport from db{}", e, e);
            return false;
        }
    }

    @Override
    public Optional<Passport> getById(long idPassport) {
        try {
            log.info("trying to get passport  by id from db");
            return passportRepository.findById(idPassport);
        } catch (Exception e) {
            log.error("error getting by idPassport from Db{}{}", e, e);
            return Optional.empty();
        }
    }

    @Override
    public List<Passport> getAll() {
        try {
            log.info("trying to getAll passport  from db");
            return passportRepository.findAll();
        } catch (Exception e) {
            log.error("error getting all from db{}{}", e, e);
            return new ArrayList<>();
        }

    }

    @Override
    public List<Passport> getAllBy(long id) {
        return null;
    }
}
