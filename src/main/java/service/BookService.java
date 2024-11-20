package service;

import model.Book;
import model.dto.BookDto;

public interface BookService extends BaseService<Book> {

    BookDto findBookByIsbn(String isbn);

    BookDto findBookByTitle(String title);

    BookDto findById(Long id);
}
