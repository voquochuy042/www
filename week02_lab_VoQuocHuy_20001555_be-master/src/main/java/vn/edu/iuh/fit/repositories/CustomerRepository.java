package vn.edu.iuh.fit.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class CustomerRepository {
    private final EntityManager em;
    private final EntityTransaction ts;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerRepository() {
        em = Connection.getInstance().getEntityManager();
        ts = em.getTransaction();
    }

    public List<Customer> getAllCustomer(int page){
        try{
            TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class)
                    .setFirstResult((page-1)*20)
                    .setMaxResults(20);
            return query.getResultList();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public boolean update(Customer c) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(c);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            logger.error("Error updating Customer: " + e.getMessage());
        } finally {
            em.close();
        }

        return false;
    }


    public boolean add(Customer c){
        try {
            ts.begin();
            em.persist(c);
            ts.commit();
            return true;
        }catch (Exception err){
            logger.error(err.getMessage());
        }
        return false;
    }

    public Optional<Customer> findById(long id) {
        try {
            return Optional.of(em.find(Customer.class, id));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }
}
