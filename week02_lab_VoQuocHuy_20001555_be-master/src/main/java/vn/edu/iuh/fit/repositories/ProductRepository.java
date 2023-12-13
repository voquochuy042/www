package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final EntityManager em;
    private final EntityTransaction ts;
    private final Logger logger = LoggerFactory.getLogger(ProductRepository.class.getName());

    public ProductRepository() {
        em = Connection.getInstance().getEntityManager();
        ts = em.getTransaction();
    }
    public List<Product> getAll(int page) {
        try {
            return em.createNamedQuery("Product.getAll", Product.class)
                    .setFirstResult((page - 1) * 20)
                    .setMaxResults(20)
                    .getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return new ArrayList<>();
    }

    public Optional<Product> findById(long id) {
        try {
            return Optional.of(em.find(Product.class, id));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    public boolean updateStatus(long id, ProductStatus status) {
        try {
            ts.begin();
            int numberUpdate = em.createNamedQuery("Product.updateStatus")
                    .setParameter("status", status)
                    .setParameter("id", id)
                    .executeUpdate();
            ts.commit();
            return numberUpdate > 0;
        } catch (Exception e) {
            ts.rollback();
            logger.error(e.getMessage());
        }

        return false;
    }
}
