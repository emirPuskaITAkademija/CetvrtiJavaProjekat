package advanced.konsultacije;
//car person

import java.sql.SQLException;
import java.util.List;


public interface Dao<E> {

    List<E> getAll() throws SQLException;
    
    E get(int primaryKey) throws SQLException;
    
    void delete(E entity) throws SQLException;
    
    void save(E entity)throws SQLException;
    
    void update(E entity) throws SQLException;
}
