package repository.impl;

import databse.DatabaseManager;
import exception.RequestFailedException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import model.Book;
import repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    EntityManagerFactory emf = DatabaseManager.getFactory();

    @Override
    public Optional<Book> findByIsbn(String isbn) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            String FIND_BY_ISBN = "FROM Book b WHERE b.isbn = :isbn";
            TypedQuery<Book> query = em.createQuery(FIND_BY_ISBN, Book.class);
            query.setParameter("isbn", isbn);
            List<Book> books = query.getResultList();
            return Optional.ofNullable(books.get(0));
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException("This ISBN does not exist" + e.getMessage());
        }
    }

    @Override
    public Optional<Book> findByTitle(String title) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            String FIND_BY_TITLE = "FROM Book b WHERE b.title = :title";
            TypedQuery<Book> query = em.createQuery(FIND_BY_TITLE, Book.class);
            query.setParameter("title", title);
            List<Book> books = query.getResultList();
            return Optional.ofNullable(books.get(0));
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException("This Title does not exist" + e.getMessage());
        }
    }

    @Override
    public void save(Book object) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RequestFailedException(e.getMessage());
        }
    }

    @Override
    public void delete(Long object) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException(e.getMessage());
        }
    }

    @Override
    public void update(Book object) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException(e.getMessage());
        }
    }

    @Override
    public Optional<Book> findById(Long id) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            String FIND_BY_ID = "FROM Book b WHERE b.id = :id";
            TypedQuery<Book> query = em.createQuery(FIND_BY_ID, Book.class);
            query.setParameter("id", id);
            List<Book> books = query.getResultList();
            return Optional.ofNullable(books.get(0));
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException(e.getMessage());
        }
    }

    @Override
    public List<Book> getAll() throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            TypedQuery<Book> query = em.createQuery("FROM Book", Book.class);
            return query.getResultList();
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException(e.getMessage());
        }
    }
}