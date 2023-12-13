package vn.edu.iuh.fit.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class EmployeeRepository {
    private final EntityManager em;
    private final EntityTransaction ts;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRepository() {
        em = Connection.getInstance().getEntityManager();
        ts = em.getTransaction();
    }

    public static void main(String[] args) {
        EmployeeRepository repository= new EmployeeRepository();
//        List<Employee> list = repository.getAllEmployee(1);
//        System.out.println(list);
        Optional<Employee> employee = repository.findById(1);
        System.out.println(employee);
    }
    public List<Employee> getAllEmployee(int page){
        try{
            TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class)
                    .setFirstResult((page-1)*20)
                    .setMaxResults(20);
            return query.getResultList();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public boolean update(Employee employee) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(employee);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            logger.error("Error updating employee: " + e.getMessage());
        } finally {
            em.close();
        }

        return false;
    }
    public boolean updateStatus(long id, EmployeeStatus status) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            int numberUpdate = em.createNamedQuery("Employee.updateStatus")
                    .setParameter("status", status)
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
            return numberUpdate > 0;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            logger.error("Error updating employee status: " + e.getMessage());
        } finally {
            // Close the EntityManager here if needed
        }

        return false;
    }

    public boolean add(Employee e){
        try {
            ts.begin();
            em.persist(e);
            ts.commit();
            return true;
        }catch (Exception err){
            logger.error(err.getMessage());
        }
        return false;
    }

    public Optional<Employee> findById(long id) {
        try {
            return Optional.of(em.find(Employee.class, id));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }
}