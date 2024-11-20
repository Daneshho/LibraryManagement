package repository.impl;

import databse.DatabaseManager;
import exception.RequestFailedException;
import jakarta.persistence.*;
import model.Librarian;
import repository.LibrarianRepository;

import java.util.List;
import java.util.Optional;

public class LibrarianRepositoryImpl implements LibrarianRepository {

    EntityManagerFactory emf = DatabaseManager.getFactory();

    @Override
    public Optional<Librarian> findByFirstName(String firstName) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {

            String FIND_BY_NAME = "from Librarian l where l.firstName = :firstName";
            TypedQuery<Librarian> query = em.createQuery(FIND_BY_NAME, Librarian.class);
            query.setParameter("firstName", firstName);
            List<Librarian> librarians = query.getResultList();
            return Optional.ofNullable(librarians.isEmpty() ? null : librarians.get(0));
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException("Librarian not found" + e.getMessage());
        }
    }

    @Override
    public Optional<Librarian> findByNationalCode(String nationalCode) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            String FIND_BY_NATIONAL_CODE = "SELECT l FROM Librarian l WHERE l.nationalCode = :nationalCode";
            TypedQuery<Librarian> query = em.createQuery(FIND_BY_NATIONAL_CODE, Librarian.class);
            query.setParameter("nationalCode", nationalCode);
            List<Librarian> librarians = query.getResultList();
            return Optional.ofNullable(librarians.isEmpty() ? null : librarians.get(0));
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException("Librarian not found" + e.getMessage());
        }
    }

    @Override
    public void save(Librarian object) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException("Librarian Is Exist" + e.getMessage());
        }
    }

    @Override
    public void delete(Long object) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException("Librarian Is Not Exist" + e.getMessage());
        }
    }

    @Override
    public void update(Librarian object) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException("Librarian Is Not Exist" + e.getMessage());
        }
    }

    @Override
    public Optional<Librarian> findById(Long id) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            String FIND_BY_ID = "from Librarian l where l.id = :id";
            TypedQuery<Librarian> query = em.createQuery(FIND_BY_ID, Librarian.class);
            query.setParameter("id", id);
            List<Librarian> librarians = query.getResultList();
            return Optional.ofNullable(librarians.isEmpty() ? null : librarians.get(0));
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException("Librarian Is Not Exist" + e.getMessage());
        }
    }

    @Override
    public List<Librarian> getAll() throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Librarian> query = em.createQuery("from Librarian", Librarian.class);
            return query.getResultList();
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException("Librarian Is Not Exist" + e.getMessage());
        }
    }
}