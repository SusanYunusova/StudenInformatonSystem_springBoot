package az.ibatech.task_iba.db.service;

import java.util.List;
import java.util.Optional;

public interface MySqlDBService<A> {
    /***
     * @author Susan Yunusova
     * Interface for MySql dbService
     * @param a
     * @return
     */
    Optional<A> saveUpdate(A a);
    boolean delete(A a);
    Optional<A> getById(long id);
    List<A> getAll();
    List<A> getAllBy(long id);
}
