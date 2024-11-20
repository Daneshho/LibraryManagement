package service;

import java.util.List;

public interface BaseService<T> {

    void save(T object);

    void delete(Long object);

    void update(T object);

    List<T> getAll();
}