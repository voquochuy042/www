package backend.services;

import backend.models.ProductImage;
import backend.repositories.ProductImageRepository;

public class ProductImageService {
    private final ProductImageRepository productImageRepository;

    public ProductImageService() {
        productImageRepository = new ProductImageRepository();
    }
    public ProductImage getPatImage(long id){
        return productImageRepository.getImageByProductId(id);
    }
}
