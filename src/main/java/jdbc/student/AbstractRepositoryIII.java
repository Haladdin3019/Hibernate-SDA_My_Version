package jdbc.student;

import java.util.List;

public interface AbstractRepositoryIII<T> {

    T get(int id);

    List<T> getAll();

    boolean delete(T object);

    boolean insert(T object);

    boolean update(int id, T object);

    boolean addRating(T object, float rating);

}
