package repository;

import model.Librarian;

import java.util.Optional;

public interface LibrarianRepository extends BaseRepository<Librarian> {

    Optional<Librarian> findByFirstName(String name);

    Optional<Librarian> findByNationalCode(String nationalCode);
}