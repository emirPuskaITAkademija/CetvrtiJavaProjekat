package advanced.konsultacije;
//car person

import java.sql.SQLException;
import java.util.List;

//CRUD template
//Create
//Read
//Update
//Delete
public interface Dao<E> {

    //CREATE
    void save(E entity) throws SQLException;

    //READ
    List<E> getAll() throws SQLException;

    E get(int primaryKey) throws SQLException;

    //UPDATE
    void update(E entity) throws SQLException;

    //DELETE
    void delete(E entity) throws SQLException;
}
