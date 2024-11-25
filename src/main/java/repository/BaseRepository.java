package repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {

    void save(T object);

    void delete(Long object);

    void update(T object);

    Optional<T> findById(Long id);

    List<T> getAll();
}