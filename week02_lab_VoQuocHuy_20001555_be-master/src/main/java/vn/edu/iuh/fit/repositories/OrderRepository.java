package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private final EntityManager em;
    private final EntityTransaction ts;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderRepository() {
        em = Connection.getInstance().getEntityManager();
        ts = em.getTransaction();
    }

    public List<Order> getAll(int page) {
        try {
            return em.createNamedQuery("Order.getAll", Order.class)
                    .setFirstResult((page - 1) * 20)
                    .setMaxResults(20)
                    .getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return new ArrayList<>();
    }
    public boolean add(Order t) {
        try {
            ts.begin();
            em.persist(t);
            ts.commit();
            return true;
        } catch (Exception e) {
            ts.rollback();
            logger.error(e.getMessage());
        }

        return false;
    }

    public boolean update(Order t) {
        try {
            ts.begin();
            em.merge(t);
            ts.commit();
            return true;
        } catch (Exception e) {
            ts.rollback();
            logger.error(e.getMessage());
        }

        return false;
    }
    public Optional<Order> findById(long id) {
        try {
            return Optional.of(em.find(Order.class, id));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }
}
