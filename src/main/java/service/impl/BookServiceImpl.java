package service.impl;

import exception.RequestFailedException;
import model.Book;
import model.dto.BookDto;
import repository.impl.BookRepositoryImpl;
import service.BookService;
import util.ApplicationContext;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    BookRepositoryImpl bookRepository = ApplicationContext.getBookRepository();

    @Override
    public BookDto findBookByIsbn(String isbn) {
        BookDto bookDto = null;
        try {
            Optional<Book> byIsbn = bookRepository.findByIsbn(isbn);
            if (byIsbn.isPresent()) {
                bookDto = new BookDto();
                bookDto.setIsbn(byIsbn.get().getIsbn());
                bookDto.setTitle(byIsbn.get().getTitle());
            }
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return bookDto;
    }

    @Override
    public BookDto findById(Long id) {
        BookDto bookDto = null;
        try {
            Optional<Book> byId = bookRepository.findById(id);
            if (byId.isPresent()) {
                bookDto = new BookDto();
                bookDto.setIsbn(byId.get().getIsbn());
                bookDto.setTitle(byId.get().getTitle());
            }
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return bookDto;
    }

    @Override
    public BookDto findBookByTitle(String title) {
        BookDto bookDto = null;
        try {
            Optional<Book> byTitle = bookRepository.findByTitle(title);
            if (byTitle.isPresent()) {
                bookDto = new BookDto();
                bookDto.setIsbn(byTitle.get().getIsbn());
                bookDto.setTitle(byTitle.get().getTitle());
            }
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return bookDto;
    }

    @Override
    public void save(Book object) {
        try {
            bookRepository.save(object);
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long object) {
        try {

            bookRepository.delete(object);
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Book object) {
        try {
            bookRepository.update(object);
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public List<Book> getAll() {
        try {
            bookRepository.getAll();
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return bookRepository.getAll();
    }
}
