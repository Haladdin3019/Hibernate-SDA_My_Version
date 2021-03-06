package jdbc.student;

import java.util.List;
import java.util.Map;

public interface AbstractRepositoryII<T> {

    T get(int id);

    List<T> getAll();

    boolean delete(T object);

    boolean insert(T object);

    boolean update(int id, T object);



}
