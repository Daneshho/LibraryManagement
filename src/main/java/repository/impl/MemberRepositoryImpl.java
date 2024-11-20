package repository.impl;

import databse.DatabaseManager;
import exception.RequestFailedException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import model.Member;
import repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberRepositoryImpl implements MemberRepository {

    EntityManagerFactory emf = DatabaseManager.getFactory();

    @Override
    public Optional<Member> findByNationalCode(String nationalCode) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            String FIND_BY_NATIONAL_CODE = "from Member m where m.nationalCode = :nationalCode";
            TypedQuery<Member> query = em.createQuery(FIND_BY_NATIONAL_CODE, Member.class);
            query.setParameter("nationalCode", nationalCode);
            List<Member> members = query.getResultList();
            return Optional.ofNullable(members.get(0));

        } catch (EntityNotFoundException e) {
            throw new RequestFailedException(e.getMessage());
        }
    }

    @Override
    public void save(Member object) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
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
    public void update(Member object) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException(e.getMessage());
        }
    }

    @Override
    public Optional<Member> findById(Long id) throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            String FIND_BY_ID = "from Member m where m.id = :id";
            TypedQuery<Member> query = em.createQuery(FIND_BY_ID, Member.class);
            query.setParameter("id", id);
            List<Member> members = query.getResultList();
            return Optional.ofNullable(members.get(0));
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException(e.getMessage());
        }
    }

    @Override
    public List<Member> getAll() throws RequestFailedException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Member> query = em.createQuery("from Member", Member.class);
            return query.getResultList();
        } catch (EntityNotFoundException e) {
            throw new RequestFailedException(e.getMessage());
        }
    }
}