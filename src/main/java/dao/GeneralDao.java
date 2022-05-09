package dao;

import java.util.List;

public interface GeneralDao <T> {

    T add(T t);

    T update(T t);

    boolean delete(T t);

    T get(int id);

    List<T> getAll();

}
