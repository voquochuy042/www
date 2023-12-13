package vn.edu.iuh.fit.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private final EntityManager entityManager;
    private static Connection connection;

    public Connection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab02");
        entityManager = emf.createEntityManager();
    }
    public static Connection getInstance(){
        if (connection==null)
            connection = new Connection();
        return connection;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public static void main(String[] args) {
        EntityManager em = Connection.getInstance().getEntityManager();
        System.out.println(em);
    }
}
