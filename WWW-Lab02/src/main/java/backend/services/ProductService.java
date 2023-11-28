package backend.services;

import backend.dto.Cart;
import backend.enums.ProductStatus;
import backend.models.Product;
import backend.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    public void insertProduct(Product product) {
        productRepository.insertProduct(product);
    }

    public void deleteProduct(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            final var employeeStatus = ProductStatus.TERMINATED;
            productRepository.setStatus(product,employeeStatus);
            productRepository.update(product);
        }
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public List<Cart> getProductByCart(ArrayList<Cart> carts){
        return productRepository.getCartProducts(carts);
    }


}
