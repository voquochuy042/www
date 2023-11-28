package backend.services;

import backend.models.ProductPrice;
import backend.repositories.ProductPriceRepository;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ProductPriceService {
    private final ProductPriceRepository productPriceRepository;

    public ProductPriceService() {
        productPriceRepository = new ProductPriceRepository();
    }

    public Double getPriceOfProduct(long productId){
        return productPriceRepository.getPrice(productId);
    }
    public Map<LocalDateTime, Double> getDateAndPriceByProductId(long productId) {
        return productPriceRepository.getDateAndPriceByProductId(productId);
    }
}
