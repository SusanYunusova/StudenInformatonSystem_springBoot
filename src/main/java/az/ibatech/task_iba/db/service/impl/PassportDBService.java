package az.ibatech.task_iba.db.service.impl;

import az.ibatech.task_iba.db.entity.Passport;
import az.ibatech.task_iba.db.service.MySqlDBService;

import java.util.List;
import java.util.Optional;

public class PassportDBService implements MySqlDBService<Passport> {
    @Override
    public Optional<Passport> saveUpdate(Passport passport) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Passport passport) {
        return false;
    }

    @Override
    public Optional<Passport> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Passport> getAll() {
        return null;
    }

    @Override
    public List<Passport> getAllBy(long id) {
        return null;
    }
}
