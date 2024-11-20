package repository;

import model.Book;

import java.util.Optional;

public interface BookRepository extends BaseRepository<Book> {

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findByTitle(String title);
}
