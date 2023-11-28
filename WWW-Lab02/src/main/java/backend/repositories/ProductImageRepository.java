package backend.repositories;

import backend.enums.ProductStatus;
import backend.models.Product;
import backend.models.ProductImage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductImageRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductImageRepository() {
        em = ConnectDB.getInstance().getEntityManagerFactory().createEntityManager();
        transaction = em.getTransaction();
    }
    public ProductImage getImageByProductId(long productId){
       return em.createNamedQuery("ProductImage.getImage", ProductImage.class)
                .setParameter("id",productId)
                .getSingleResult();
    }
}
